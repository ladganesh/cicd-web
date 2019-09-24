package com.prodezy.diemaster;

public class DieDR {
	private String id,no,name,total_strokes,cost_maintenance,maintenance_stroke,reminder_count,date_maintenance,owner_id,shut_id,tonnage,dimensions,cost_purchase;

	public DieDR(String id,String no,String name,String total_strokes,String cost_maintenance,String maintenance_stroke,String reminder_count,String date_maintenance,String owner_id,String shut_id,String tonnage,String dimensions, String cost_purchase)
	{
		super();
		this.id=id;
		this.no=no;

		this.name=name;
		this.total_strokes=total_strokes;
		this.cost_maintenance=cost_maintenance;
		this.maintenance_stroke=maintenance_stroke;
		this.reminder_count=reminder_count;
		this.date_maintenance=date_maintenance;
		this.owner_id=owner_id;
		this.shut_id=shut_id;
		this.tonnage=tonnage;
		this.dimensions=dimensions;
		this.cost_purchase=cost_purchase;
		
				
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no=  no;
	}
	public String getTotal_strokes() {
		return total_strokes;
	}
	public void setTotal_strokes(String total_strokes) {
		this.total_strokes= total_strokes;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id=  id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=  name;
	}
	public String getCost_maintenance() {
		return cost_maintenance;
	}
	public void settCost_maintenance(String cost_maintenance) {
		this.cost_maintenance=  cost_maintenance;
	}
	public String getcost_purchase() {
		return cost_purchase;
	}
	public void setcost_purchasee(String cost_purchase) {
		this.cost_purchase=  cost_purchase;
	}
	
	public String getMaintenance_stroke() {
		return maintenance_stroke;
	}
	public void setMaintenance_stroke(String maintenance_stroke) {
		this.maintenance_stroke=  maintenance_stroke;
	}
	
	public String getReminder_count() {
		return reminder_count;
	}
	public void setReminder_count(String reminder_count) {
		this.reminder_count=  reminder_count;
	}
	
	public String getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(String owner_id) {
		this.owner_id=  owner_id;
	}
	public String getShut_id() {
		return shut_id;
	}
	public void setShut_id(String shut_id) {
		this.shut_id=  shut_id;
	}
	public String getTonnage() {
		return tonnage;
	}
	public void setTonnage(String tonnage) {
		this.tonnage=  tonnage;
		
	}
	public String getDimensions() {
		return dimensions;
	}
	public void setDimensions(String dimensions) {
		this.dimensions=  dimensions;
	}
	public String getDate_maintenance() {
		return date_maintenance;
	}
	public void setDate_maintenance(String date_maintenance) {
		this.date_maintenance=  date_maintenance;
	}
}
	