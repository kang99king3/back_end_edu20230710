package hk.edu202308089.day14;

public class D4_CakePlate {

	private int breadCount=0;
	public D4_CakePlate(){
		
	}
	public synchronized void makeBread(){
		if(breadCount>=10){
			System.out.println("빵이 남는다");
			try {
				wait();//일시정지
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		breadCount++;
		System.out.println("빵을 1개 더 만듧 총:"+breadCount+"개");
		this.notifyAll();//모든 스레드 실행대기--> wait되어 있는 스레드를 실행대기상태로 만든다.
		//카운트를 올리고 모든 스레드 실행대기로 만들면서 계속 실행하다가 조건에 맞으면 wait걸리고, 
		//실행대기중인 다른 스레드가 실행되면서 notifyAll이 실행되면 다른 모든 스레드를 실행대기로 만든다.
		//이 과정에서 synchronized되어 있어서 현재 실행중인 스레드가 종료될때 까지 다른 스레드는 실행대기가 된다. 
		//makeBread()->notifyAll() -> wait() -> eatBread() -> notifyAll() -> wait() ->...
	}
	public synchronized void eatBread(){
		if(breadCount<1){
			System.out.println("빵이 모자라 기다림");
			try {
				wait();//일시정지
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		breadCount--;
		System.out.println("빵을 1개 먹음 총:"+breadCount+"개");
		this.notifyAll();//모든 스레드 실행대기-> 스케쥴러에 의해 실행됨
	}
}

