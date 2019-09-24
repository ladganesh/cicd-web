package com.prodezy.employee;

public class EmployeeDR {

	private String EMPLOYEEPK;
	private String EMP_NAME;
	private String EMP_NO;
	private String  JOIN_DT;
	private String PHOTO;
	private String GENDER;
	private String DEPARTMENTID;
	private String ROLE;
	private String IS_USER;
	private String ADD_LOCAL;
	private String ADD_PERM;
	private String EDUCATION;
	private String DOB;

	
	public EmployeeDR(String eMPLOYEEPK, String eMP_NAME, String eMP_NO, String jOIN_DT, String pHOTO, String gENDER,
			String dEPARTMENTID, String rOLE, String iS_USER, String aDD_LOCAL, String aDD_PERM) {
		super();
		EMPLOYEEPK = eMPLOYEEPK;
		EMP_NAME = eMP_NAME;
		EMP_NO = eMP_NO;
		JOIN_DT = jOIN_DT;
		PHOTO = pHOTO;
		GENDER = gENDER;
		DEPARTMENTID = dEPARTMENTID;
		ROLE = rOLE;
		IS_USER = iS_USER;
		ADD_LOCAL = aDD_LOCAL;
		ADD_PERM = aDD_PERM;
	//	EDUCATION=eDUCATION/;
//		DOB=dOB;
	}
	
	public String getEMPLOYEEPK() {
		return EMPLOYEEPK;
	}
	public void setEMPLOYEEPK(String eMPLOYEEPK) {
		EMPLOYEEPK = eMPLOYEEPK;
	}
	public String getEMP_NAME() {
		return EMP_NAME;
	}
	public void setEMP_NAME(String eMP_NAME) {
		EMP_NAME = eMP_NAME;
	}
	public String getEMP_NO() {
		return EMP_NO;
	}
	public void setEMP_NO(String eMP_NO) {
		EMP_NO = eMP_NO;
	}
	public String getJOIN_DT() {
		return JOIN_DT;
	}
	public void setJOIN_DT(String jOIN_DT) {
		JOIN_DT = jOIN_DT;
	}
	public String getPHOTO() {
		return PHOTO;
	}
	public void setPHOTO(String pHOTO) {
		PHOTO = pHOTO;
	}
	public String getGENDER() {
		return GENDER;
	}
	public void setGENDER(String gENDER) {
		GENDER = gENDER;
	}
	public String getDEPARTMENTID() {
		return DEPARTMENTID;
	}
	public void setDEPARTMENTID(String dEPARTMENTID) {
		DEPARTMENTID = dEPARTMENTID;
	}
	public String getROLE() {
		return ROLE;
	}
	public void setROLE(String rOLE) {
		ROLE = rOLE;
	}
	public String getIS_USER() {
		return IS_USER;
	}
	public void setIS_USER(String iS_USER) {
		IS_USER = iS_USER;
	}
	public String getADD_LOCAL() {
		return ADD_LOCAL;
	}
	public void setADD_LOCAL(String aDD_LOCAL) {
		ADD_LOCAL = aDD_LOCAL;
	}
	public String getADD_PERM() {
		return ADD_PERM;
	}
	public void setADD_PERM(String aDD_PERM) {
		ADD_PERM = aDD_PERM;
	}
	public String getEDUCATION() {
		return EDUCATION;
	}
	public void setEDUCTAION(String eDUCATION) {
		EDUCATION = eDUCATION;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	
	
}
