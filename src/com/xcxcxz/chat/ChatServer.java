package com.xcxcxz.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	public static final int PORT=5004;
	
	public static void main(String[] args) {
		ServerSocket serverSocket=null;
		List<PrintWriter>listWriters= new ArrayList<PrintWriter>();
		
		try {
			serverSocket= new ServerSocket();
			
			String hostAddress= InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(hostAddress,PORT));
			consoleLog("연결 대기중 - " + hostAddress +":" + PORT);
			while(true) {
				Socket socket=serverSocket.accept();
				new ChatServerProcessThread(socket, listWriters).run();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void consoleLog(String log) {
		System.out.println("[server" + Thread.currentThread().getId() + "]" + log);
	}
}
