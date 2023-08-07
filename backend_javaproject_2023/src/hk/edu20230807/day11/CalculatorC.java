package hk.edu20230807.day11;

//나눗셈 기능
public class CalculatorC extends Calculator{

	//계산할 값 2개를 맴버필드에 저장하자
//	public int num1;
//	public int num2;
	//접근제한자를 활용하여 바로 접근 못하게 하자
	private int result;//결과를 저장
	
	//생성자 오버로딩을 하면 default 생성자 생략을 못함
	public CalculatorC() {
		super.num1=10;
		super.num2=10;
	}
	
	//초기화작업: 나눗셈계산을 하기위해 객체를 생성할때 2개의 수를 초기화하자
	public CalculatorC(int num1,int num2) { // 생성자 오버로딩
		super.num1=num1;
		super.num2=num2;
	}
	
	//기능 정의: 나눗셈연산
//	public int a() {
//		int result=this.num1+this.num2;
//		return result;
//	}
	@Override
	public void a() {
		//실행된 결과를 객체 자신이 저장하고 쓰려면.. 맴버필드에 저장하자
		this.result=this.num1/this.num2;
	}
	
	//메서드를 통해 접근할 수 있다
	@Override
	public int getResult() {
		return this.result;
	}
}














