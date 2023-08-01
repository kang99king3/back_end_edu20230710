package hk.edu20230731.day06;


public class D1_CalculatorMain {

	public static void main(String[] args) {
//		CalculatorA cal=new CalculatorA(50,30);
//		cal.a();//덧셈 연산 실행
//		System.out.println("결과:"+cal.getResult());
//		
		int num1=10;
		int num2=10;
		String calcu="/";
		
		CalculatorCompare cal=new CalculatorCompare();
		cal.calculator(num1, num2, calcu);
		System.out.println(num1+"과"+num2+"의 "+calcu+" 계산 결과:"+cal.getResult());
		
	}

}







