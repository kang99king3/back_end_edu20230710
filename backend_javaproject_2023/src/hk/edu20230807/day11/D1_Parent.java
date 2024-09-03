package hk.edu20230807.day11;

//final 붙이면 상속금지
public  class D1_Parent {

	public int a;
	
	public D1_Parent() {
		System.out.println("부모의 생성자입니다.(default)");
	}
	
	public D1_Parent(int a) {
		System.out.println("부모의 생성자입니다.(오버로딩)");
	}
	//final 붙이면 오버라이딩 금지
	public  void parentMethod() {
		System.out.println("부모의 메서드입니다.:parentMethod()");
	}
}









