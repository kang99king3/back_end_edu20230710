package hk.edu202308089.day14;

public class CakeEater implements Runnable{
	
	private CakePlate cake;
	
	
	public CakeEater(CakePlate cake) {
		setCakePlate(cake);
	}

	public CakePlate getCakePlate() {
		return cake;
	}

	public void setCakePlate(CakePlate cake) {
		this.cake = cake;
	}

	@Override
	public void run() {
		for (int i = 0; i < 30; i++) {
			cake.eatBread();
		}
		
	}

}

