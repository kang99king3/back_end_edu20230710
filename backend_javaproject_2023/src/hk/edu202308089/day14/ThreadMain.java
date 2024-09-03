package hk.edu202308089.day14;

public class ThreadMain {
	
	class StringBufferTest{
		
//		String s;
		StringBuffer sb=new StringBuffer("ABCD");
//		StringBuilder sb=new StringBuilder("ABCD");
		public StringBufferTest() {
			// TODO Auto-generated constructor stub
		}
		public StringBufferTest(String s) {
//			this.s=s;
		}
		public  void printBuffer(String s) {
				
				sb.append(s);
				
				System.out.println(sb.toString());
			
		}
	}

	public static void main(String[] args) {
//		Mythread[] arrayT=new Mythread[5];
//		AsynchronizedObj aobj=new AsynchronizedObj();
//		for (int i = 0; i < arrayT.length; i++) {
//			arrayT[i]=new Mythread(aobj,i+"");
//			arrayT[i].start();
//			
//		}
	
		StringBufferTest sbt=new ThreadMain().new StringBufferTest();
		
		Thread td1=new Thread() {
			
			@Override
			public void run() {
				sbt.printBuffer("P");
			}
		};
		
		Thread td2=new Thread() {
			
			@Override
			public void run() {
				sbt.printBuffer("Z");
			}
		};
		td1.start();
		td2.start();
		
	}
	
	
}
