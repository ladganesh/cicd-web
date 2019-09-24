package com.prodezy.plantmaster;

public class ShiftDR {

	public ShiftDR(String shiftid,String shiftno,String shifttitle ,String shiftfromtime ,String shifttotime, String shiftduration,String refplantid) {
		
		
	super();
	this.shiftid=shiftid;
	this.shiftno=shiftno;
	this.shifttitle=shifttitle;
	this.shiftfromtime=shiftfromtime;
	this.shifttotime=shifttotime;
	this.shiftduration=shiftduration;
	this.refplantid=refplantid;
	
			
	}
	
	
	private String shiftid;
	private String shiftno;
	private String shifttitle ;
	private String shiftfromtime ;
	private String shifttotime;
	private String shiftduration;
	private String refplantid;

public String getShiftid() {
	return shiftid;
}
public void setShiftid(String shiftid) {
	this.shiftid = shiftid;
}
public String getShifttitle() {
	return shifttitle;
}
public void setShiftTitle(String shifttitle) {
	this.shifttitle = shifttitle;
}
public String getShiftno() {
	return shiftno;
}
public void setShiftno(String shiftno) {
	this.shiftno = shiftno;
}
public String getShiftfromtime() {
	return shiftfromtime;
}
public void setShiftfromtime(String shiftfromtime) {
	this.shiftfromtime = shiftfromtime;
}
public String getShifttotime() {
	return shifttotime;
}
public void setShifttotime(String shifttotime) {
	this.shifttotime=shifttotime;
}
public String getShiftduration() {
	return shiftduration;
}
public void setShiftduration(String shiftduration) {
	this.shiftduration = shiftduration;
}

public String getRefplantid() {
	return refplantid;
}
public void setRefplantid(String refplantid) {
	this.refplantid = refplantid;
}

}
