package hk.edu20230731.day06;

public class CalculatorCompare {
	
	//은닉화(캡슐화)
	private int result;//연산결과를 저장할 맴버필드
	
	
	public void calculator(int num1, int num2, String cal) {
		//분기형태로 실행, 구현하자..   == 주소로 비교, equals() hashcode 비교
		if(cal.equals("+") ) {
			CalculatorA calA=new CalculatorA(num1,num2);
			calA.a();//덧셈연산 실행
			this.result=calA.getResult();//calA에 계산결과를 CalculatorCompare result에 저장
		}else if(cal.equals("-")) {
			CalculatorB calB=new CalculatorB(num1, num2);
			calB.a();//뺄셈연산 실행
			this.result=calB.getResult();
		}else if(cal.equals("/")) {
			CalculatorC calC=new CalculatorC(num1, num2);
			calC.a();//뺄셈연산 실행
			this.result=calC.getResult();
		}else if(cal.equals("*")) {
			CalculatorD calD=new CalculatorD(num1, num2);
			calD.a();//뺄셈연산 실행
			this.result=calD.getResult();
		}else {
			System.out.println("입력된 연산자의 내용을 확인하세요~~~");
		}
	}

	//은닉화된 맴버필드의 값을 반환시켜줄 메서드
	public int getResult() {
		return result;
	}
	
	
}







