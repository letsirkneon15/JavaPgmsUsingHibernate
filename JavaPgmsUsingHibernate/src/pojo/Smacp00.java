package pojo;

import java.io.Serializable;

public class Smacp00 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String FIRMAC = "";  
	private String CARDAC = "";    
	private String SRQNAC = "";    
	private String ORDTAC = "";    
	private String CUSTAC = "";    
	private String MURAAC = "";    
	private String REELAC = "";    
	private String ARTDAC = "";    
	private String CNORAC = "";    
	private String DUTYAC = "";    
	private String WRHSAC = "";    
	private String CARCAC = "";
	private String ADRSAC = ""; 
	private String SHPGAC = ""; 
	private String VATKAC = ""; 
	private String ALLMAC = ""; 
	private int    CQTYAC = 0;
	private String CBOAAC = ""; 
	private int    ALLQAC = 0; 
	private int    WAITAC = 0; 
	private int    CDVWAC = 0; 
	private int    CDVDAC = 0; 
	private int    EDRDAC = 0; 
	private int    EDRWAC = 0;
	private int    CRSDAC = 0;   
	private int    DAKWAC = 0;   
	private int    DAKDAC = 0;   
	private int    EDVDAC = 0;   
	private int    EDVWAC = 0;   
	private int    DAKSAC = 0;   
	private int    CHGDAC = 0;   
	private int    ASHDAC = 0;   
	private int    FDAKAC = 0;   
	private int    FPRDAC = 0;   
	private int    CDFDAC = 0;   
	private int    DATXAC = 0;
	private int    DATYAC = 0;   
	private String DSHPAC = "";   
	private String DVCDAC = "";   
	private String SCHCAC = "";   
	private String DELNAC = "";   
	private String PICKAC = "";   
	private String COCOAC = "";   
	private String EXLNAC = "";   
	private String METHAC = "";   
	private int    MSHQAC = 0;   
	private String CODFAC = "";   
	private String QLTCAC = ""; 
	private String FLG1AC = "";   
	private String FLG2AC = "";   
	private String FLG3AC = "";   
	private String FLG4AC = "";   
	private String FLG5AC = "";   
	private String STATAC = "";   
	private String USERAC = "";   
	private String PROGAC = "";   
	private int    CYMDAC = 0;    
	private int    LYMDAC = 0;    
	private String EDPCAC = "";   
	
	public Smacp00() {
		super();
	}
	
	public Smacp00(String fIRMAC, String cARDAC, String sRQNAC) {
		super();
		FIRMAC = fIRMAC;
		CARDAC = cARDAC;
		SRQNAC = sRQNAC;
	}
	
	public Smacp00(String fIRMAC, String cARDAC) {
		super();
		FIRMAC = fIRMAC;
		CARDAC = cARDAC;
	}

	public String getFIRMAC() {
		return FIRMAC;
	}

	public void setFIRMAC(String fIRMAC) {
		FIRMAC = fIRMAC;
	}

	public String getCARDAC() {
		return CARDAC;
	}

	public void setCARDAC(String cARDAC) {
		CARDAC = cARDAC;
	}

	public String getSRQNAC() {
		return SRQNAC;
	}

	public void setSRQNAC(String sRQNAC) {
		SRQNAC = sRQNAC;
	}

	public String getORDTAC() {
		return ORDTAC;
	}

	public void setORDTAC(String oRDTAC) {
		ORDTAC = oRDTAC;
	}

	public String getCUSTAC() {
		return CUSTAC;
	}

	public void setCUSTAC(String cUSTAC) {
		CUSTAC = cUSTAC;
	}

	public String getMURAAC() {
		return MURAAC;
	}

	public void setMURAAC(String mURAAC) {
		MURAAC = mURAAC;
	}

	public String getREELAC() {
		return REELAC;
	}

	public void setREELAC(String rEELAC) {
		REELAC = rEELAC;
	}

	public String getARTDAC() {
		return ARTDAC;
	}

	public void setARTDAC(String aRTDAC) {
		ARTDAC = aRTDAC;
	}

	public String getCNORAC() {
		return CNORAC;
	}

	public void setCNORAC(String cNORAC) {
		CNORAC = cNORAC;
	}

	public String getDUTYAC() {
		return DUTYAC;
	}

	public void setDUTYAC(String dUTYAC) {
		DUTYAC = dUTYAC;
	}

	public String getWRHSAC() {
		return WRHSAC;
	}

	public void setWRHSAC(String wRHSAC) {
		WRHSAC = wRHSAC;
	}

	public String getCARCAC() {
		return CARCAC;
	}

	public void setCARCAC(String cARCAC) {
		CARCAC = cARCAC;
	}

	public String getADRSAC() {
		return ADRSAC;
	}

	public void setADRSAC(String aDRSAC) {
		ADRSAC = aDRSAC;
	}

	public String getSHPGAC() {
		return SHPGAC;
	}

	public void setSHPGAC(String sHPGAC) {
		SHPGAC = sHPGAC;
	}

	public String getVATKAC() {
		return VATKAC;
	}

	public void setVATKAC(String vATKAC) {
		VATKAC = vATKAC;
	}

	public String getALLMAC() {
		return ALLMAC;
	}

	public void setALLMAC(String aLLMAC) {
		ALLMAC = aLLMAC;
	}

	public int getCQTYAC() {
		return CQTYAC;
	}

	public void setCQTYAC(int cQTYAC) {
		CQTYAC = cQTYAC;
	}

	public String getCBOAAC() {
		return CBOAAC;
	}

	public void setCBOAAC(String cBOAAC) {
		CBOAAC = cBOAAC;
	}

	public int getALLQAC() {
		return ALLQAC;
	}

	public void setALLQAC(int aLLQAC) {
		ALLQAC = aLLQAC;
	}

	public int getWAITAC() {
		return WAITAC;
	}

	public void setWAITAC(int wAITAC) {
		WAITAC = wAITAC;
	}

	public int getCDVWAC() {
		return CDVWAC;
	}

	public void setCDVWAC(int cDVWAC) {
		CDVWAC = cDVWAC;
	}

	public int getCDVDAC() {
		return CDVDAC;
	}

	public void setCDVDAC(int cDVDAC) {
		CDVDAC = cDVDAC;
	}

	public int getEDRDAC() {
		return EDRDAC;
	}

	public void setEDRDAC(int eDRDAC) {
		EDRDAC = eDRDAC;
	}

	public int getEDRWAC() {
		return EDRWAC;
	}

	public void setEDRWAC(int eDRWAC) {
		EDRWAC = eDRWAC;
	}

	public int getCRSDAC() {
		return CRSDAC;
	}

	public void setCRSDAC(int cRSDAC) {
		CRSDAC = cRSDAC;
	}

	public int getDAKWAC() {
		return DAKWAC;
	}

	public void setDAKWAC(int dAKWAC) {
		DAKWAC = dAKWAC;
	}

	public int getDAKDAC() {
		return DAKDAC;
	}

	public void setDAKDAC(int dAKDAC) {
		DAKDAC = dAKDAC;
	}

	public int getEDVDAC() {
		return EDVDAC;
	}

	public void setEDVDAC(int eDVDAC) {
		EDVDAC = eDVDAC;
	}

	public int getEDVWAC() {
		return EDVWAC;
	}

	public void setEDVWAC(int eDVWAC) {
		EDVWAC = eDVWAC;
	}

	public int getDAKSAC() {
		return DAKSAC;
	}

	public void setDAKSAC(int dAKSAC) {
		DAKSAC = dAKSAC;
	}

	public int getCHGDAC() {
		return CHGDAC;
	}

	public void setCHGDAC(int cHGDAC) {
		CHGDAC = cHGDAC;
	}

	public int getASHDAC() {
		return ASHDAC;
	}

	public void setASHDAC(int aSHDAC) {
		ASHDAC = aSHDAC;
	}

	public int getFDAKAC() {
		return FDAKAC;
	}

	public void setFDAKAC(int fDAKAC) {
		FDAKAC = fDAKAC;
	}

	public int getFPRDAC() {
		return FPRDAC;
	}

	public void setFPRDAC(int fPRDAC) {
		FPRDAC = fPRDAC;
	}

	public int getCDFDAC() {
		return CDFDAC;
	}

	public void setCDFDAC(int cDFDAC) {
		CDFDAC = cDFDAC;
	}

	public int getDATXAC() {
		return DATXAC;
	}

	public void setDATXAC(int dATXAC) {
		DATXAC = dATXAC;
	}

	public int getDATYAC() {
		return DATYAC;
	}

	public void setDATYAC(int dATYAC) {
		DATYAC = dATYAC;
	}

	public String getDSHPAC() {
		return DSHPAC;
	}

	public void setDSHPAC(String dSHPAC) {
		DSHPAC = dSHPAC;
	}

	public String getDVCDAC() {
		return DVCDAC;
	}

	public void setDVCDAC(String dVCDAC) {
		DVCDAC = dVCDAC;
	}

	public String getSCHCAC() {
		return SCHCAC;
	}

	public void setSCHCAC(String sCHCAC) {
		SCHCAC = sCHCAC;
	}

	public String getDELNAC() {
		return DELNAC;
	}

	public void setDELNAC(String dELNAC) {
		DELNAC = dELNAC;
	}

	public String getPICKAC() {
		return PICKAC;
	}

	public void setPICKAC(String pICKAC) {
		PICKAC = pICKAC;
	}

	public String getCOCOAC() {
		return COCOAC;
	}

	public void setCOCOAC(String cOCOAC) {
		COCOAC = cOCOAC;
	}

	public String getEXLNAC() {
		return EXLNAC;
	}

	public void setEXLNAC(String eXLNAC) {
		EXLNAC = eXLNAC;
	}

	public String getMETHAC() {
		return METHAC;
	}

	public void setMETHAC(String mETHAC) {
		METHAC = mETHAC;
	}

	public int getMSHQAC() {
		return MSHQAC;
	}

	public void setMSHQAC(int mSHQAC) {
		MSHQAC = mSHQAC;
	}

	public String getCODFAC() {
		return CODFAC;
	}

	public void setCODFAC(String cODFAC) {
		CODFAC = cODFAC;
	}

	public String getQLTCAC() {
		return QLTCAC;
	}

	public void setQLTCAC(String qLTCAC) {
		QLTCAC = qLTCAC;
	}

	public String getFLG1AC() {
		return FLG1AC;
	}

	public void setFLG1AC(String fLG1AC) {
		FLG1AC = fLG1AC;
	}

	public String getFLG2AC() {
		return FLG2AC;
	}

	public void setFLG2AC(String fLG2AC) {
		FLG2AC = fLG2AC;
	}

	public String getFLG3AC() {
		return FLG3AC;
	}

	public void setFLG3AC(String fLG3AC) {
		FLG3AC = fLG3AC;
	}

	public String getFLG4AC() {
		return FLG4AC;
	}

	public void setFLG4AC(String fLG4AC) {
		FLG4AC = fLG4AC;
	}

	public String getFLG5AC() {
		return FLG5AC;
	}

	public void setFLG5AC(String fLG5AC) {
		FLG5AC = fLG5AC;
	}

	public String getSTATAC() {
		return STATAC;
	}

	public void setSTATAC(String sTATAC) {
		STATAC = sTATAC;
	}

	public String getUSERAC() {
		return USERAC;
	}

	public void setUSERAC(String uSERAC) {
		USERAC = uSERAC;
	}

	public String getPROGAC() {
		return PROGAC;
	}

	public void setPROGAC(String pROGAC) {
		PROGAC = pROGAC;
	}

	public int getCYMDAC() {
		return CYMDAC;
	}

	public void setCYMDAC(int cYMDAC) {
		CYMDAC = cYMDAC;
	}

	public int getLYMDAC() {
		return LYMDAC;
	}

	public void setLYMDAC(int lYMDAC) {
		LYMDAC = lYMDAC;
	}

	public String getEDPCAC() {
		return EDPCAC;
	}

	public void setEDPCAC(String eDPCAC) {
		EDPCAC = eDPCAC;
	}
}
