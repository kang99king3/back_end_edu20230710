package hk.edu20230728.day05;

public class D3_AccessMain {

	public static void main(String[] args) {
		D3_AccessTest at=new D3_AccessTest();
		int c=at.getC();//감춰져 있어서 메서드를 통해 가져온다(은닉화)
		int a=at.a;//모든 위치에서 다 접근 가능
	}
}
