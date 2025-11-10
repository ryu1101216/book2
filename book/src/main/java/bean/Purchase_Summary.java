package bean;

public class Purchase_Summary implements java.io.Serializable {

	private int product_id;
	private String product_name; 
	private int count;
	private int unit_price;
	private int total_price;
	private String customer_name;

	public int getProduct_id() {
		return product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public int getCount() {
		return count;
	}
	public int getUnit_price() {
		return unit_price;
	}
	public int getTotal_price() {
		return total_price;
	}
	public String getCustomer_name() {
		return customer_name;
	}

	public void setProduct_id(int product_id) {
		this.product_id=product_id;
	}
	public void setProduct_name(String product_name) {
		this.product_name=product_name;
	}
	public void setCount(int count) {
		this.count=count;
	}
	public void setUnit_price(int unit_price) {
		this.unit_price=unit_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price=total_price;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name=customer_name;
	}
}
