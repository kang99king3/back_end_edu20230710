package hk.edu20230807.day11;

public class ChildMain {

	public static void main(String[] args) {
		Parent p=new Child();// 부모의 타입으로 자식을 생성
		p.parentMethod();//자식에서 오버라이딩한 메서드가 호출됨
//		p.childMethod();//(X)설계도에 공개된 메서드만 호출가능
		Child c2=(Child)p;//그냥 대입하면 작은 공간에 큰공간을 저장-->캐스팅
		c2.childMethod();//자식의 메서드를 사용하려면 다시 자식타입으로 형변환해야 함
		
//		Child c=new Child();//자식의 타입으로 자식을 생성
//		c.parentMethod();
//		System.out.println(c);//toString() 오버라이딩해서 자식메서드가 호출
		
		Parent pa=new Parent();//일반적인 객체생성방법[상속관계전혀 상관없음]
		pa.parentMethod();//부모의 메서드가 호출됨
	}

}






