package hk.edu20230731.day06;

//final 예약어를 붙여주면 상속을 금지
public final class ParentFinal {
	
	public int number;
	
	public void test() {
		//test메서드를 사용하고 싶다.
		System.out.println("난 부모 메서드야");
	}
}
