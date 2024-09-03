package hk.edu202308089.day14;

public class D4_CakeMain {

	public static void main(String[] args) {
		
		D4_CakePlate cake=new D4_CakePlate();
		D4_CakeMaker baker=new D4_CakeMaker(cake);
		D4_CakeEater eater=new D4_CakeEater(cake);
		
		Thread t1=new Thread(baker);
		Thread t2=new Thread(eater);
		
		t1.setPriority(6);
		t1.start();
		t2.start();

	}

}
