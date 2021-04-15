package com.xcxcxz.tcptest;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) {
		final int SERVER_PORT=5000;
		
		ServerSocket serverSocket=null;
		
		try {
			
			serverSocket=new ServerSocket();
			
			String localHostAddress=InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(localHostAddress, SERVER_PORT));
			System.out.println("[server] binding! \naddress" + localHostAddress + ",port" + SERVER_PORT);
			
			while(true) {
			Socket socket= serverSocket.accept();
			
			new ProcessThread().start();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(serverSocket !=null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
