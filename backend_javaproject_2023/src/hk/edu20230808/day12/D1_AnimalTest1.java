package hk.edu20230808.day12;

public class D1_AnimalTest1{
	
	public static void main(String[] args) {
		D1_AnimalTest1 aTest=new D1_AnimalTest1();
//		aTest.moveAnimal(new Human());
		//1.부모의 타입으로 자식을 생성한다.
		D1_Animal animal1=new D1_Human();
		D1_Animal animal2=new D1_Tiger();
		D1_Animal animal3=new D1_Eagle();
		
		//2.부모의 타입으로 자식을 참조한다.
//		Tiger ti=new Tiger();
//		aTest.moveAnimal(ti);
		
		aTest.moveAnimal(animal1);
		aTest.moveAnimal(animal2);
		aTest.moveAnimal(animal3);
	}
	
	public void moveAnimal(D1_Animal animal) { // Animal animal=new Animal();
		//부모의 메서드를 호출하면 자식의 메서드가 호출된다.
		animal.move();                      //        animal.move();  
		
		D1_Human human=(D1_Human)animal;//오버라이딩 안하면 다운캐스팅해서 사용해야 함
		human.move2();
//		
//		Tiger tiger=(Tiger)animal;
//		tiger.move2();
		
		
	}
	
	//다형성을 사용하지 않는다면?
	public void moveAnimal(D1_Human human) {
		human.move();
	}
	
	public void moveAnimal(D1_Tiger tiger) {
		tiger.move();
	}

	public void moveAnimal(D1_Eagle eagle) {
		eagle.move();
	}
	
	
}








