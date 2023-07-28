package hk.edu20230728.day05;

public class D4_ConstructorMain {

	public static void main(String[] args) {
		//default생성자는 단독으로 쓰일때는 생략이 가능함
		//오버로딩을 하면 생략 못함
		D4_ConstructorTest tv=new D4_ConstructorTest();
		System.out.println("tv의 size:"+tv.getSize());
		
		D4_ConstructorTest tv30=new D4_ConstructorTest(30);
		System.out.println("tv의 size:"+tv30.getSize());
		
		D4_ConstructorTest tv40=new D4_ConstructorTest(40,"파란색");
		System.out.println("tv의 size:"+tv40.getSize());
		System.out.println("tv의 color:"+tv40.color);
	}

}




