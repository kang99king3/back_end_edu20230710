package hk.edu20230810.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class T1_TCPServer {

	public static void main(String[] args) {
		T1_TCPServer tcpServer=new T1_TCPServer();
		   try (ServerSocket serverSocket = new ServerSocket(5000)) {
	            System.out.println("Server is listening on port 5000");
	            while (true) {
	                Socket socket = serverSocket.accept();
	                System.out.println("New client connected");
	                tcpServer.new ServerThread(socket).start();
	            }
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	}
	
	class ServerThread extends Thread {
	    private Socket socket;
	    public ServerThread(Socket socket) {
	        this.socket = socket;
	    }
	    public void run() {
	        try (InputStream input = socket.getInputStream();
	             BufferedReader reader = new BufferedReader(new InputStreamReader(input));
	             OutputStream output = socket.getOutputStream();
	             PrintWriter writer = new PrintWriter(output, true)) {

	            String text;
	            while ((text = reader.readLine()) != null) {
	                System.out.println("Received: " + text);
	                writer.println("Echo: " + text);
	            }
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }finally {
				
			}
	    }
	}

}
