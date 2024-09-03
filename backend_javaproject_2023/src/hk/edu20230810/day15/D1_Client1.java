package hk.edu20230810.day15;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class D1_Client1 {

	public static void main(String[] args) {
		Socket socket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		BufferedReader userInput = null;
		try {
			//소켓 객체 생성
			socket=new Socket("localhost",9595);
			System.out.println("Client:Connection to server....");
			//소켓으로 출력할 객체 생성
			out = new PrintWriter(socket.getOutputStream(),true);
			//소켓으로 전달된 메시지를 읽어들일 객체 생성
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//키보드로 입력되는 메시지를 읽어들일 객체 생성
			userInput = new BufferedReader(new InputStreamReader(System.in));
			
			String inputLine;
			//키보드로 부터 입력된 메시지 읽어들이기
			while((inputLine = userInput.readLine())!=null) {// <-- readLine()실행되면 키보드로 입력대기-->inputLine으로 읽은 값 저장
				//키보드로 부터 읽어들인 메시지를 소켓으로 출력하기(내보내기)
				out.println(inputLine);
				//소켓으로 전달된 메시지 읽고 출력하기
				System.out.println(in.readLine());
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(out!=null) {
					out.close();
				}
				if(in!=null) {
					in.close();			
				}
				if(userInput!=null) {
					userInput.close();
				}
				if(socket!=null) {
					socket.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}





