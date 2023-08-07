package hk.edu20230807.day11;

public class ChildMain {

	public static void main(String[] args) {
//		Parent p=new Child();// 부모의 타입으로 자식을 생성
		
		Child c=new Child();//자식의 타입으로 자식을 생성
		c.parentMethod();
		System.out.println(c);//toString() 오버라이딩해서 자식메서드가 호출
	}

}
