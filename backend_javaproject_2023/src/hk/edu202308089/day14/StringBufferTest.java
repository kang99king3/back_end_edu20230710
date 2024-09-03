package hk.edu202308089.day14;

public class StringBufferTest {
//	 private StringBuffer buffer = new StringBuffer();
	 private StringBuilder buffer = new StringBuilder();
	    public void appendToBuffer(String text) {
	        buffer.append(text);
	        System.out.println("Appended: " + text + ", Buffer: " + buffer.toString());
	    }

	    public static void main(String[] args) {
	    	StringBufferTest example = new StringBufferTest();

	        // Thread 1
	        Thread thread1 = new Thread(new Runnable() {
	            @Override
	            public void run() {
	                for (int i = 0; i < 5; i++) {
	                    example.appendToBuffer("Thread1-" + i + " ");
	                }
	            }
	        });

	        // Thread 2
	        Thread thread2 = new Thread(new Runnable() {
	            @Override
	            public void run() {
	                for (int i = 0; i < 5; i++) {
	                    example.appendToBuffer("Thread2-" + i + " ");
	                }
	            }
	        });

	        thread1.start();
	        thread2.start();
	    }
}
