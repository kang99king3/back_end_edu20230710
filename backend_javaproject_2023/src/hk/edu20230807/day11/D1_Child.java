package hk.edu20230807.day11;

//상속: 키워드 extends, 다중상속 X
public class D1_Child extends D1_Parent{

	//자식이 생성되면 부모가 생성된다.Child생성자가 호출되면 super(Parent)생성자가 호출된다.
	public D1_Child() {
//		super();//생략되어 있다...   항상 첫줄에 작성, 부모가 먼저 생성되고 자식이 생성된다.
		this(5);
		System.out.println("자식의 생성자입니다.(default)");
	}
	
	public D1_Child(int a) {
//		super();
		super(a);
		System.out.println("자식의 생성자 오버로딩입니다.");
	}
	
	//오버라이딩: 부모의 메서드를 자식에서 재정의 한다.
	@Override
	public void parentMethod() {
		System.out.println("자식이 주변환경에 맞게 코드를 다시 재정의해서 사용한다.:parentMethod()");
	}
	
	public void childMethod() {
		System.out.println("자식 클래스에만 있는 메서드");
	}
	
	@Override
	public String toString() {
		//기본기능: 기본타입에 경우는 값을 문자열로 반환
		//        참조타입에 경우는 주소@해시코드를 문자열로 반환
		return "나는 Child객체입니다.";
	}
}















