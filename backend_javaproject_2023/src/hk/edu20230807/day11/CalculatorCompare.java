package hk.edu20230807.day11;

public class CalculatorCompare {
	
	//은닉화(캡슐화)
	private int result;//연산결과를 저장할 맴버필드
	
	
	public void calculator(int num1, int num2, String cal) {
		
		Calculator calObj=null;//부모타입
		//분기형태로 실행, 구현하자..   == 주소로 비교, equals() hashcode 비교
		if(cal.equals("+") ) {
			calObj=new CalculatorA(num1,num2);
			calObj.a();//덧셈연산 실행
			//부모타입에 없는 메서드라 getResult() 호출 불가 --> 부모에 만들고 자식에서 오버라이딩
			this.result=calObj.getResult();//calA에 계산결과를 CalculatorCompare result에 저장
		}else if(cal.equals("-")) {
			calObj=new CalculatorB(num1, num2);
			calObj.a();//뺄셈연산 실행
			this.result=calObj.getResult();
		}else if(cal.equals("/")) {
			calObj=new CalculatorC(num1, num2);
			calObj.a();//뺄셈연산 실행
			this.result=calObj.getResult();
		}else if(cal.equals("*")) {
			calObj=new CalculatorD(num1, num2);
			calObj.a();//뺄셈연산 실행
			this.result=calObj.getResult();
		}else {
			System.out.println("입력된 연산자의 내용을 확인하세요~~~");
		}
	}

	//은닉화된 맴버필드의 값을 반환시켜줄 메서드
	public int getResult() {
		return result;
	}
	
	
}







