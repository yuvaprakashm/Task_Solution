/*

DAY : 09
ASSIGNMENT NO: 04

Write a program to test socket functionality for appropriate hostname and port number.

*/
package net.texala.main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try (ServerSocket serverSocket = new ServerSocket(8081)) {
			System.out.println("Server: Listening on port 8081...");

			while (true) {
				Socket clientSocket = serverSocket.accept();
				System.out.println("  Client connected");

				try (DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
						DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream())) {

					String message = dis.readUTF();
					System.out.println("Server: Message from client: " + message);

					dos.writeUTF("Hello from server!");
					dos.flush();
					System.out.println("Server: Response sent to client");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
