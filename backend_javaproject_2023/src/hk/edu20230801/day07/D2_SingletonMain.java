package hk.edu20230801.day07;

public class D2_SingletonMain {

	public static void main(String[] args) {
		
		//객체생성: new + 생성자를 호출한다
		//              생성자에 접근한다.--> 접근 못하게 하려면?
//		SingletonTest single=new SingletonTest();//접근못해서 실행할 수 없다(강제)
//		SingletonTest single=getInstance();//non-static 메서드: 객체명.메서드() 호출
		D2_SingletonTest single1=D2_SingletonTest.getInstance();
		
		//정말 한번만 생성되는지 확인해보자
		D2_SingletonTest single2=D2_SingletonTest.getInstance();
		D2_SingletonTest single3=D2_SingletonTest.getInstance();
		D2_SingletonTest single4=D2_SingletonTest.getInstance();
		
		System.out.println(single1==single2);//주소로 비교해보기
		System.out.println(single1.equals(single2));//hashcode로 비교해보기
	}

}

















