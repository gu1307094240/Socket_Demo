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
 * 客户端
 * @author GU
 *
 */
public class TCPClient {

	public static void main(String[] args) {
		//1.创建客户端Socket,指定服务器地址和端口
		try {
			Socket socket = new Socket("127.0.0.1", 8888);
			//2.获取输出流，向服务器端发送信息
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.write("用户名：gulingfeng;密码：456");
			pw.flush();
			socket.shutdownOutput();//关闭输出流
			//3.获取输入流，获得服务器响应信息
			InputStream is = socket.getInputStream();
			BufferedReader bf = new BufferedReader(new InputStreamReader(is));
			String info = null;
			while((info = bf.readLine())!=null){
				System.out.println("我是客户端，服务器端说："+info);
			}
			//3.关闭资源
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
