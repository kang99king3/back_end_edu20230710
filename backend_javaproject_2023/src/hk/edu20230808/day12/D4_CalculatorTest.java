package hk.edu20230808.day12;

public class D4_CalculatorTest {

	public static void main(String[] args) {
		D4_Calc calc=new D4_CompleteCalc();//인터페이스 타입으로 저장
//		CompleteCalc calc=new CompleteCalc();
		System.out.println(calc.add(10, 5));
		System.out.println(calc.substract(10, 5));
		System.out.println(calc.times(10, 5));
		System.out.println(calc.divide(10, 5));
//		calc.showInfo();//Calc인터페이스에는 없는 메서드, 다운캐스팅해서 써야함
	}

}
