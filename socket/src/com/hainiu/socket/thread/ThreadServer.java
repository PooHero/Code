package com.hainiu.socket.thread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ThreadServer implements Runnable {
	Socket socket;
	public ThreadServer() {
		// TODO Auto-generated constructor stub
	}
	public ThreadServer(Socket socket) {
		super();
		this.socket = socket;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " 欢迎 " + socket.getInetAddress() + " 访问服务器");
		try {
			OutputStream outputStream = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(outputStream);
			dos.writeUTF("欢迎 " + socket.getInetAddress() + " 访问服务器！我是" + Thread.currentThread().getName());
			System.out.println("向客户端发送信息成功");
			
			InputStream inputStream = socket.getInputStream();
			DataInputStream dis = new DataInputStream(inputStream);
			String read = dis.readUTF();
			System.out.println("服务器接受到的信息如下：");
			System.out.println(read);
			
			Thread.sleep(15000);
			
			System.out.println(Thread.currentThread().getName() + " 完成了对 " + socket.getInetAddress() + " 的服务");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
