package com.prodezy.product_customer;

public class ProductDr {

		private String fg_c_id;
		private String m_fg_id;
		private String m_cust_id;
		private String part_name;
		private String customer_name;
		private String sales_rate;
		private String s_uom_id;
		private String uom;
		
		public ProductDr(String fg_c_id, String m_fg_id, String m_cust_id, String sales_rate, String s_uom_id,String part_name,String customer_name,String uom) {
			super();
			this.fg_c_id = fg_c_id;
			this.m_fg_id = m_fg_id;
			this.m_cust_id = m_cust_id;
			this.sales_rate = sales_rate;
			this.s_uom_id = s_uom_id;
			this.part_name = part_name;
			this.customer_name=customer_name;
			this.uom=uom;
		}
		public String getPart_name() {
			return part_name;
		}
		public void setPart_name(String part_name) {
			this.part_name = part_name;
		}
		public String getUom() {
			return uom;
		}
		public void setUom(String uom) {
			this.uom = uom;
		}
		public String getCustomer_name() {
			return customer_name;
		}
		public void setCustomer_name(String customer_name) {
			this.customer_name = customer_name;
		}
		public String getFg_c_id() {
			return fg_c_id;
		}
		public void setFg_c_id(String fg_c_id) {
			this.fg_c_id = fg_c_id;
		}
		public String getM_fg_id() {
			return m_fg_id;
		}
		public void setM_fg_id(String m_fg_id) {
			this.m_fg_id = m_fg_id;
		}
		public String getM_cust_id() {
			return m_cust_id;
		}
		public void setM_cust_id(String m_cust_id) {
			this.m_cust_id = m_cust_id;
		}
		public String getSales_rate() {
			return sales_rate;
		}
		public void setSales_rate(String sales_rate) {
			this.sales_rate = sales_rate;
		}
		public String getS_uom_id() {
			return s_uom_id;
		}
		public void setS_uom_id(String s_uom_id) {
			this.s_uom_id = s_uom_id;
		}
	
}
