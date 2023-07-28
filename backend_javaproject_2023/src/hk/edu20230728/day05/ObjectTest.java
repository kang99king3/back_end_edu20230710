package hk.edu20230728.day05;

public class ObjectTest {

	public static void main(String[] args) {
		String obj=new String();
		System.out.println(obj.getClass());
		
		ClassTest ct=new ClassTest();
		System.out.println(ct.getClass());
		
		System.out.println(ct.toString());
		Integer a=10;  
		System.out.println(a.toString());
//		int b=10;  b.toString();
		
		ClassTest ct2=new ClassTest();
		
		System.out.println(ct.hashCode());
		System.out.println(ct2.hashCode());
		
		System.out.println(ct.equals(ct2));
		
		String s="a";
		String ss="a";
		System.out.println(s.equals("a"));
		System.out.println(s==ss);
		
		String sss=new String("a");
		System.out.println(s==sss);//주소로 비교함
		System.out.println(s.equals(sss));//hashcode로 비교함
	}
}
