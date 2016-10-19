package com.nuc.gu.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �ͻ���
 * @author GU
 *
 */
public class TCPClient {

	public static void main(String[] args) {
		//1.�����ͻ���Socket,ָ����������ַ�Ͷ˿�
		try {
			Socket socket = new Socket("127.0.0.1", 8888);
			//2.��ȡ���������������˷�����Ϣ
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.write("�û�����gulingfeng;���룺456");
			pw.flush();
			socket.shutdownOutput();//�ر������
			//3.��ȡ����������÷�������Ӧ��Ϣ
			InputStream is = socket.getInputStream();
			BufferedReader bf = new BufferedReader(new InputStreamReader(is));
			String info = null;
			while((info = bf.readLine())!=null){
				System.out.println("���ǿͻ��ˣ���������˵��"+info);
			}
			//3.�ر���Դ
			bf.close();
			is.close();
			pw.close();
			os.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
