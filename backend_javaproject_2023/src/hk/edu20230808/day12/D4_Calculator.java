package hk.edu20230808.day12;

public abstract class D4_Calculator implements D4_Calc{

	@Override
	public int add(int num1, int num2) {
		return num1+num2;
	}

	@Override
	public int substract(int num1, int num2) {
		return num1-num2;
	}
    //나머지 2개는 구현하려고 봤더니 이 클래스에서는 기능을 구체화하기 힘든 기능이라 하위에서 구현해야함
	@Override
	public abstract int times(int num1, int num2);

	@Override
	public abstract int divide(int num1, int num2);

}




