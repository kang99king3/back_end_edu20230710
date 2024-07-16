package hk.edu202308089.day14;

public class D1_ThreadTest01 {

	public static void main(String[] args) {
		//"안","녕"을 번갈아 가며 출력하려고 했는데 안됨
//		for (int i = 0; i < 5; i++) {
//			System.out.println("안");
//		}
//		
//		for (int i = 0; i < 5; i++) {
//			System.out.println("녕");
//		}
		//작업단위 하나
		Thread t1=new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("안");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		//작업단위 둘
		Thread t2=new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("녕");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		t1.start();
		t2.start();
	}
	

//	
//	public void test() {
//		Thread tr=new ThreadObj1();
//		tr.start();
//	}
	
	//1.Thread클래스를 상속받은 Thread 클래스를 정의할 수 있다.
//	class ThreadObj1 extends Thread{
//		
//		@Override
//		public void run() {
//			for (int i = 0; i < 5; i++) {
//				System.out.print("ThreadTest1:"+i+" ");
//			}
//			System.out.println();
//		}
//	}
}
