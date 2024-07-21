package hk.edu20230810.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class D2_UDPClient {
	 public static void main(String[] args) {
		//localhost: 자신의 PC 주소
        String hostname = "localhost";
        int port = 5000;
        // 소켓 객체 생성
        try (DatagramSocket socket = new DatagramSocket()) {
            //주소 얻어오기
        	InetAddress address = InetAddress.getByName(hostname);
            byte[] buffer = new byte[512];
            //키보드로 입력한 데이터를 읽어 BufferedReader객체생성
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String text;
            while (true) {
                System.out.print("Enter text: ");
                text = reader.readLine();//입력된 데이터 한줄씩 읽기
                buffer = text.getBytes();//읽은 데이터를 byte단위 배열로 반환하여 저장
                //데이터가 저장된 배열 buffer, buffer의 길이, 주소, 포트 필요
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);
                socket.send(packet);//데이터 전송하기

                //데이터를 받기 위한 객체 생성
                packet = new DatagramPacket(buffer, buffer.length);
                //데이터 받기
                socket.receive(packet);
                //데이터를 문자열로 변환
                String received = new String(packet.getData(), 0, packet.getLength());
                //변환된 문자열 출력하기
                System.out.println("Received: " + received);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
