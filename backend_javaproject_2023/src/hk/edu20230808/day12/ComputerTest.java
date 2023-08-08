package hk.edu20230808.day12;

import java.util.Calendar;

public class ComputerTest {

	public static void main(String[] args) {
//		Computer computer=new Computer();//오류발생
//		Calendar cal=new Calendar();//API에서 제공하는 클래스
//					=Calendar.getInstance();
		Computer c1=new DeskTop();
		c1.display();
		c1.typing();
		c1.turnOn();
		c1.turnOff();
		
//		Computer c2=new NoteBook();
		Computer c2=new MyNoteBook();
		c2.display();
		c2.typing();
		c2.turnOn();
		c2.turnOff();
	}

}
