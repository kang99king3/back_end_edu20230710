package hk.edu20230807.day11;

public class Calculator {

	//저장할 변수 2개 선언
	public int num1;
	public int num2;
	
	public Calculator() {
		System.out.println("Calculator부모생성자");
	}
	
	//추상메서드로 정의:여기서 기능 정의가 힘들어서 구현하지 않고 하위클래스에서 구현하도록 함
	public void a() {
		System.out.println("부모에서 정의한 a()");
	}
	
	public int getResult() {
		System.out.println("부모에서 기능 정의하기가 애매함");
		return 0;
	}
}











