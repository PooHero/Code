package com.hainiu.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author 蒲怀梓
 * 客户端实现
 * Socket类实现
 *
 */
public class HaiNiuClient2 {
	public static void main(String[] args) {
		// 该方法指定一个IP，指定一个端口号，当对象创建好之后，就会自动连接
		try {
			// 对象创建之后，就会立即进行对服务器的连接
			Socket socket = new Socket("192.168.1.107", 12345);
			InputStream inputStream = socket.getInputStream();
			DataInputStream dis = new DataInputStream(inputStream);
			String read = dis.readUTF();
			System.out.println("客户端接收到的信息如下：");
			System.out.println(read);
			
			// 写出
			OutputStream outputStream = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(outputStream);
			dos.writeUTF("服务器你好，我是IPv4用户，很高兴认识你！");
			
			System.out.println("客户端结束了");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("服务器异常，请等待···");
		}
	}
}
