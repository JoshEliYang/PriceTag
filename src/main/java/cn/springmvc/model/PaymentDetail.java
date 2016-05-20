package cn.springmvc.model;

public class PaymentDetail {
	
	private String order_no;
	
	private String item_name;
	
	private String ORDER_CREATE_TIME;

	public String getOrder_no() {
		return order_no;
	}

	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	
	public String getORDER_CREATE_TIME() {
		return ORDER_CREATE_TIME;
	}

	public void setORDER_CREATE_TIME(String oRDER_CREATE_TIME) {
		ORDER_CREATE_TIME = oRDER_CREATE_TIME;
	}
	
	@Override
	public String toString() {
		return "PaymentDetail [order_no=" + order_no + ", item_name="
				+ item_name + ",ORDER_CREATE_TIME=" + ORDER_CREATE_TIME + "]";
	}
	
	public PaymentDetail() {
		super();
	}

	public PaymentDetail(String order_no, String item_name, String ORDER_CREATE_TIME) {
		super();
		this.order_no = order_no;
		this.item_name = item_name;
		this.ORDER_CREATE_TIME = ORDER_CREATE_TIME;
	}

	
}
