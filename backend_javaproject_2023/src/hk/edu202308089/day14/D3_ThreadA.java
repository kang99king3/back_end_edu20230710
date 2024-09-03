package hk.edu202308089.day14;

import javax.swing.plaf.synth.SynthColorChooserUI;

public class D3_ThreadA {

	//내부 클래스
	class ShareObject{
		
		public synchronized void print(String title) {
			for (int i = 0; i < 10; i++) {
				System.out.println(title);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		//공유 객체: A,B 스레드가 공유하는 객체 
		ShareObject so = new D3_ThreadA().new ShareObject();
		
		//A와 B 스레드가 동시성으로 접근한다.
		//A가 공유객체에 접근하여 작업하는 동안 B도 접근하게 되면 잘못된 결과를 얻을 수 있다. 
		//동기화 설정을 통해 A의 작업이 종료될 때까지 B는 접근하지 못한다.
		//설정방법: synchronized 메서드 , 동기화 블록 synchronized(공유객체){ } 
//		Thread trA=new Thread() {
//			@Override
//			public void run() {
//				so.print("공");
//			}
//		};
//		
//		Thread trB=new Thread() {
//			@Override
//			public void run() {
//				so.print("유");
//			}
//		};
//		trA.start();
//		trB.start();
		
		
		//StringBuffer vs StringBuilder
	    D3_ThreadA d3=new D3_ThreadA();
	    
		Thread trC=new Thread() {
			@Override
			public void run() {
				d3.sbTest("건");					
			}
		};
		
		Thread trD=new Thread() {
			@Override
			public void run() {
				d3.sbTest("양");					
			}
		};
		
		trC.start(); trD.start();
	}
	
	//멀티스레드 환경에서 동기화를 제공하지 않아 불안정하다: 문자열이 깨져서 저장될 수 도 있다.
	//synchronized 처리하면 동기화 적용할 수 있다.
	public static StringBuilder sb=new StringBuilder();
//	public static StringBuffer sb=new StringBuffer();
	//멀티스레드 환경에서 동기화를 제공하여 안정적이다
//	public static StringBuffer sb=new StringBuffer();
	
	public void sbTest(String s) {
		
		synchronized (sb) {
			sb.append(s);
			System.out.println(sb.toString());
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
}
