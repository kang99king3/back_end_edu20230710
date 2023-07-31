package hk.edu20230731.day06;

//뺄셈
public class CalculatorB {

	public int num1;
	public int num2;
	private int result;
	
	public CalculatorB() {
//		super();
		this(10,10);
	}

	public CalculatorB(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}
	
	//뺄셈기능
	public void a() {
		this.result=this.num1-this.num2;
	}

	public int getResult() {
		return result;
	}
	
	
}





