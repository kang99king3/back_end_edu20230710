package hk.edu202308089.day14;

public class D4_CakeEater implements Runnable{
	
	private D4_CakePlate cake;
	
	
	public D4_CakeEater(D4_CakePlate cake) {
		setCakePlate(cake);
	}

	public D4_CakePlate getCakePlate() {
		return cake;
	}

	public void setCakePlate(D4_CakePlate cake) {
		this.cake = cake;
	}

	@Override
	public void run() {
		for (int i = 0; i < 30; i++) {
			cake.eatBread();
		}
		
	}

}

