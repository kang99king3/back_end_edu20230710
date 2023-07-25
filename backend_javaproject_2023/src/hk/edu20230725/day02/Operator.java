package hk.edu20230725.day02;

public class Operator {

	public static void main(String[] args) {
		//관계연산자
		System.out.println(10>5);
		int i=10;
		int ii=5;
		
		if(i>ii) {
			System.out.println("10이 크다");
		}else{
			System.out.println("10이 작다");
		}
		
		//삼항연산자
		String s=i>ii?"10크다":"10이작다";
		System.out.println(s);
		System.out.println(i>ii?"10크다":"10이작다");
		
		//단축연산자
		int iii=1;
		int sum=1;
		while(sum<20) {
			sum+=iii;// sum=sum+iii;
			System.out.println(sum);
//			sum++;
		}
		
		//증감연산자
		int x = 10;
		System.out.println(x++);  // 10 출력 후 1증가 ⇒ 11 저장
		System.out.println(x);      // 11 출력
		System.out.println(++x);  // 1 증가 후 출력 ⇒ 12 출력
		System.out.println(x);     // 12 출력
		
		//논리연산자
		int i3 = 1, j = 2, k = 3;
		System.out.println("i3 = " + i3 + ", j = " + j + ", k = " + k);
		System.out.println("i3 < j && j < k의 결과는 : " + (i3 < j && j < k));
		System.out.println("i3 < j || j < k의 결과는 : " + (i3 < j || j < k));
		System.out.println("!(i3 < j) || !(j < k)의 결과는 : "+(!(i3 < j) || !(j < k)));

	}
}



