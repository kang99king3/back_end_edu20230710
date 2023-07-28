package hk.edu20230728.day05;

public class D3_AccessTest {

	//맴버필드
	public int a;
	       int b;//default 접근제한자
	private int c;//클래스 내부에서만 접근할 수 있다.
	
	//getter메서드
	public int getC() {
//		if(pw==1234) {
//			return c;
//		}else {
//			return 0;
//		}
		return c;
	}
}
