package hk.edu20230807.day11;

public class D2_VIPCustomer extends D2_Customer {
	
	private int agentID;
	double saleRatio; //할인율
	
	public D2_VIPCustomer() {
		customerGrade="VIP";
		bonusRatio=0.05;
		saleRatio=0.1;
	}
	
	public D2_VIPCustomer(int customerID, String customerName, int agentID) {
		super(customerID,customerName);//부모의 생성자를 호출
		customerGrade="VIP";
		bonusRatio=0.05;
		saleRatio=0.1;
		this.agentID = agentID;
	}



	public int getAgentID() {
		return agentID;
	}
	
	@Override
	public int calcPrice(int price) {
		bonusPoint+=price*bonusRatio;//보너스 적립비율 높아졌음
		return price-(int)(price*saleRatio) ;//할인율을 적용함
	}
	
	@Override
	public String showCustomerInfo() {
		return super.showCustomerInfo()+"담당 상담원 아이디는 "+agentID+"입니다.";
	}

}






