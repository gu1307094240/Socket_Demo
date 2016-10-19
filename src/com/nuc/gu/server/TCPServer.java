package com.nuc.gu.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import com.nuc.gu.serverThread.TCPServerThread;
/**
 * ����TCPЭ���Socketͨ�ţ�ʵ���û���¼
 * ��������
 * @author GU
 *
 */
public class TCPServer {
	
	public static void main(String[] args) {
		try {
			//����һ����������Socket,��ServerSocket,ָ���󶨵Ķ˿ڲ�����
			ServerSocket serverSocket = new ServerSocket(8888);
			Socket socket = null;
			int count = 0;
			System.out.println("****�����������������ȴ��ͻ�������****");
			//ѭ�������ȴ��ͻ��˵�����
			while(true){
				//����accept����������ʼ�������ȴ��ͻ�������
				socket = serverSocket.accept();
				//����һ���µ��߳�
				TCPServerThread serverThread = new TCPServerThread(socket);
				serverThread.start();
				count++;
				System.out.println("�ͻ��˵�����="+count);
				InetAddress address = socket.getInetAddress();
				System.out.println("��ǰ�ͻ��˵�ip��ַ��"+address.getHostAddress());
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
