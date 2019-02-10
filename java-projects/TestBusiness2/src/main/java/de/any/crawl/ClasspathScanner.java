/*
 * Created on 29.08.2018
 *
 * Dimensions - Versionierung
 * $Workfile: %PM% $
 * $Revision: %PR% $
 * $Date: %Date% $
 * $Author: %Author% $
 * 
 * (c) Copyright SV Informatik GmbH 2010
 */

package de.any.crawl;

import static java.util.Collections.list;
import static org.springframework.util.ClassUtils.convertClassNameToResourcePath;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

/**
 * Zweck dieser Klasse: <br>
 * Kann verwendet um bestimmte Resourcen im Classpath rekursiv zu durchsuchen.
 * 
 * @author N0008244
 */
public class ClasspathScanner {

	private static final Logger LOGGER = Logger.getLogger(ClasspathScanner.class);

	private JarReader jarReader = new JarReader();
	private String basePackagename;
	private QualifiedClassFilter qualifiedClassSelector;
	private QualifiedFileFilter qualifiedFileFilter;

	/**
	 * @param qualifiedClassFilter
	 * @param qualifiedFileFilter
	 */
	public ClasspathScanner(QualifiedClassFilter qualifiedClassFilter, QualifiedFileFilter qualifiedFileFilter) {
		this.qualifiedClassSelector = qualifiedClassFilter;
		this.qualifiedFileFilter = qualifiedFileFilter;
	}

	@SuppressWarnings("javadoc")
	public List<File> findAllFoldersContainingPathName(String pathname) {
		Enumeration<URL> resources = tryFindindFolders(pathname);
		return enumerationToFileList(resources);
	}

	private Enumeration<URL> tryFindindFolders(String path) {
		try {
			return getClass().getClassLoader().getResources(path);
		} catch (IOException e) {
			LOGGER.info("could not find folder at " + path, e);
		}
		return Collections.emptyEnumeration();
	}

	private List<File> enumerationToFileList(Enumeration<URL> resources) {
		return list(resources).stream().map(url -> new File(url.getFile())).collect(Collectors.toList());
	}

	/**
	 * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
	 * 
	 * @param basePackagename
	 * @return {@link List}
	 */
	public List<Class<?>> findAllClassesInPackageRecursively(String basePackagename) {
		this.basePackagename = basePackagename;
		String pathname = createPathnameFromBasePackagename();
		List<File> dirs = findAllFoldersContainingPathName(pathname);
		return dirs.stream().flatMap(this::findAndLoadClassesInDirectory).collect(Collectors.toList());
	}

	private String createPathnameFromBasePackagename() {
		return convertClassNameToResourcePath(basePackagename);
	}

	private Stream<Class<?>> findAndLoadClassesInDirectory(File directory) {
		Collection<File> listFiles = Collections.emptyList();
		if (directory.isDirectory()) {
			listFiles = findClassesInDirectory(directory);
		}
		if (isJavaArchive(directory)) {
			listFiles = findClassesFilesInJar(directory);
		}
		return loadClassFiles(listFiles);
	}

	private Collection<File> findClassesInDirectory(File directory) {
		return FileUtils.listFiles(directory, new String[] { "class" }, true);
	}

	private List<File> findClassesFilesInJar(File folder) {
		return jarReader.findClassFiles(prepareJarPath(folder));
	}

	private Stream<Class<?>> loadClassFiles(Collection<File> listFiles) {
		return listFiles.stream()//
				.map(this::createFullyQualifiedClassname)//
				.filter(qualifiedClassSelector::isClassQualified)//
				.map(this::tryLoadingClass)//
				.flatMap(this::flattenOptionals);
	}

	private String createFullyQualifiedClassname(File file) {
		String regex = String.format(".*(%s)", basePackagename);
		return file.getAbsolutePath().replaceAll(regex, "$1").replace("\\", ".").replace("/", ".").replace(".class", "");
	}

	private Optional<Class<?>> tryLoadingClass(String fullyQualifiedClassname) {
		try {
			LOGGER.debug("try loading class " + fullyQualifiedClassname);
			return Optional.of(ClassLoader.getSystemClassLoader().loadClass(fullyQualifiedClassname));
		} catch (ClassNotFoundException | NoClassDefFoundError e) {
			LOGGER.error("unable to load class " + fullyQualifiedClassname, e);
		}
		return Optional.empty();
	}

	private Stream<Class<?>> flattenOptionals(Optional<Class<?>> optional) {
		if (optional.isPresent()) {
			Class<?> class1 = optional.get();
			return Stream.of(class1);
		} else {
			return Stream.empty();
		}
	}

	/**
	 * Durchsucht den Ordner basePathInClass im Classpath nach XML-Dateien. Angenommen basePathInClass="META-INF" und der Pfad des
	 * Classpaths ist classpath="C:.../target/classes". Dann wird im Ordner "C:.../target/classes/META-INF" rekursiv nach XML-Dateien
	 * gesucht.
	 * 
	 * @param basePathInClasspath
	 * @return {@link List} Liste aller XML-Dateien im Ordner basePathInClasspath
	 */
	public List<URL> findXmlFilesInBaseFolderRecursively(String basePathInClasspath) {
		List<File> folders = findAllFoldersContainingPathName(basePathInClasspath);
		return folders.stream()//
				.filter(this::isFilepahQualified)//
				.flatMap(this::findSpringXmlFiles)//
				.filter(this::isFilenameQualified)//
				.map(filename -> convertFileToURL(filename, basePathInClasspath)).collect(Collectors.toList());
	}

	private boolean isFilepahQualified(File folder) {
		return qualifiedFileFilter.isFilePathQualified(folder.getPath());
	}

	private boolean isFilenameQualified(File file) {
		return qualifiedFileFilter.isFilenameQualified(file.getName());
	}

	private Stream<File> findSpringXmlFiles(File folder) {
		LOGGER.debug("search xml files in " + folder);
		Stream<File> applicationContextFiles = Stream.empty();
		if (folder.isDirectory()) {
			applicationContextFiles = findFilesInFolder(folder);
		}
		if (isJavaArchive(folder)) {
			applicationContextFiles = findXmlFilesInJar(folder);
		}
		return applicationContextFiles;
	}

	private Stream<File> findFilesInFolder(File folder) {
		Collection<File> listFiles = FileUtils.listFiles(folder, new String[] { "xml" }, true);
		return listFiles.stream();
	}

	private boolean isJavaArchive(File folder) {
		return folder.getAbsolutePath().toUpperCase().contains(".JAR");
	}

	private Stream<File> findXmlFilesInJar(File folder) {
		String jarPath = prepareJarPath(folder);
		return jarReader.findXmlFiles(jarPath).stream();
	}

	private String prepareJarPath(File folder) {
		return PatternMatcher.extractGroupFromStringMatchingPattern(".*\\.jar", folder.getPath()).replace("file:\\", "");
	}

	private URL convertFileToURL(File filename, String basePathInJar) {
		String relativePathInJar = extractRelativePathInJar(filename, basePathInJar);
		return getClass().getResource("/" + relativePathInJar);
	}

	private String extractRelativePathInJar(File filename, String basePathInJar) {
		String regex = String.format("(.*)(%s.*)", basePathInJar);
		String relativePathInJar = PatternMatcher.extractGroupFromStringMatchingPattern(regex, filename.getPath(), 2);
		return relativePathInJar.replace("\\", "/");
	}

}
