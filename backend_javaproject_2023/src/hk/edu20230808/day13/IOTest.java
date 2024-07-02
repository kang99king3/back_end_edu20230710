package hk.edu20230808.day13;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class IOTest {

	public static void main(String[] args) {
//		test01();
//		test02();
//		test03();
		test04();
	}
	
	//파일을 읽고 출력하기
	public static void test01() {
		InputStream in=null;//입력을 위한 파이프 설계도 준비
		OutputStream out=null;//출력을 위한 파이프 설계도 준비
		
//		File file=new File("경로");
		try {
			in=new FileInputStream("d:\\LibraryTest.java");
			out=new FileOutputStream("d:\\LibraryTest.txt");
			
			int i=0;//byte단위로 읽어서 저장한다.
			while((i=in.read())!=-1) {//read()의 결과값은 실제 값을 리턴
				System.out.print((char)i);
				out.write(i);//파일로 출력			
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException ee) {
			ee.printStackTrace();
		}catch(Exception eee) {
			eee.printStackTrace();
		}finally {
			try {
				out.close();//마지막에 실행된 것부터 닫아준다.
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}//test01

	//filter : 보조스트림을 이용해서 출력하기
	public static void test02() {
		OutputStream out=null;//출력을 위한 파이프 준비
		DataOutputStream ds=null;//보조 스트림(filter), 단독으로 사용못함
		
		String s="파일을 기록합니다.";
		try {
			out=new FileOutputStream("d:\\outdata.txt");
			ds=new DataOutputStream(out);//보조스트림 사용
			ds.writeUTF(s);//UTF-8형식으로 인코딩된 문자열을 출력해 준다.
			               //문자열을 자동으로 byte로 나눠서 처리
			
			//보조스트림 미사용시
//			byte [] b=s.getBytes();//문자열을 byte단위로 변환하여 배열로 반환
//			out.write(b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ds.close();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//한번 읽을 때 크기를 설정해서 읽고 쓰기
	public static void test03() {
		InputStream in=null;
		OutputStream out=null;
		
		try {
			in=new FileInputStream("d:\\iotest\\iotestimg.png");
			out=new FileOutputStream("d:\\iotest\\iotestimg_copy.png");
			
			//10byte단위로 읽기
			byte [] b=new byte[10];
			int i=0;//읽어들인 개수가 저장
			while((i=in.read(b))!=-1) {
//				out.write(b); //          //[1,2,3,4,5,6,7,8,9,10]
				//읽어들인 개수만큼만 출력하는 기능
				out.write(b, 0, i);       //[11,12,13,4,5,6,7,8,9,10]
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				out.close();
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//Reader와 Writer를 이용해서 키보드로 입력 및 출력하기
	public static void test04() {
		InputStreamReader in=null;
		OutputStreamWriter out=null;
		System.out.println("입력하세요");
		
		try {
			in=new InputStreamReader(System.in);
			out=new OutputStreamWriter(System.out);
			
			char[] ch=new char[512];
			int i=0;
			while((i=in.read(ch))!=-1) {
				out.write(ch, 0, i);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				out.close();
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}




















