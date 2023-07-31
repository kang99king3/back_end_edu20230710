package hk.edu20230731.day06;

public class ImmutableTest {

	public String ss="HI";
	
	public static void main(String[] args) {
		
		String s="HI";//String만 특별하게 기본타입의 성격 적용
		change01(s);
		System.out.println("원본값:"+s);
		
		ImmutableTest it=new ImmutableTest();
		change02(it);//ss값을 "안녕"으로 변경
		System.out.println("원본값:"+it.ss);//원본값 변경됨
	}	
	
	public static void change02(ImmutableTest it) {
		it.ss="안녕";
	}
	
	public static void change01(String s) {
		s="안녕";
	}
	
	
}
