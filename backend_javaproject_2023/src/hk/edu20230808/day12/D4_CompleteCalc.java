package hk.edu20230808.day12;

public class D4_CompleteCalc extends D4_Calculator{

	@Override
	public int times(int num1, int num2) {
		return num1*num2;
	}

	@Override
	public int divide(int num1, int num2) {
		if(num2!=0) {// 어떤수를 0으로 나누면 에러나요~
			return num1/num2;			
		}else {
			return D4_Calc.ERROR;
		}
	}

	//하위클래스에서 새로 추가한 메서드
	public void showInfo() {
		System.out.println("Calc 인터페이스를 구현합니다.");
	}
}




