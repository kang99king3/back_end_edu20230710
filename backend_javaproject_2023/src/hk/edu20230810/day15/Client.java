package hk.edu20230810.day15;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		try {
			//소켓 객체 생성
			Socket socket=new Socket("localhost",9595);
			System.out.println("Connection to server....");
			//소켓으로 출력할 객체 생성
			PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
			//소켓으로 전달된 메시지를 읽어들일 객체 생성
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//키보드로 입력되는 메시지를 읽어들일 객체 생성
			BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
			
			String inputLine;
			//키보드로 부터 입력된 메시지 읽어들이기
			while((inputLine = userInput.readLine())!=null) {
				//키보드로 부터 읽어들인 메시지를 소켓으로 출력하기(내보내기)
				out.println(inputLine);
				//소켓으로 전달된 메시지 읽고 출력하기
				System.out.println(in.readLine());
			}
			out.close();
			in.close();
			userInput.close();
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}





