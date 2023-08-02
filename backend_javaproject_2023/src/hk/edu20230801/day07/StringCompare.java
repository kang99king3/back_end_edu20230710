package hk.edu20230801.day07;

public class StringCompare {

	public static void main(String[] args) {
		//리터럴과 리터럴 비교
		String s1="java";
		String s2="java";
		System.out.println(s1==s2);//주소가 같기 때문에 T
		System.out.println(s1.equals(s2));//hashcode가 같기 때문에 T
		
		//객체와 객체 비교
		String obj1=new String("java");
		String obj2=new String("java");
		System.out.println(obj1==obj2);
		System.out.println(obj1.equals(obj2));
		
		//객체와 리터럴 비교
		String s3="java";
		String obj3=new String("java");
		System.out.println(s3==obj3);
		System.out.println(s3.equals(obj3));
		
		//특징:String객체는 값을 변경하면 메모리에 새롭게 생성한다. 
		String ss="java";
			   ss="javaEdu";//메모리에서 값이 변경된게 아니라 새로 생성됨
			   ss=ss+"교육";
			   ss=ss+"과정";
		
		//주소를 통해서 값을 변경한다.--> 변경에 대해서 메모리 효율이 높다	   
		StringBuffer sb=new StringBuffer("가");
		sb.append("나");
		sb.append("다");//"가나다"
		System.out.println(sb.toString());

		
	}
}















