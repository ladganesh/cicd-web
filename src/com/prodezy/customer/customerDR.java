package com.prodezy.customer;

public class customerDR {
	private String CUST_ID;
    private String CUSTOMER_NAME;
    private String CITY;
    private String CUST_ADDRESS;
    private String CONTACT_LL;
    private String CONTACT_BRD;
    private String WEEKLY_OFF;
    private String GST_NO;
    private String PAYMENT_TERMS;
    private String OUR_VENDOR_CODE;
    private String CUST_CODE;
    private String PLANT_CODE;
    
    
	public customerDR(String cUST_ID, String cUSTOMER_NAME, String cITY, String cUST_ADDRESS, String cONTACT_LL,
			String cONTACT_BRD, String wEEKLY_OFF, String gST_NO, String pAYMENT_TERMS, String oUR_VENDOR_CODE,
			String cUST_CODE, String pLANT_CODE) 
	{
		
		CUST_ID = cUST_ID;
		CUSTOMER_NAME = cUSTOMER_NAME;
		CITY = cITY;
		CUST_ADDRESS = cUST_ADDRESS;
		CONTACT_LL = cONTACT_LL;
		CONTACT_BRD = cONTACT_BRD;
		WEEKLY_OFF = wEEKLY_OFF;
		GST_NO = gST_NO;
		PAYMENT_TERMS = pAYMENT_TERMS;
		OUR_VENDOR_CODE = oUR_VENDOR_CODE;
		CUST_CODE = cUST_CODE;
		PLANT_CODE = pLANT_CODE;
	}
	
	

  
	
	
	
	
	public String getCUST_ID() {
		return CUST_ID;
	}
	public void setCUST_ID(String cUST_ID) {
		CUST_ID = cUST_ID;
	}
	public String getCUSTOMER_NAME() {
		return CUSTOMER_NAME;
	}
	public void setCUSTOMER_NAME(String cUSTOMER_NAME) {
		CUSTOMER_NAME = cUSTOMER_NAME;
	}
	public String getCITY() {
		return CITY;
	}
	public void setCITY(String cITY) {
		CITY = cITY;
	}
	public String getCUST_ADDRESS() {
		return CUST_ADDRESS;
	}
	public void setCUST_ADDRESS(String cUST_ADDRESS) {
		CUST_ADDRESS = cUST_ADDRESS;
	}
	public String getCONTACT_LL() {
		return CONTACT_LL;
	}
	public void setCONTACT_LL(String cONTACT_LL) {
		CONTACT_LL = cONTACT_LL;
	}
	public String getCONTACT_BRD() {
		return CONTACT_BRD;
	}
	public void setCONTACT_BRD(String cONTACT_BRD) {
		CONTACT_BRD = cONTACT_BRD;
	}
	public String getWEEKLY_OFF() {
		return WEEKLY_OFF;
	}
	public void setWEEKLY_OFF(String wEEKLY_OFF) {
		WEEKLY_OFF = wEEKLY_OFF;
	}
	public String getGST_NO() {
		return GST_NO;
	}
	public void setGST_NO(String gST_NO) {
		GST_NO = gST_NO;
	}
	public String getPAYMENT_TERMS() {
		return PAYMENT_TERMS;
	}
	public void setPAYMENT_TERMS(String pAYMENT_TERMS) {
		PAYMENT_TERMS = pAYMENT_TERMS;
	}
	public String getOUR_VENDOR_CODE() {
		return OUR_VENDOR_CODE;
	}
	public void setOUR_VENDOR_CODE(String oUR_VENDOR_CODE) {
		OUR_VENDOR_CODE = oUR_VENDOR_CODE;
	}
	public String getCUST_CODE() {
		return CUST_CODE;
	}
	public void setCUST_CODE(String cUST_CODE) {
		CUST_CODE = cUST_CODE;
	}
	public String getPLANT_CODE() {
		return PLANT_CODE;
	}
	public void setPLANT_CODE(String pLANT_CODE) {
		PLANT_CODE = pLANT_CODE;
	}
    
    

}
