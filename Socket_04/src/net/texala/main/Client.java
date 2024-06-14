package net.texala.main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		try {
			Socket clientSocket = new Socket("localhost", 8081);
			System.out.println("Connected to server on port 8081");

			DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
			DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());

			dos.writeUTF("Hello from client!");
			dos.flush();
			System.out.println("Message sent to server");

			String response = dis.readUTF();
			System.out.println("Response: " + response);

			dis.close();
			dos.close();
			clientSocket.close();
			System.out.println("Client: All connections closed");
		} catch (java.net.ConnectException e) {
			System.err.println("Connection refused. Ensure that the server is running.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
