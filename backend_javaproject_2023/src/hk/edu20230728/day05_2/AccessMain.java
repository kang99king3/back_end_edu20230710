package hk.edu20230728.day05_2;

import hk.edu20230728.day05.AccessTest;

public class AccessMain {

	public static void main(String[] args) {
		AccessTest at=new AccessTest();
		int a=at.a;
//		int b=at.b;// default 접근제한자는 같은 패키지에서만 접근가능
	}
}
