package hk.edu20230810.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class D4_ChatServer {
	 private static final int PORT = 12345;
	    private static Set<PrintWriter> clientWriters = new HashSet<>();

	    public static void main(String[] args) {
	        System.out.println("채팅 서버가 시작되었습니다...");
	        ServerSocket serverSocket = null;

	        try {
	            serverSocket = new ServerSocket(PORT);

	            while (true) {
	                Socket clientSocket = serverSocket.accept();
	                new ClientHandler(clientSocket).start();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (serverSocket != null && !serverSocket.isClosed()) {
	                try {
	                    serverSocket.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }

	    private static class ClientHandler extends Thread {
	        private Socket socket;
	        private PrintWriter out;
	        private BufferedReader in;

	        public ClientHandler(Socket socket) {
	            this.socket = socket;
	        }

	        @Override
	        public void run() {
	            try {
	                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	                out = new PrintWriter(socket.getOutputStream(), true);

	                synchronized (clientWriters) {
	                    clientWriters.add(out);
	                }

	                String message;
	                while ((message = in.readLine()) != null) {
	                    System.out.println("받은 메시지: " + message);
	                    synchronized (clientWriters) {
	                        for (PrintWriter writer : clientWriters) {
	                            writer.println(message);
	                        }
	                    }
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            } finally {
	                if (out != null) {
	                    synchronized (clientWriters) {
	                        clientWriters.remove(out);
	                    }
	                }
	                if (socket != null && !socket.isClosed()) {
	                    try {
	                        socket.close();
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	        }
	    }
}
