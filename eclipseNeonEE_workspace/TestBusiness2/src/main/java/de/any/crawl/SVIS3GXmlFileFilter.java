package de.any.crawl;

public class SVIS3GXmlFileFilter implements QualifiedFileFilter {

	@Override
	public boolean isFilePathQualified(String filePath) {
		return filePath.toUpperCase().contains("SVIS3G");
	}

	@Override
	public boolean isFilenameQualified(String filename) {
		return filename.toUpperCase().contains("APPLICATIONCONTEXT");
	}

}
