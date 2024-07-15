package hk.edu202308089.day14;

public class Main {

	public static void main(String[] args) {
		
		CakePlate cake=new CakePlate();
		CakeMaker baker=new CakeMaker(cake);
		CakeEater eater=new CakeEater(cake);
		
		Thread t1=new Thread(baker);
		Thread t2=new Thread(eater);
		
		t1.setPriority(6);
		t1.start();
		t2.start();

	}

}
