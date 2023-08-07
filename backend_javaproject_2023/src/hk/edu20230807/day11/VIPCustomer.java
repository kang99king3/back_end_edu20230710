package hk.edu20230807.day11;

public class VIPCustomer extends Customer {
	
	private int agentID;
	double saleRatio; //할인율
	
	public VIPCustomer() {
		customerGrade="VIP";
		bonusRatio=0.05;
		saleRatio=0.1;
	}
	
	public int getAgentID() {
		return agentID;
	}
	
	@Override
	public int calcPrice(int price) {
		bonusPoint+=price*bonusRatio;//보너스 적립비율 높아졌음
		return price-(int)(price*saleRatio) ;//할인율을 적용함
	}
	

}






