package hk.edu202308089.day14;

public class ThreadTestMain {
	public static void main(String[] args) {
		ThreadTestMain tm=new ThreadTestMain();
		StringDisplay sd = tm.new StringDisplay();//내부클래스는 외부클래스가 객체생성되야 생성시킬 수 있다
		MyThread[] mts = new MyThread[5];
		for (int i=0; i<mts.length; i++) {
			mts[i] = tm.new MyThread(sd, Integer.toString(i));	//내부클래스는 외부클래스가 객체생성되야 생성시킬 수 있다
			mts[i].start();
		}
	}
	
	class StringDisplay {
		synchronized void display(String s) {
			for (int i=0; i<5; i++) {
				System.out.print(s);
			}
			System.out.println("");
		}
	}
	
	class MyThread extends Thread {
		StringDisplay sd;
		String s = "";
		
		public MyThread(StringDisplay sd, String s) {
			this.sd = sd;
			this.s = s;
		}
		
		@Override
		public void run() {
			sd.display(s);
		}
	}
}
