package com.hainiu.socket;
/**
 * @author 蒲怀梓
 * Socket套接字学习
 * 通过Java类分别实现服务器和客户端
 * Socket 客户端
 * ServerSocket 服务器
 * 1.两者要建立连接
 *   1.1 先建立服务器
 *   	网络上有多个计算机，如何确定是哪一个计算机？
 *   		通过IP地址
 *   	一个计算机上有多个应用程序，该如何区分？
 *   		通过端口（端口是一个虚拟化的东西，用数字表示0~65535个端口）
 *   		1000以下的是一些系统服务，应使用1000以上的，直接使用10000以上的
 *   		例如：MySQL 3306
 *   			tomcat 8080
 *   1.2 服务器开启监听
 *   1.3 创建客户端进行连接，客户端会自动去连接
 *   
 * 2.两者通过流的方式进行数据传输
 * 
 */
public class HaiNiuSocket {
	public static void main(String[] args) {
		/**
		 * 实现通信，双方必须进行协同操作
		 * 一方写，一方读
		 */
	}
}
