package com.nuc.gu.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import com.nuc.gu.serverThread.UDPServerThread;

/**
 * �������ˣ�ʵ�ֻ���UDP���û���¼
 * @author GU
 *
 */
public class UDPServer {
	public static void main(String[] args) throws IOException {
		/**
		 * ���տͻ��˷��͵���Ϣ
		 */
		//������������DatagramSocket,ָ���˿�
		DatagramSocket socket = new DatagramSocket(8800);
		int count = 0;//��ǰ������
		System.out.println("***���������Ѿ��������ȴ��ͻ��˷�������***");
		while(true){
			//����һ��DatagramPacket�����������տͻ��˴�������Ϣ
			byte[] data = new byte[8*1024];
			DatagramPacket packet = new DatagramPacket(data, data.length);
			socket.receive(packet);		
			count++;
			System.out.println("��ǰ�ͻ��˸���:" + count);
			UDPServerThread thread = new UDPServerThread(socket,packet);
			thread.start();
		}
	}
}
