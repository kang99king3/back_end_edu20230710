package hk.edu20230807.day11;

//뺄셈
public class CalculatorB extends Calculator{

//	public int num1;
//	public int num2;
	private int result;
	
	public CalculatorB() {
//		super(); //super생성자가 실행되고
		super.num1=10;
		super.num2=10;
	}

	public CalculatorB(int num1, int num2) {
		super();//여기서도 실행되고 ---> 생성자는 한번만 실행되야 한다.
		super.num1 = num1;
		super.num2 = num2;
	}
	
	//뺄셈기능
	@Override
	public void a() {
		this.result=this.num1-this.num2;
	}
	@Override
	public int getResult() {
		return result;
	}
	
	
}





