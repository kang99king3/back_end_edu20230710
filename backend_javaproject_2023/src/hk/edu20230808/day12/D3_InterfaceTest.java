package hk.edu20230808.day12;

public interface D3_InterfaceTest {

	//다중상속 흉내.. extends..implements..
//	public class Test extends ParentTest implements IParent{ }
	
	//인터페이스는 다중 구현이 가능함 implements A,B,C..
//	public class Test implements A,B,C{}
	
	//인터페이스끼리 상속 가능
//	public interface A extends B{}
	
	//상수 선언
	public static final int A=5;
	
	//추상메서드
	public abstract int test();
	
	//default메서드 추가
	public default void test3() {
		test2();
		System.out.println("인터페이스를 구현한 객체가 사용한다.");
	}
	
	//private 메서드: 구현한 클래스에서는 사용 불가, 인터페이스 내부에서만 사용할 공통 기능들 구현
	private void test2() {
		System.out.println("인터페이스 내부에서 공통기능을 구현");
	}
	
	//static 메서드: InterfaceTest.test4()로 호출해서 사용
	public static void test04() {
		System.out.println("인터페이스만으로 실행시킬 수 있다.");
	}
	
	
}











