package hk.edu20230728.day05;


// javap java.lang.Object 
//클래스의 구성 내용
public class ClassTest{

	//맴버필드: 클래스에서 저장하는 저장공간
	public int number;//인스턴스 변수
	public static int staticNumber;//클래스 변수
	
	//기본 생성자: default 생성자라고 함, 파라미터가 없음, 생략 가능, 클래스의 초기화 작업 수행
	public ClassTest() {
		super();// 부모의 생성자를 호출, 생략가능
//		this.number=6 ;
		this.number=5;//초기값 설정
		System.out.println("default생성자가 실행됨: ClassTest()");
	}
	
	//메서드: 함수의 한 종류이며, 클래스 내부에서 선언되어 사용된다.
	//호출방법: 객체명.메서드명() 
	public void methodTest() {
		System.out.println("클래스의 기능을 담당하는 메서드");
	}
	//정적메서드: static 메모리에 이미 올라가 있으므로 객체 생성없이 호출 가능하다.
	//호출방법: 클래스명.메서드명()
	public static void staticMethodTest() {
		System.out.println("클래스의 기능을 담당하는 static 메서드");
	}
	
}











