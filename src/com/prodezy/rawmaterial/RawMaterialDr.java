package com.prodezy.rawmaterial;

public class RawMaterialDr {
	
	private String RM_ID;
	private String RM_CTG;
	private String RM_NAME;
	private String RM_RATE;
	private String REORDER_LEVEL;
	private String RMM_UOM_ID;
	private String RM_CODE;
	private String length;
	private String width;
	private String thickness;
	private String density;
	private String RM_EC_NO;
	private String RM_CAS_NO;
	private String GST_NO;
	private String RM_CRIT;
	
	public RawMaterialDr(String rM_ID, String rM_CTG, String rM_NAME, String rM_RATE, String rEORDER_LEVEL,
			String rMM_UOM_ID, String rM_CODE, String length, String width, String thickness, String density,String rM_EC_NO,String rM_CAS_NO,String gST_NO,String rM_CRIT) {
		super();
		RM_ID = rM_ID;
		RM_CTG = rM_CTG;
		RM_NAME = rM_NAME;
		RM_RATE = rM_RATE;
		REORDER_LEVEL = rEORDER_LEVEL;
		RMM_UOM_ID = rMM_UOM_ID;
		RM_CODE = rM_CODE;
		this.length = length;
		this.width = width;
		this.thickness = thickness;
		this.density = density;
		RM_EC_NO=rM_EC_NO;
		RM_CAS_NO=rM_CAS_NO;
		GST_NO=gST_NO;
		RM_CRIT=rM_CRIT;
	}

	public String getRM_ID() {
		return RM_ID;
	}

	public void setRM_ID(String rM_ID) {
		RM_ID = rM_ID;
	}

	public String getRM_CTG() {
		return RM_CTG;
	}

	public void setRM_CTG(String rM_CTG) {
		RM_CTG = rM_CTG;
	}

	public String getRM_NAME() {
		return RM_NAME;
	}

	public void setRM_NAME(String rM_NAME) {
		RM_NAME = rM_NAME;
	}

	public String getRM_RATE() {
		return RM_RATE;
	}

	public void setRM_RATE(String rM_RATE) {
		RM_RATE = rM_RATE;
	}

	public String getREORDER_LEVEL() {
		return REORDER_LEVEL;
	}

	public void setREORDER_LEVEL(String rEORDER_LEVEL) {
		REORDER_LEVEL = rEORDER_LEVEL;
	}

	public String getRMM_UOM_ID() {
		return RMM_UOM_ID;
	}

	public void setRMM_UOM_ID(String rMM_UOM_ID) {
		RMM_UOM_ID = rMM_UOM_ID;
	}

	public String getRM_CODE() {
		return RM_CODE;
	}

	public void setRM_CODE(String rM_CODE) {
		RM_CODE = rM_CODE;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getThickness() {
		return thickness;
	}

	public void setThickness(String thickness) {
		this.thickness = thickness;
	}

	public String getDensity() {
		return density;
	}

	public void setDensity(String density) {
		this.density = density;
	}
	public String getRM_EC_NO() {
		return RM_EC_NO;
	}

	public void setRM_EC_NO(String rM_EC_NO) {
		RM_EC_NO = rM_EC_NO;
	}
	public String getRM_CAS_NO() {
		return RM_CAS_NO;
	}

	public void setRM_CAS_NO(String rM_CAS_NO) {
		RM_CAS_NO = rM_CAS_NO;
	}
	public String getGST_NO() {
		return GST_NO;
	}

	public void setGST_NO(String gST_NO) {
		GST_NO = gST_NO;
	}
	public String getRM_CRIT() {
		return RM_CRIT;
	}

	public void setRM_CRIT(String rM_CRIT) {
		RM_CRIT = rM_CRIT;
	}

	
}
