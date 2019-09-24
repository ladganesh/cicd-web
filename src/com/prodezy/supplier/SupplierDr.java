package com.prodezy.supplier;

public class SupplierDr {
	public SupplierDr(String supp_id, String supp_name, String supp_add,String supp_cnt_ll, String supp_cnt_brd, String week_off, String gst_no,String vendor_code,String category,String city,String authorised) {
		
		this.supp_id=supp_id;
		this.supp_name=supp_name;
		this.supp_add=supp_add;
		this.supp_cnt_ll=supp_cnt_ll;
		this.supp_cnt_brd=supp_cnt_brd;
		this.week_off=week_off;
		this.gst_no=gst_no;
		this.vendor_code=vendor_code;
		this.city=city;
		this.authorised=authorised;
		
		
	}
	
	private String supp_id;
	private String supp_name;
	private String  supp_add;
	private  String supp_cnt_ll;
	private String supp_cnt_brd;
	private String week_off;
	private String gst_no;
	private String vendor_code;
	private String category;
	private String city;
	private String authorised;

public String getSupp_id() {
	return supp_id;
}
public void setSupp_id(String supp_id) {
	this.supp_id = supp_id;
}

public String getSupp_name() {
	return supp_name;
}
public void setSupp_name(String supp_name) {
	this.supp_name = supp_name;
}


public String getSupp_add() {
	return supp_add;
}
public void setSupp_add(String supp_add) {
	this.supp_add = supp_add;
}

public String getSupp_cnt_ll() {
	return supp_cnt_ll;
}
public void setSupp_cnt_ll(String supp_cnt_ll) {
	this.supp_cnt_ll = supp_cnt_ll;
}

public String getSupp_cnt_brd() {
	return supp_cnt_brd;
}
public void setSupp_cnt_brd(String supp_cnt_brd) {
	this.supp_cnt_brd = supp_cnt_brd;
}

public String getWeek_off() {
	return week_off;
}
public void setWeek_off(String week_off) {
	this.week_off = week_off;
}

public String getGst_no() {
	return gst_no;
}
public void setGst_no(String gst_no) {
	this.gst_no=gst_no;
}

public String getVendor_code() {
	return vendor_code;
}
public void setVendor_code(String vendor_code) {
	this.vendor_code = vendor_code;
}

public String getCategory() {
	return category;
}
public void seCategory(String category) {
	this.category = category;
}	
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}	
public String getAuthorised() {
	return authorised;
}
public void setAuthorised(String authorised) {
	this.authorised = authorised;
}	
//public String getRefplantid() {
//	return refplantid;
//}
//public void setRefplanttid(String refplantid) {
//	this.refplantid = refplantid;
//}	
}
