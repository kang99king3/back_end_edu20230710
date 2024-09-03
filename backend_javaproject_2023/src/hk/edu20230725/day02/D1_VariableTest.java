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
		long l=500000000000L;//int크기를 벗어나면 오류(기본형이 int이기때문에)--> L을 붙여줌
		
		//2.실수형
		double d=15.8;
//		float f=30.15F;
		float f1=(float)40.2;// <---실수의 기본형은 double타입이다.
		
//		float f2=d+f1;//double타입과 float타입의 연산은 double타입이 된다.
		
		//3.다른 타입끼리 연산
		int ii=(int)(i+d); //int + double = double
		int iii=i+(int)d; //형변환 후 연산 --> double형에 소수점값은 없어진다.
		double dd=i+d; // 자동형변환 후 연산 --> 큰 타입에 저장할 경우
		System.out.println(ii+":"+dd);
		
		//4.정수형끼리 연산
		byte bb=10;
		byte bb2=20;
		byte resultB =(byte)(bb+bb2); // <--b+b 기본 int형으로 변환하여 연산
		
		int i2=40;
		int i3=i2+bb;
	}
}




