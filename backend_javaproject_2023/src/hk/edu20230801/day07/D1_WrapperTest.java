package hk.edu20230801.day07;

public class D1_WrapperTest {

	public static void main(String[] args) {
		int a=10; //기본타입
		Object obj=a;//참조타입에 담기
		//참조타입-->기본타입
//		int b=(Integer)obj;
		int b=(int)obj;
		System.out.println(b+10);
		
		Integer ii=a;//기본타입 --> 참조타입(wrapper class)
		byte bb = ii.byteValue();//참조타입(클래스)을 사용하면 편리한 기능들 사용 가능
		Byte bbb=bb;
		
		//참조타입을 전달하는 경우
		returnObj(new D1_WrapperTest());
		//기본타입을 전달하는 경우
		returnObj(a);
	}
	
	//참조타입을 파라미터로 받아서 반환해 주는 메서드
	public static Object returnObj(Object o) {
		
		return o;
	}
}








