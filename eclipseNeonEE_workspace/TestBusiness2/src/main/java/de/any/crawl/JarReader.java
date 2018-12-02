/*
 * Created on 30.08.2018
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

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

public class JarReader {

	@SuppressWarnings("javadoc")
	public List<File> findXmlFiles(String jarPath) {
		return readJarContent(jarPath).stream().filter(this::isXmlFile).map(File::new).collect(Collectors.toList());
	}

	private boolean isXmlFile(String filename) {
		return filename.contains(".xml");
	}

	@SuppressWarnings("javadoc")
	public List<File> findClassFiles(String jarPath) {
		return readJarContent(jarPath).stream().filter(this::isClassFile).map(File::new).collect(Collectors.toList());
	}

	private boolean isClassFile(String filename) {
		return filename.contains(".class");
	}

	@SuppressWarnings("javadoc")
	public List<String> readJarContent(String jarPath) {
		try (JarFile jarFile = new JarFile(jarPath)) {
			Enumeration<JarEntry> jarEntries = jarFile.entries();
			return Collections.list(jarEntries).stream().map(jarEntry -> jarPath + "\\" + jarEntry.getName()).collect(Collectors.toList());
		} catch (IOException e) {
			throw new RuntimeException("unable to load jar : " + jarPath, e);
		}
	}

}
