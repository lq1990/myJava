package com.wendao.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 	目标：
 * 	01 使用ServerSocket与client即browser连接，获取请求协议。
 * 	02 返回响应协议
 * 	03 封装响应信息
 * 		内容可以动态添加
 * 		只关注状态码
 * 
 * 
 * @author china
 *
 */
public class Server03 {
	private ServerSocket serverSocket;
	
	public static void main(String[] args) {
		Server03 server = new Server03();
		server.start();
	}
	
	// 启动服务
	public void start() {
		try {
			this.serverSocket = new ServerSocket(8888);
			System.out.println("server is running...");
			
			this.receive(); // receive clients after starting
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("服务器启动失败");
		}
	}
	
	// 接受连接处理
	public void receive() {
		try {
			Socket client = this.serverSocket.accept();
			System.out.println("一个client建立了连接");
			
			// ========= 获取请求协议 =========
			InputStream is = client.getInputStream();
			// 在实际业务中，往往一行行读取或一个个字节读取。此处方便起见，一次性读
			byte[] datas = new byte[1024*1024]; // 1 MB，使用字节数组 接收
			int len = is.read(datas);
			
			// get reqInfo and print
			if (len>0) {
				String reqInfo = new String(datas, 0, len);
				System.out.println(reqInfo);
			} else {
				System.out.println("reqInfo is null");
			}
			
			// =============== 返回 res ===============
			Response res = new Response(client);
			
			StringBuilder content = new StringBuilder();
			content.append("<!DOCTYPE html>"
					+ "<html>"
					+ "<head>"
					+ 	"<title>来自服务器的消息</title>"
					+ "</head>"
					+ "<body>"
					+ 	"<h3>你好啊，欢迎来到我的世界！</h3>"
					+ "</body>"
					+ "</html>");
			// 关注了内容
			res.println(content.toString());
			// 关注了状态码
			res.pushToBrowser(200);
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("客户端错误");
		}
		
	}
	
	// 启动服务
	public void stop() {

	}
}
