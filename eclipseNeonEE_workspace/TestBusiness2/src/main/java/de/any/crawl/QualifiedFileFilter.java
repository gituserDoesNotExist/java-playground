package de.any.crawl;

public interface QualifiedFileFilter {

	/**
	 * @param classname
	 * @return true wenn eine Datei qualifiziert ist.
	 */
	boolean isFilePathQualified(String filepath);

	/**
	 * @param classname
	 * @return true wenn ein Dateipfad qualifiziert ist.
	 */
	boolean isFilenameQualified(String filename);
}
