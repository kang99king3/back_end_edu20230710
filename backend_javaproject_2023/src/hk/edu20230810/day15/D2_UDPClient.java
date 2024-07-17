package hk.edu20230810.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class D2_UDPClient {
	 public static void main(String[] args) {
        String hostname = "localhost";
        int port = 5000;

        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress address = InetAddress.getByName(hostname);
            byte[] buffer = new byte[512];

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String text;
            while (true) {
                System.out.print("Enter text: ");
                text = reader.readLine();
                buffer = text.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);
                socket.send(packet);

                packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String received = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received: " + received);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
