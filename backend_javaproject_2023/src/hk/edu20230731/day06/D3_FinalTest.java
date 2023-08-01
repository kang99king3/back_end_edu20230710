package hk.edu20230731.day06;

import java.util.Arrays;
//final은 클래스 상속을 금지한다.
//public class FinalTest extends ParentFinal{
public class D3_FinalTest{
	//static: 정적인 의미
	//final : 금지의 의미
	//static final : 정직이면서 변경 금지 --> 진정한 상수
	
	public static void main(String[] args) {
//      1.간단하게 값 변경 금지되는걸 확인해보자
//		final int A=10;
//		A=20;//변경안됨
		
		//2.메서드에 아큐먼트를 전달하여 실행해본다
		//메서드 실행할때마다 값을 변경하여 실행하면 변경된다.
		D3_FinalTest ft=new D3_FinalTest();
		System.out.println(ft.test01(15)); 
		
		//4.참조타입은 주소값이 저장되기 때문에 내부 값 변경은 가능하다.
		arrayA[0]=10;
//		arrayA=new int[] {13,4};
		System.out.println(Arrays.toString(arrayA));
	}
	
	public int test01(int value) {
		//static인데 메서드 안에서 선언되면 무의미하다.(오류)
//		static final int a=value; 
		final int a=value;//파라미터에 의해 값이 변경되긴 한다...
		return a;
	}
	
	//맴버필드 위치
	//3.static final을 작성하여 선언한다: 상수
	public static final int a=10;//초기값을 반드시 할당해야 한다.
	
	//4.배열은 참조타입(객체): 주소값 변경 금지
	public static final int[] arrayA= {1,2,3,4,5};
	
	public void test02() {
//		test();//상속금지라 사용할 수 없다
		
	}

}
