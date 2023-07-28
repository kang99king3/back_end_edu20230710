package hk.edu20230727.day04;

public class MethodTest {

	public static void main(String[] args) {
		
		MethodTest mt=new MethodTest();
//		mt.main(args);
		test01();
//		test02();//설계도-->제품
		mt.test02();//객체를 생성해서 메서드를 사용
		
		test05(25,40);
	}
	
	//메서드의 유형
	
	//1.static과 non-static메서드
	//static메서드
	public static void test01() {
		System.out.println("static메서드");
	}
	//non-static메서드: 주로 사용되는 유형
	public void test02() {
		System.out.println("non-static메서드");
	}
	
	//2.반환타입O/반환타입X
	public int test03() {
		
		return 0;//반환값이 있다면 반드시 return 값을 작성해야 한다.
	}
	public void test04() {
		int num=test03();
	}//반환값을 작성할 필요 없음.
	
	//3.파라미터O/X 
	public static void test05(int a, int b) {
		int result=a+b;
		System.out.println(result);
	}
}










