package hk.edu20230808.day12;

//추상클래스가 됨 --> 객체생성 못함 --> 하위클래스에서 상속받아서 구현해야 함
public abstract class NoteBook extends Computer{

	@Override
	public void display() {
		System.out.println("NoteBook display()");
	}

	//typing() 기능을 구현하지 못함. 추상메서드로 선언
	@Override
	public abstract void typing();

}
