package com.nuc.gu.serverThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * �������̴߳�����
 * @author GU
 *
 */
public class TCPServerThread extends Thread{
		//�ͱ��߳���ص�Socket
		Socket socket = null;
		public TCPServerThread(Socket socket){
			this.socket = socket;
		}
		@Override
		public void run() {
			InputStream is = null;
			InputStreamReader isr = null;
			BufferedReader bf = null;
			OutputStream os = null;
			PrintWriter pw = null;
			try {
				//��ȡ������������ȡ�ͻ�����Ϣ
				is = socket.getInputStream();
				isr = new InputStreamReader(is);
				bf = new BufferedReader(isr);
				String info = null;
				while((info = bf.readLine())!=null){//ѭ����ȡ�ͻ�����Ϣ
					System.out.println("���Ƿ��������ͻ���˵��"+info);
				}
				socket.shutdownInput();//�ر�������
				//��ȡ���������ͻ��˷�����Ϣ
				os = socket.getOutputStream();
				pw = new PrintWriter(os);
				pw.write("��ӭ����");
				pw.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				try {
					//�ر���Դ
					if(pw!=null){
						pw.close();
					}
					if(os!=null){
						os.close();
					}
					if(bf!=null){
						bf.close();
					}
					if(isr!=null){
						isr.close();
					}
					if(is!=null){
						is.close();
					}
					if(socket!=null){
						socket.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			
			
		}
}

