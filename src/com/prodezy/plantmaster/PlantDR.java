package com.prodezy.plantmaster;

public class PlantDR {
	
	public PlantDR(String plantid, String plantname, String plantcode, String gstno, String plantaddress,
			String plantweekoff, String plantcpname, String plantcpno, String plantcpemail, String companyname,
			String complogo, String plantcontactno ,String plantemail ) {
		super();
		this.plantid = plantid;
		this.plantname = plantname;
		this.plantcode = plantcode;
		this.gstno = gstno;
		this.plantaddress = plantaddress;
		this.plantweekoff = plantweekoff;
		this.plantcpname = plantcpname;
		this.plantcpno = plantcpno;
		this.plantcpemail = plantcpemail;
		this.companyname = companyname;
		this.complogo = complogo;
		this.plantcontactno = plantcontactno;
		this.plantemail=plantemail;
	}
	private String plantid;
	private String plantname;
	private String plantcode;
	private String gstno;
	private String plantaddress;
	private String plantweekoff;
	private String plantcpname;
	private String plantcpno;
	private String plantcpemail;
	private String companyname;
	private String complogo;
	private String plantcontactno;
	private String plantemail;
	
	public String getPlantid() {
		return plantid;
	}
	public void setPlantid(String plantid) {
		this.plantid = plantid;
	}
	public String getPlantemail() {
		return plantemail;
	}
	public void setPlantemail(String plantemail) {
		this.plantid = plantemail;
	}
	public String getPlantname() {
		return plantname;
	}
	public void setPlantname(String plantname) {
		this.plantname = plantname;
	}
	public String getPlantcode() {
		return plantcode;
	}
	public void setPlantcode(String plantcode) {
		this.plantcode = plantcode;
	}
	public String getGstno() {
		return gstno;
	}
	public void setGstno(String gstno) {
		this.gstno = gstno;
	}
	public String getPlantaddress() {
		return plantaddress;
	}
	public void setPlantaddress(String plantaddress) {
		this.plantaddress = plantaddress;
	}
	public String getPlantweekoff() {
		return plantweekoff;
	}
	public void setPlantweekoff(String plantweekoff) {
		this.plantweekoff = plantweekoff;
	}
	public String getPlantcpname() {
		return plantcpname;
	}
	public void setPlantcpname(String plantcpname) {
		this.plantcpname = plantcpname;
	}
	public String getPlantcpno() {
		return plantcpno;
	}
	public void setPlantcpno(String plantcpno) {
		this.plantcpno = plantcpno;
	}
	public String getPlantcpemail() {
		return plantcpemail;
	}
	public void setPlantcpemail(String plantcpemail) {
		this.plantcpemail = plantcpemail;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getComplogo() {
		return complogo;
	}
	public void setComplogo(String complogo) {
		this.complogo = complogo;
	}
	public String getPlantcontactno() {
		return plantcontactno;
	}
	public void setPlantcontactno(String plantcontactno) {
		this.plantcontactno = plantcontactno;
	}
	
	
}
