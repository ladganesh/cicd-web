package com.prodezy.machine;


public class MachineDR {


    private String MCH_ID;
    private String MACHINE_NO;
    private String MAKE;
    private String OP_RATE_HR;
    private String AVL_HRS;
    private String DAVLHRS;
    
    public MachineDR() {
		// TODO Auto-generated constructor stub
    	
	}
    public MachineDR(String MCH_ID,String MACHINE_NO,String MAKE,String OP_RATE_HR,String AVL_HRS,String DAVLHRS)
    {
    	this.MCH_ID=MCH_ID;
    	this.MACHINE_NO=MACHINE_NO;
    	this.MAKE=MAKE;
    	this.OP_RATE_HR=OP_RATE_HR;
    	this.AVL_HRS=AVL_HRS;
    	this.DAVLHRS=DAVLHRS;
    }
    public String getAVL_HRS() {
		return AVL_HRS;
	}
    public String getDAVLHRS() {
		return DAVLHRS;
	}
    public String getMCH_ID() {
		return MCH_ID;
	}
    public String getMACHINE_NO() {
		return MACHINE_NO;
	}
    public String getMAKE() {
		return MAKE;
	}
    public String getOP_RATE_HR() {
		return OP_RATE_HR;
	}
    public void setOP_RATE_HR(String oP_RATE_HR) {
		OP_RATE_HR = oP_RATE_HR;
	}
    public void setMCH_ID(String mCH_ID) {
		MCH_ID = mCH_ID;
	}
    public void setMAKE(String mAKE) {
		MAKE = mAKE;
	}
    public void setMACHINE_NO(String mACHINE_NO) {
		MACHINE_NO = mACHINE_NO;
	}
    public void setDAVLHRS(String dAVLHRS) {
		DAVLHRS = dAVLHRS;
	}
    public void setAVL_HRS(String aVL_HRS) {
		AVL_HRS = aVL_HRS;
	}
}