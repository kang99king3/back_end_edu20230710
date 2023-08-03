package hk.edu20230803.day09;

import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {
		//선언 방법
		//1.리터럴 선언:변수와 값을 동시에 정의한다.
		int [] a= {1,2,3,4,5,6};
		
		int [] b;//변수만 선언, 자릿수X, 초기값X
		b=a;//a객체의 주소값을 할당
//		b= {1,2,3,4,5,6};//(X) 리터럴 방식은 선언과 초기화 작업을 따로 할수 없다
		
		//값을 가져오는 방법: 인덱스를 통해서 가져온다
		int value=a[0];//0번째 인덱스에 값을 저장
		a[0]=10; a[1]=20;// 배열에 저장하기
		
		//2.new를 사용하여 정의한다.
		int [] b2;
		b2=new int [] {1,2,3,4,5,6};
		
		int [] b3=new int[5];//선언,자릿수 정의
		b3[0]=1; b3[1]=2; b3[2]=3; //값을 저장
		
		//for문을 이용해서 내용을 출력
		for (int i = 0; i < b3.length; i++) {
			System.out.println(b3[i]+" ");
		}
		
		//Arrays클래스를 활용해서 출력
		System.out.println(Arrays.toString(b3));//"[1, 2, 3, 0, 0]"
		
		//배열의 값을 정렬해주는 메서드
		Arrays.sort(b3);//주소에 의해 원본이 바뀐다(mutable)
		System.out.println(Arrays.toString(b3));
		
		//immutable 원본 안바뀜
		String s="aa";
		s=s.replace("a", "b");
		System.out.println(s);
		
		//shallow copy(얕은 복사:주소로 복사)
		int [] c= {1,2,3,4,5};
		int [] d= c;// c-->d로 주소가 복사
		d[0]=30;
		System.out.println(Arrays.toString(c));
		
		//deep copy(깊은 복사: 값을 복사)
		int [] e=new int [5];
		for (int i = 0; i < c.length; i++) {
			e[i]=c[i];
		}
		
		e[1]=50;
		System.out.println(Arrays.toString(c));
		
		//System.arraycopy(원본배열,복사시작인덱스,복사본배열,시작인덱스,길이)사용하여 편리하게 깊은 복사 구현
		int [] f=new int [5];
		System.arraycopy(c, 0, f, 0, f.length);
		System.out.println(Arrays.toString(f));
	}
}











