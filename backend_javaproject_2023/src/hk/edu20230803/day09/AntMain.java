package hk.edu20230803.day09;

public class AntMain {

	//String 객체의 concatenation 특징과 charAt() 메서드를 활용
	//            문자열을 만나면 모두 문자열로 형변환된다.
	public static void main(String[] args) {
		AntQuiz ant=new AntQuiz();
//		String s=ant.antMake("1121");
//		System.out.println(s);
		
		//다음 숫자를 만드는 기능을 구현했음: antMake(s)
		//--> 사용자가 직접 다음값을 입력해야 하는 문제
		// 10번째에 어떤값이 생성될지.. 10이란 숫자를 전달하면 1~10번째까지 
		//                         숫자가 출력되도록 구현
		ant.antPrint(20);
	}

}
