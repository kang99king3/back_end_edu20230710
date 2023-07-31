package hk.edu20230731.day06;

//뺄셈
public class CalculatorB {

	public int num1;
	public int num2;
	private int result;
	
	public CalculatorB() {
//		super(); //super생성자가 실행되고
		this(10,10);
	}

	public CalculatorB(int num1, int num2) {
		super();//여기서도 실행되고 ---> 생성자는 한번만 실행되야 한다.
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





