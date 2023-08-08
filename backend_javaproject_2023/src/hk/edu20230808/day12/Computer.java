package hk.edu20230808.day12;

public abstract class Computer {

	//추상메서드: body{ } 없음 --->  미완성 메서드
	public abstract void display();
	public abstract void typing();
	
	public void turnOn() {
		System.out.println("전원을 켭니다.");
	}
	
	public void turnOff() {
		System.out.println("전원을 끕니다.");
	}
}
