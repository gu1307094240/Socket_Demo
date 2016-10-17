package com.nuc.gu.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import com.nuc.gu.serverThread.TCPServerThread;
/**
 * 基于TCP协议的Socket通信，实现用户登录
 * 服务器端
 * @author GU
 *
 */
public class TCPServer {
	
	public static void main(String[] args) {
		try {
			//创建一个服务器端Socket,即ServerSocket,指定绑定的端口并监听
			ServerSocket serverSocket = new ServerSocket(8888);
			Socket socket = null;
			int count = 0;
			System.out.println("****服务器即将启动，等待客户端连接****");
			//循环监听等待客户端的连接
			while(true){
				//调用accept（）方法开始监听，等待客户的连接
				socket = serverSocket.accept();
				//创建一个新的线程
				TCPServerThread serverThread = new TCPServerThread(socket);
				serverThread.start();
				count++;
				System.out.println("客户端的数量="+count);
				InetAddress address = socket.getInetAddress();
				System.out.println("当前客户端的ip地址："+address.getHostAddress());
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
