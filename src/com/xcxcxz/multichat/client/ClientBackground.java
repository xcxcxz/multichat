package com.xcxcxz.multichat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientBackground {
	
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private ClientGui gui;
	private String msg;
	private String nickName;
	
	public final void setGui(ClientGui gui) {
		this.gui=gui;
	}
	public void connet() {
		try {
			socket = new Socket("192.168.0.59", 7777);
			System.out.println("서버연결완료");
			out= new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			out.writeUTF(nickName);
			System.out.println("클라이언트: 메세지 전송완료");
			while(in != null) {
				msg=in.readUTF();
				gui.appendMsg(msg);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ClientBackground clientBackground = new ClientBackground();
		clientBackground.connet();
	}
	
	public void sendMessage(String msg2) {
		try {
			out.writeUTF(msg2);
		}catch(IOException e) {
		e.printStackTrace();
	}
	}
	public void setNickname(String nickName) {
		this.nickName=nickName;
	}
}
