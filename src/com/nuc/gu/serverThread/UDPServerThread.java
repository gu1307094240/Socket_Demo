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
					//�������ݱ������ڽ��ܿͻ��˷��͵�����
//					byte[] data = new byte[1024];//�����ֽ����飬ָ�����ܵ����ݱ��Ĵ�С
//					DatagramPacket packet = new DatagramPacket(data, data.length);
//					//���տͻ��˷��͵�����
//					
//					socket.receive(packet);//�˷����ڽ��ܵ����ݱ�֮ǰ��һֱ����
					//��ȡ����
					String info = new String(packet.getData(),0,packet.getLength());
					System.out.println("���Ƿ��������ͻ���˵��"+info);
					/**
					 * ��ͻ�����Ӧ����
					 */
					//����ͻ��˵ĵ�ַ���˿ںš�����
					InetAddress address = packet.getAddress();
					int port = packet.getPort();
					byte[] data2 = "��ӭ����".getBytes();
					//�������ݱ���������Ӧ��������Ϣ
					DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
					//��Ӧ�ͻ���
					socket.send(packet2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
} 
