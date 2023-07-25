package hk.edu20230724.day01;


//명명법, 식별자 확인
//클래스명: 파스칼(첫글자 대문자로 시작)
//        파일명과 동일해야함
public class LibraryTest {
	//main메서드 : java코드를 실행시켜 주는 특별한 메서드
	public static void main(String[] args) {
		//syso 단축키
		System.out.println("안녕하세요~ 자바~~");
		
		//String public = "예약어";//예약어X
		
		testMethod();
		testMethod02();
	}
	
	//메서드작성: 클래스내부에서의 기능정의, 단독으로 기능정의 함수
	//메서드명: 카멜방식 소문자로 시작
	static void testMethod() {
		
		//타입 + 변수명 --> 선언
		boolean isS=true; 
		int i = 100;
		
		i=i+100;
		
		System.out.println("메서드실행:"+i);
	}
	
	//void: 반환값이 없는 메서드에 선언
	static void testMethod02() {
		int i=10;
		if(i<15) {
			int ii=5;
			ii=ii+i;// i는 사용 가능[블럭내부]
		}
//		i=i+ii; //ii는 블럭 외부라 사용 불가능
	}
	
}



