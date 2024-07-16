package hk.edu202308089.day14;

public class CakeMaker implements Runnable{
	private CakePlate cake;
	public CakeMaker(CakePlate cake){
		setCakePlate(cake);
	}
	private void setCakePlate(CakePlate cake) {
		this.cake=cake;
		
	}
	public CakePlate getCake() {
		return cake;
	}
	@Override
	public void run() {
		for (int i = 0; i < 30; i++) {
			cake.makeBread();
		}
	}
}
