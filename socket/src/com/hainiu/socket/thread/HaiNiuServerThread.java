package com.hainiu.socket.thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 蒲怀梓
 * 多线程服务器
 * 
 */
public class HaiNiuServerThread {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(12345);
			Socket socket = null;
			int i = 1;
			while (true) {
				System.out.println("服务器开始监听");
				socket = ss.accept();
				System.out.println("服务器监听到了客户端的连接");
				Runnable runn = new ThreadServer(socket);
				new Thread(runn,"客服"+i).start();
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
