package hk.edu20230808.day13;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ExceptionTest {

	public static void main(String[] args) {
		exTest("12345");
	}
	
	public static void exTest(String s) {
		int i=0;
		String ss="";
		int [] array= {1,2,3,4,5};
		
		try {
			ss=s.substring(0, 2);
			i=Integer.parseInt(ss);//숫자형태의 문자열을 정수형으로 변환
			int a=array[5];//인덱스 5는 없음
//			System.out.println(ss);
		}catch (StringIndexOutOfBoundsException se) {
			System.out.println("문자열의 길이를 확인하세요"
					+" ["+se+"]");
//			se.printStackTrace();
		}catch(NumberFormatException ne) {
			System.out.println("숫자형식이 아닙니다."+"["+ne+"]");
		}catch(ArrayIndexOutOfBoundsException | NullPointerException ae) {
			System.out.println("배열의 길이를 확인하세요"+"["+ae+"]");
		}catch (Exception e) {
			System.out.println("하위 예외처리 외에 오류를 처리한다.");
			e.printStackTrace();
		}finally {
			System.out.println("예외와 상관없이 반드시 처리해야 할 코드 작성");
		}
	}
	
	public void test01() throws IOException {
		InputStreamReader is=new InputStreamReader(null);
		is.read();//여기서 직접 처리할 상황이면 try코드 작성, 아니면 예외를 던진다.throws작성
	}
	
	public void test02() throws IOException {
		test01();//마지막에는 반드시 예외를 처리해야 한다.(try~catch)
	}
}








