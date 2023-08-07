package hk.edu20230807.day11;

public class Parent {

	public int a;
	
	public Parent() {
		System.out.println("부모의 생성자입니다.(default)");
	}
	
	public Parent(int a) {
		System.out.println("부모의 생성자입니다.(오버로딩)");
	}
	
	public void parentMethod() {
		System.out.println("부모의 메서드입니다.:parentMethod()");
	}
}









