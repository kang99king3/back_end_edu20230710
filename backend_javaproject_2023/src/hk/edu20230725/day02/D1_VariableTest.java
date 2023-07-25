package hk.edu20230725.day02;

public class D1_VariableTest {

	public static void main(String[] args) {
		
		//기본타입의 특징
		//immutable 특징
		int a=10; //원본
		int aa=a; //복사본: 기본타입은 값을 복사해서 전달한다.
			aa=15;//복사본쪽에서 값을 바꿔도 원본은 바뀌지 않는다.
		System.out.println("aa의 값은?:"+aa);
		System.out.println("a의 값은?:"+a);
		
		//1.정수타입
		//변수 선언, 초기화
		byte b=1; //-128~127 숫자를 표현
//			 b=128;//128은 표현범위를 벗어나서 오류가 뜸
		short sh=128;//2byte크기니깐 저장됨
		int i=5000000;//4byte크기 <---java에서 정수 기본타입
		long l=500000000000L;//int크기를 벗어나면 오류--> L을 붙여줌
		
		
		
	}
}
