package hk.edu202308089.day14;

public class Mythread extends Thread{

	public String s;
	public AsynchronizedObj aobj;
	public Mythread() {
		// TODO Auto-generated constructor stub
	}
	
	public Mythread(AsynchronizedObj aobj, String s) {
		this.s=s;
		this.aobj=aobj;
	}
	
	@Override
	public void run() {
		aobj.print(s);
	}
}
