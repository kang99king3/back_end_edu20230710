package hk.edu20230810.day15;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class D2_UDPServer {
	 public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(5000)) {
            byte[] buffer = new byte[512];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            System.out.println("UDPServer is listening on port 5000");
            while (true) {
                socket.receive(packet);
                String received = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received: " + received);
                
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(buffer, buffer.length, address, port);
                socket.send(packet);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
