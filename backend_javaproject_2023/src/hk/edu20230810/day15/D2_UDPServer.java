package hk.edu20230810.day15;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class D2_UDPServer {
	 public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(5000)) {
            byte[] buffer = new byte[512];
            //수신용 패킷을 생성한다.
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            System.out.println("UDPServer is listening on port 5000");
            while (true) {
            	//데이터를 받는다.
                socket.receive(packet);
                //받은 데이터를 문자열로 변환한다.
                String received = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received: " + received);
                //받은 패킷으로 부터 주소를 얻어온다.
                InetAddress address = packet.getAddress();
                int port = packet.getPort();//포트를 얻는다
                //전송용 패킷을 생성한다.: 전송할때 보낼 데이터가 저장된 배열객체, 배열길이, 주소, 포트 정보 필요
                packet = new DatagramPacket(buffer, buffer.length, address, port);
                socket.send(packet);//데이터 보내기
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
