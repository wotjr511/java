package net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 최초작성자 : 박재석
 * 최초작성일 : 2021-02-25
 * 최종변경일 : 2021-02-25
 * 목적 : MyServer 최초 작성
 */

public class MyServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost", 5000));
			while (true) {
				Socket socket = serverSocket.accept();
				InetSocketAddress address = (InetSocketAddress)socket.getRemoteSocketAddress();
				System.out.println("MyServer가 연결되었습니다");
			}
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			// isSocket을 닫아야 합니다.
			try {
				if(serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
