package hk.edu20230807.day11;

public class D2_CustomerTest1 {

	public static void main(String[] args) {
//		Customer customerLee = new Customer();
//		customerLee.setCustomerID(10010);
//		customerLee.setCustomerName("이순신");
//		customerLee.bonusPoint=1000;
//		System.out.println(customerLee.showCustomerInfo());
//		
//		VIPCustomer customerKim = new VIPCustomer();
//		customerKim.setCustomerID(10020);
//		customerKim.setCustomerName("김유신");
//		customerKim.bonusPoint=10000;
//		System.out.println(customerKim.showCustomerInfo());
		
		D2_Customer customerLee = new D2_Customer(10010,"이순신");
		customerLee.bonusPoint=1000;
		System.out.println(customerLee.showCustomerInfo());
		
		D2_VIPCustomer customerKim = new D2_VIPCustomer(10020,"김유신",20010);
		customerKim.bonusPoint=10000;
		System.out.println(customerKim.showCustomerInfo());
	}
}





