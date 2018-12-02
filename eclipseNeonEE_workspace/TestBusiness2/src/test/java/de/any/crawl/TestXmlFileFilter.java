package de.any.crawl;

public class TestXmlFileFilter implements QualifiedFileFilter {

	@Override
	public boolean isFilePathQualified(String filepath) {
		return true;
	}

	@Override
	public boolean isFilenameQualified(String filename) {
		return filename.toUpperCase().contains("APPLICATIONCONTEXT");
	}

}
