package hk.edu202308089.day14;

public class AsynchronizedObj {

	public synchronized void print(String s) {
		for (int i = 0; i <10; i++) {
			System.out.print(s);
		}
		System.out.println();
	}
}
