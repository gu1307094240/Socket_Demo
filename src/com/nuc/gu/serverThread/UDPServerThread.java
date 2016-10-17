package com.nuc.gu.serverThread;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServerThread extends Thread{
	DatagramSocket socket = null;
	DatagramPacket packet = null;
	public UDPServerThread(DatagramSocket socket,DatagramPacket packet){
		this.socket = socket;
		this.packet = packet;
	}
	@Override
	public void run() {
		try {
					//创建数据报，用于接受客户端发送的数据
//					byte[] data = new byte[1024];//创建字节数组，指定接受的数据报的大小
//					DatagramPacket packet = new DatagramPacket(data, data.length);
//					//接收客户端发送的数据
//					
//					socket.receive(packet);//此方法在接受到数据报之前会一直阻塞
					//读取数据
					String info = new String(packet.getData(),0,packet.getLength());
					System.out.println("我是服务器，客户端说："+info);
					/**
					 * 向客户端响应数据
					 */
					//定义客户端的地址、端口号、数据
					InetAddress address = packet.getAddress();
					int port = packet.getPort();
					byte[] data2 = "欢迎您！".getBytes();
					//创建数据报，包含响应的数据信息
					DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
					//响应客户端
					socket.send(packet2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
} 
