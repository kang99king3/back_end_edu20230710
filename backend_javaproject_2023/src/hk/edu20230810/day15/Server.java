package hk.edu20230810.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	public static void main(String[] args) {
		try {
			//서버 소켓 생성
			ServerSocket serverSocket=new ServerSocket(9595);
			System.out.println("Server is running...");
			
			while(true) {
				//클라이언트로부터 요청을 승인(연결 확인)후 클라이언트 소켓 얻어옴---> TCP 방식
				Socket clientSocket = serverSocket.accept();
				//클라이언트 호스트 이름 출력
				System.out.println("New client connected: "+ clientSocket.getInetAddress().getHostName());
				//클라이언트 소켓으로 보낼 outputstream객체 생성
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
				//클라이언트 소켓으로부터 inputstream객체 생성
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				
				String inputLine;
				//클라이언트 소켓으로부터 전달되는 데이터 읽어들이기
				while((inputLine = in.readLine())!=null) {
					//클라이언트로 부터 전달된 메시지 출력하기 
					System.out.println("Message from client:"+inputLine);
					//클라이언트 소켓으로부터 전달된 데이터를 다시 보내기
					out.println("You said: "+inputLine);
				}
				in.close();
				out.close();
				clientSocket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
