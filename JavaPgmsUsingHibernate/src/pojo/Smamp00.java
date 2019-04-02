package pojo;

import java.io.Serializable;

public class Smamp00 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String FIRMAM = "";
	private String PCARAM = ""; 
	private String SEQNAM = ""; 
	private String CARDAM = ""; 
	private String SRQNAM = ""; 
	private int    CQTYAM = 0; 
	private String STKCAM = ""; 
	private String CUSTAM = ""; 
	private String MURAAM = ""; 
	private String REELAM = ""; 
	private String ARTDAM = ""; 
	private String CNORAM = "";
	private String DUTYAM = "";
	private String WRHSAM = "";
	private String DSHPAM = "";
	private String STOPAM = "";
	private String ACKCAM = "";
	private String FLG1AM = "";
	private String FLG2AM = "";
	private String STATAM = "";
	private String USERAM = "";
	private String PROGAM = "";
	private int    CYMDAM = 0; 
	private int    LYMDAM = 0; 
	private String EDPCAM = "";
	
	public Smamp00() {
		super();
	}
	public Smamp00(String fIRMAM, String pCARAM, String sEQNAM, String cARDAM, String sRQNAM) {
		super();
		FIRMAM = fIRMAM;
		PCARAM = pCARAM;
		SEQNAM = sEQNAM;
		CARDAM = cARDAM;
		SRQNAM = sRQNAM; 
    } 
	
	public Smamp00(String fIRMAM, String cARDAM, String sRQNAM) {
		super();
		FIRMAM = fIRMAM;
		CARDAM = cARDAM;
		SRQNAM = sRQNAM; 
    }
	
	public String getFIRMAM() {
		return FIRMAM;
	}
	public void setFIRMAM(String fIRMAM) {
		FIRMAM = fIRMAM;
	}
	public String getPCARAM() {
		return PCARAM;
	}
	public void setPCARAM(String pCARAM) {
		PCARAM = pCARAM;
	}
	public String getSEQNAM() {
		return SEQNAM;
	}
	public void setSEQNAM(String sEQNAM) {
		SEQNAM = sEQNAM;
	}
	public String getCARDAM() {
		return CARDAM;
	}
	public void setCARDAM(String cARDAM) {
		CARDAM = cARDAM;
	}
	public String getSRQNAM() {
		return SRQNAM;
	}
	public void setSRQNAM(String sRQNAM) {
		SRQNAM = sRQNAM;
	}
	public int getCQTYAM() {
		return CQTYAM;
	}
	public void setCQTYAM(int cQTYAM) {
		CQTYAM = cQTYAM;
	}
	public String getSTKCAM() {
		return STKCAM;
	}
	public void setSTKCAM(String sTKCAM) {
		STKCAM = sTKCAM;
	}
	public String getCUSTAM() {
		return CUSTAM;
	}
	public void setCUSTAM(String cUSTAM) {
		CUSTAM = cUSTAM;
	}
	public String getMURAAM() {
		return MURAAM;
	}
	public void setMURAAM(String mURAAM) {
		MURAAM = mURAAM;
	}
	public String getREELAM() {
		return REELAM;
	}
	public void setREELAM(String rEELAM) {
		REELAM = rEELAM;
	}
	public String getARTDAM() {
		return ARTDAM;
	}
	public void setARTDAM(String aRTDAM) {
		ARTDAM = aRTDAM;
	}
	public String getCNORAM() {
		return CNORAM;
	}
	public void setCNORAM(String cNORAM) {
		CNORAM = cNORAM;
	}
	public String getDUTYAM() {
		return DUTYAM;
	}
	public void setDUTYAM(String dUTYAM) {
		DUTYAM = dUTYAM;
	}
	public String getWRHSAM() {
		return WRHSAM;
	}
	public void setWRHSAM(String wRHSAM) {
		WRHSAM = wRHSAM;
	}
	public String getDSHPAM() {
		return DSHPAM;
	}
	public void setDSHPAM(String dSHPAM) {
		DSHPAM = dSHPAM;
	}
	public String getSTOPAM() {
		return STOPAM;
	}
	public void setSTOPAM(String sTOPAM) {
		STOPAM = sTOPAM;
	}
	public String getACKCAM() {
		return ACKCAM;
	}
	public void setACKCAM(String aCKCAM) {
		ACKCAM = aCKCAM;
	}
	public String getFLG1AM() {
		return FLG1AM;
	}
	public void setFLG1AM(String fLG1AM) {
		FLG1AM = fLG1AM;
	}
	public String getFLG2AM() {
		return FLG2AM;
	}
	public void setFLG2AM(String fLG2AM) {
		FLG2AM = fLG2AM;
	}
	public String getSTATAM() {
		return STATAM;
	}
	public void setSTATAM(String sTATAM) {
		STATAM = sTATAM;
	}
	public String getUSERAM() {
		return USERAM;
	}
	public void setUSERAM(String uSERAM) {
		USERAM = uSERAM;
	}
	public String getPROGAM() {
		return PROGAM;
	}
	public void setPROGAM(String pROGAM) {
		PROGAM = pROGAM;
	}
	public int getCYMDAM() {
		return CYMDAM;
	}
	public void setCYMDAM(int cYMDAM) {
		CYMDAM = cYMDAM;
	}
	public int getLYMDAM() {
		return LYMDAM;
	}
	public void setLYMDAM(int lYMDAM) {
		LYMDAM = lYMDAM;
	}
	public String getEDPCAM() {
		return EDPCAM;
	}
	public void setEDPCAM(String eDPCAM) {
		EDPCAM = eDPCAM;
	} 

}