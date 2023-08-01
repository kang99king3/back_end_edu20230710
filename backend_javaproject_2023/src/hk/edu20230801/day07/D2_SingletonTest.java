package hk.edu20230801.day07;

public class D2_SingletonTest {
	
	private static D2_SingletonTest singletonTest;//객체를 저장할 맴버필드 작성
	private D2_SingletonTest() {
		//생성자에 접근제한자를 private으로 설정하면 
		//외부에서 객체생성을 하지 못함
	}
	//바로 생성자에 접근을 못하니깐.. 메서드를 통해 객체를 반환해주자
	public static D2_SingletonTest getInstance() {
		if(singletonTest==null) {//null일 경우만 생성하자
			singletonTest=new D2_SingletonTest();
		}
		return singletonTest;
	}
}






