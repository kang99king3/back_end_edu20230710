package hk.edu20230808.day12;

//추상클래스가 됨 --> 객체생성 못함 --> 하위클래스에서 상속받아서 구현해야 함
public abstract class D2_NoteBook extends D2_Computer{

	//추상 클래스를 상속받을때에는 추상메서드를 반드시 구현해야 함
	@Override
	public void display() {
		System.out.println("NoteBook display()");
	}

	//typing() 기능을 구현하지 못함. 구현할 상황이 아니라면 추상메서드로 선언하면 되지만 현재 클래스도 추상클래스가 됨
	@Override
	public abstract void typing();

}
