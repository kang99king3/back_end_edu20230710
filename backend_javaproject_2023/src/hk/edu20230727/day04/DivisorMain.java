package hk.edu20230727.day04;

public class DivisorMain {

	public static void main(String[] args) {
		Divisor div=new Divisor();
//		div.perfectNum(0, 0); 
		
		Divisor.perfectNum(1, 1000);
		int num=div.num;
	}

}
