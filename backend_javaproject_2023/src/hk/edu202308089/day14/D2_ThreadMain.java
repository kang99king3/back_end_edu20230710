package hk.edu202308089.day14;

public class D2_ThreadMain {

	//스레드를 생성하는 방법 2가지
	public static void main(String[] args) {
		
		//1.Runnable을 구현하는 방법 --> 장점은 다른 클래스를 상속받을 수 있다 
		Runnable run=new D2_TestRunnable();
		Thread tr=new Thread(run);
		tr.setPriority(10);//priority우선순위를 정할 수 있다. 1~10까지
		tr.start();
		
		//2.Thread클래스를 상속받는 방법 --> Thread를 상속받았기 때문에 다른 클래스를 상속받을 수 없다.
		D2_ThreadInheritance thr=new D2_ThreadInheritance();
		thr.setPriority(Thread.MIN_PRIORITY);//가장 하위(상위)의 순위값을 상수로 표현할 수 있다.
		thr.start();
		
		//메인스레드
		for (int i = 0; i < 5; i++) {
			System.out.println("나는 메인 스레드야");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
