package hk.edu20230807.day11;

public class Customer {

	protected int customerID;
	protected String customerName;
	protected String customerGrade;//상속관계에 있는 클래스간에는 public처럼 쓰임,아니면 default처럼 쓰임
	int bonusPoint;
	double bonusRatio;//적립비율
	
	public Customer() {
		customerGrade = "SILVER";//기본등급
		bonusRatio = 0.01;
	}
	
	public Customer(int customerID, String customerName) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		customerGrade = "SILVER";//기본등급
		bonusRatio = 0.01;
	}

	public int calcPrice(int price) {
		bonusPoint+=price*bonusRatio;
		return price;
	}
	
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", customerGrade="
				+ customerGrade + ", bonusPoint=" + bonusPoint + ", bonusRatio=" + bonusRatio + "]";
	}

	public String showCustomerInfo() {
		return customerName+"님의 등급은"+ customerGrade
				+"이며, 보너스 포인트는 "+bonusPoint +"입니다.";
	}

	//다른 패키지에서 접근 할 수 있도록 메서드를 통해 접근 허용(메서드는 public 정의)
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerGrade() {
		return customerGrade;
	}

	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}
	
	
}
















