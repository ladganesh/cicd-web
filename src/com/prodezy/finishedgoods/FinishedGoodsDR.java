package com.prodezy.finishedgoods;

public class FinishedGoodsDR {
	public FinishedGoodsDR(String fgid, String fgpartuniqueid, String fgpartno, String partname, String salesrate,
			String ntweight, String grsweight, String notes, String prdcost, String fguomid ) {
		super();
		this.fgid = fgid;
		this.fgpartuniqueid = fgpartuniqueid;
		this.fgpartno = fgpartno;
		this.partname = partname;
		this.salesrate = salesrate;
		this.ntweight = ntweight;
		this.grsweight = grsweight;
		this.notes = notes;
		this.prdcost = prdcost;
		this.fguomid = fguomid;
	
	}
	private String fgid;
	private String fgpartuniqueid;
	private String fgpartno;
	private String partname;
//	private String customer;
//	private String moq;
	private String salesrate;
//	private String gstrate;
//	private String packsize;
//	private String mldcavit;
//	private String tgtoptxt;
//	private String partdrg;
	private String ntweight;
	private String grsweight;
	private String notes;
	private String prdcost;
	private String fguomid;


	
	public String getFgid() {
		return fgid;
	}
	public void setFgid(String fgid) {
		this.fgid = fgid;
	}
	public String getFgpartuniqueid() {
		return fgpartuniqueid;
	}
	public void setFgpartuniqueid(String fgpartuniqueid) {
		this.fgpartuniqueid = fgpartuniqueid;
	}
	public String getFgpartno() {
		return fgpartno;
	}
	public void setFgpartno(String fgpartno) {
		this.fgpartno = fgpartno;
	}
	public String getPartname() {
		return partname;
	}
	public void setPartname(String partname) {
		this.partname = partname;
	}
	public String getSalesrate() {
		return salesrate;
	}
	public void setSalesrate(String salesrate) {
		this.salesrate = salesrate;
	}
	public String getNtweight() {
		return ntweight;
	}
	public void setNtweight(String ntweight) {
		this.ntweight = ntweight;
	}
	public String getGrsweight() {
		return grsweight;
	}
	public void setGrsweight(String grsweight) {
		this.grsweight = grsweight;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getPrdcost() {
		return prdcost;
	}
	public void setPrdcost(String prdcost) {
		this.prdcost = prdcost;
	}
	public String getFguomid() {
		return fguomid;
	}
	public void setFguomid(String fguomid) {
		this.fguomid = fguomid;
	}
	

}
