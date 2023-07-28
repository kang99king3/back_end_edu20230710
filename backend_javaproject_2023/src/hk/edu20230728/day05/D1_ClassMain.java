package hk.edu20230728.day05;

public class D1_ClassMain {

	public static void main(String[] args) {
		
		D1_ClassTest ct01=new D1_ClassTest();// 객체 생성 ct01
		ct01.methodTest();//객체명.메서드명
		D1_ClassTest.staticMethodTest();//정적메서드
		int num=ct01.number;
		int numStatic=D1_ClassTest.staticNumber;
		
		D1_ClassTest ct02=new D1_ClassTest();// 객체 생성 ct02
		ct02.methodTest();
		int num2=ct02.number;
		
		//인스턴스 변수는 객체 각각에 대해 정의 되기 때문에 서로 영향을 받지 않는다.
		ct01.number=10;
		System.out.println(ct01.number);
		System.out.println(ct02.number);
		
		ct01.staticNumber=30;
		System.out.println(ct01.staticNumber);
		System.out.println(ct02.staticNumber);
	}

}




