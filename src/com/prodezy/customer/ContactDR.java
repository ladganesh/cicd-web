package com.prodezy.customer;

public class ContactDR {
	
	
	  private String CONT_PER_ID,CONT_EMAIL,CONT_NO,SUPP_ID,CONT_NAME,CUST_ID;
	    public ContactDR(String CONT_PER_ID,String CONT_EMAIL,String CONT_NO,String CUST_ID,String SUPP_ID,String CONT_NAME)
	    {
	    	this.CUST_ID=CUST_ID;
	    	this.CONT_PER_ID=CONT_PER_ID;
	    	this.CONT_EMAIL=CONT_EMAIL;
	    	this.CONT_NO=CONT_NO;
	    	this.SUPP_ID=SUPP_ID;
	    	this.CONT_NAME=CONT_NAME;
	    	
	    	
	    	
	    }
	    
	    
	    
	    
	    public String getCUST_ID() {
			return CUST_ID;
		}
		public void setCUST_ID(String cust_id) {
			CUST_ID = cust_id;
		}
		public String getCON_PER_ID() {
			return CONT_PER_ID;
		}
		public void setCONT_PER_ID(String cont_per_id) {
			CONT_PER_ID = cont_per_id;
		}
		public String getCONT_EMAIL() {
			return CONT_EMAIL;
		}
		public void setCONT_EMAIL(String cont_email) {
			CONT_EMAIL = cont_email;
		}
		public String getCONT_NO() {
			return CONT_NO;
		}
		public void setCONT_NO(String cont_no) {
			CONT_NO = cont_no;
		}
		public String getSUPP_ID() {
			return SUPP_ID;
		}
		public void setSUPP_ID(String supp_id) {
			SUPP_ID = supp_id;
		}
		public String getCONT_NAME() {
			return CONT_NAME;
		}
		public void setCONT_NAME(String cont_name) {
			CONT_NAME = cont_name;
		}


}
