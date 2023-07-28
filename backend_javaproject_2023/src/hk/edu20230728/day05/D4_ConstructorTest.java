package hk.edu20230728.day05;

public class D4_ConstructorTest {

	//티비 객체 
	private int size=0;//티비의 화면 사이즈 : 중간에 변경하면 안되는 중요한 값
	public String color="검정색";//색상
	

	public D4_ConstructorTest() {
		super();// 부모의 생성자를 호출( 반드시 첫줄에 작성)
		this.size=20;
	}
	
	//생성자 오버로딩
	public D4_ConstructorTest(int size) {
		super();// 부모의 생성자를 호출( 반드시 첫줄에 작성)
		this.size=size;
	}
	
	//생성자 오버로딩
	public D4_ConstructorTest(int size,String color) {
		super();// 부모의 생성자를 호출( 반드시 첫줄에 작성)
		this.size=size;
		this.color=color;
	}
	
	//값을 가져오기
	public int getSize() {
		return size;
	}
	//값을 저장하기
	public void setSize(int size) {
		this.size = size;
	}
	
	
}
