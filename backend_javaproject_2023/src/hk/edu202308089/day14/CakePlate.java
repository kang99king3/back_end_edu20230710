package hk.edu202308089.day14;

public class CakePlate {

	private int breadCount=0;
	public CakePlate(){
		
	}
	public synchronized void makeBread(){
		if(breadCount>=10){
			System.out.println("���� ���´�");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		breadCount++;
		System.out.println("���� 1�� �� ���� ��:"+breadCount+"��");
		this.notifyAll();
	}
	public synchronized void eatBread(){
		if(breadCount<1){
			System.out.println("���� ���ڶ� ��ٸ�");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		breadCount--;
		System.out.println("���� 1�� ���� ��:"+breadCount+"��");
		this.notifyAll();
	}
}
