package hk.edu20230808.day12;

public class DeskTop extends Computer{

	public DeskTop() {
		super();
	}
	
	@Override
	public void display() {
		System.out.println("DeskTop display()");
	}

	@Override
	public void typing() {
		System.out.println("DeskTop typing()");
	}

	
	
}
