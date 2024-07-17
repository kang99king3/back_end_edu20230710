package hk.edu20230810.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class D4_ChatClient {
	 private static final String SERVER_ADDRESS = "localhost";
	    private static final int SERVER_PORT = 12345;

	    public static void main(String[] args) {
	        Socket socket = null;
	        BufferedReader in = null;
	        PrintWriter out = null;
	        BufferedReader stdIn = null;

	        try {
	            socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
	            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	            out = new PrintWriter(socket.getOutputStream(), true);
	            stdIn = new BufferedReader(new InputStreamReader(System.in));

	            new Thread(new IncomingMessagesHandler(in)).start();

	            String userInput;
	            while ((userInput = stdIn.readLine()) != null) {
	                out.println(userInput);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (in != null) in.close();
	                if (out != null) out.close();
	                if (stdIn != null) stdIn.close();
	                if (socket != null && !socket.isClosed()) socket.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    private static class IncomingMessagesHandler implements Runnable {
	        private BufferedReader in;

	        public IncomingMessagesHandler(BufferedReader in) {
	            this.in = in;
	        }

	        @Override
	        public void run() {
	            String serverMessage;
	            try {
	                while ((serverMessage = in.readLine()) != null) {
	                    System.out.println("서버 메시지: " + serverMessage);
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
}
