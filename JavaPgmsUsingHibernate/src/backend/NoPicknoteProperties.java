package backend;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class NoPicknoteProperties {
	    
	    private String webServiceURL;
	    private String noPicknoteFolder;
	    private String mumuWebService;
	    private String iFSPath;
	    private String iSeries20;
	    private String iSeries21;
	    private String iSeries24;
	    private String iSeries25;
	    private String fileName;
	    private String key;
	    private String segment;
	    private String program; 
	    private String tokenId;
	    

		public void getProperties() throws IOException{
			Properties progProperties = new Properties();
			InputStream in = this.getClass().getClassLoader().getResourceAsStream("NoPicknote.properties");
			progProperties.load(in);
		    this.setWebServiceURL(progProperties.getProperty("webServiceURL"));	
		    this.setNoPicknoteFolder(progProperties.getProperty("noPicknoteFolder"));
		    this.setMumuWebService(progProperties.getProperty("mumuWebService"));
		    this.setiFSPath(progProperties.getProperty("iFSPath"));
		    this.setiSeries20(progProperties.getProperty("iSeries20"));
		    this.setiSeries21(progProperties.getProperty("iSeries21"));
		    this.setiSeries24(progProperties.getProperty("iSeries24"));
		    this.setiSeries25(progProperties.getProperty("iSeries25"));
		    this.setFileName(progProperties.getProperty("fileName"));
		    this.setKey(progProperties.getProperty("key"));
		    this.setSegment(progProperties.getProperty("segment"));
		    this.setProgram(progProperties.getProperty("program"));
		    this.setTokenId(progProperties.getProperty("tokenId"));	    
		}

		public String getWebServiceURL() {
			return webServiceURL;
		}

		public void setWebServiceURL(String webServiceURL) {
			this.webServiceURL = webServiceURL;
		}
		
		public String getNoPicknoteFolder() {
			return noPicknoteFolder;
		}

		public void setNoPicknoteFolder(String noPicknoteFolder) {
			this.noPicknoteFolder = noPicknoteFolder;
		}

		public String getMumuWebService() {
			return mumuWebService;
		}

		public void setMumuWebService(String mumuWebService) {
			this.mumuWebService = mumuWebService;
		}

		public String getiFSPath() {
			return iFSPath;
		}

		public void setiFSPath(String iFSPath) {
			this.iFSPath = iFSPath;
		}

		public String getiSeries20() {
			return iSeries20;
		}

		public void setiSeries20(String iSeries20) {
			this.iSeries20 = iSeries20;
		}

		public String getiSeries21() {
			return iSeries21;
		}

		public void setiSeries21(String iSeries21) {
			this.iSeries21 = iSeries21;
		}

		public String getiSeries24() {
			return iSeries24;
		}

		public void setiSeries24(String iSeries24) {
			this.iSeries24 = iSeries24;
		}

		public String getiSeries25() {
			return iSeries25;
		}

		public void setiSeries25(String iSeries25) {
			this.iSeries25 = iSeries25;
		}

		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getSegment() {
			return segment;
		}

		public void setSegment(String segment) {
			this.segment = segment;
		}

		public String getProgram() {
			return program;
		}

		public void setProgram(String program) {
			this.program = program;
		}

		public String getTokenId() {
			return tokenId;
		}

		public void setTokenId(String tokenId) {
			this.tokenId = tokenId;
		}
}
