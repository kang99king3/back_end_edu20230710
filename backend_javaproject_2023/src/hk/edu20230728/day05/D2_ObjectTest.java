package hk.edu20230728.day05;

public class D2_ObjectTest {

	public static void main(String[] args) {
		String obj=new String();
		System.out.println(obj.getClass());
		
		D1_ClassTest ct=new D1_ClassTest();
		System.out.println(ct.getClass());
		
		System.out.println(ct.toString());
		Integer a=10;  
		System.out.println(a.toString());
//		int b=10;  b.toString();
		
		D1_ClassTest ct2=new D1_ClassTest();
		
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
