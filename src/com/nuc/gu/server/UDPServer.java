package com.nuc.gu.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import com.nuc.gu.serverThread.UDPServerThread;

/**
 * 服务器端，实现基于UDP的用户登录
 * @author GU
 *
 */
public class UDPServer {
	public static void main(String[] args) throws IOException {
		/**
		 * 接收客户端发送的信息
		 */
		//创建服务器端DatagramSocket,指定端口
		DatagramSocket socket = new DatagramSocket(8800);
		int count = 0;//当前连接数
		System.out.println("***服务器端已经启动，等待客户端发送数据***");
		while(true){
			//创建一个DatagramPacket对象，用来接收客户端传来的信息
			byte[] data = new byte[8*1024];
			DatagramPacket packet = new DatagramPacket(data, data.length);
			socket.receive(packet);		
			count++;
			System.out.println("当前客户端个数:" + count);
			UDPServerThread thread = new UDPServerThread(socket,packet);
			thread.start();
		}
	}
}
