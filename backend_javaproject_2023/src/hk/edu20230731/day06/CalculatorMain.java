package hk.edu20230731.day06;


public class CalculatorMain {

	public static void main(String[] args) {
		CalculatorA cal=new CalculatorA(50,30);
		cal.a();//덧셈 연산 실행
		System.out.println("결과:"+cal.getResult());
	}

}
