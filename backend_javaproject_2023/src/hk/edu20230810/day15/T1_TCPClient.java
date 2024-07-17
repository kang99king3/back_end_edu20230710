package hk.edu20230810.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class T1_TCPClient {
	public static void main(String[] args) {
        String hostname = "localhost";
        int port = 5000;

        try (Socket socket = new Socket(hostname, port)) {
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String text;
            while (true) {
                System.out.print("Enter text: ");
                text = reader.readLine();
                writer.println(text);
                InputStream input = socket.getInputStream();
                BufferedReader responseReader = new BufferedReader(new InputStreamReader(input));
                String response = responseReader.readLine();
                System.out.println(response);
            }
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
	}


}
