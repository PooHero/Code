package com.hainiu.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 蒲怀梓
 * 实现服务器
 * 
 */
public class HaiNiuServer {
	public static void main(String[] args) throws InterruptedException {
		// 创建绑定到特定端口的服务器套接字
		try {
			ServerSocket ss = new ServerSocket(12345);
			while (true) {
				System.out.println("服务器开始监听");
				// 侦听并接受到此套接字的连接（此方法是阻塞方法，如果有人连接那么就会进行下一步；反之没有客服端连接，就会一直阻塞）
				Socket socket = ss.accept();// 服务器的监听方法
				InetAddress address = socket.getInetAddress();// 返回套接字连接的地址
				System.out.println("服务器监测到了连接······" + address);
				// 得到一个写向客户端的输出流
				OutputStream outputStream = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(outputStream);
				
				String str = address + "~~~欢迎您登录到服务器！";
				dos.writeUTF(str);
				System.out.println("服务器完成了输出");
				
				// 读入
				InputStream inputStream = socket.getInputStream();
				DataInputStream dis = new DataInputStream(inputStream);
				String read = dis.readUTF();
				System.out.println("服务器接收到的信息如下：");
				System.out.println(read);
				
				Thread.sleep(200000);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
