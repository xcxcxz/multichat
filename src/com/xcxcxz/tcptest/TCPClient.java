package com.xcxcxz.tcptest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TCPClient {
	private static final String SERVER_IP="192.168.0.59";
	private static final int SERVER_PORT=5000;
	
	public static void main(String[] args) {
		Socket socket=null;
		
		try {
			socket=new Socket();
			
			socket.connect(new InetSocketAddress(SERVER_IP,SERVER_PORT));
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(socket!=null&& !socket.isClosed()) {
					socket.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	

}
