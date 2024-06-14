/*

DAY : 09
ASSIGNMENT NO : 05

Write a program for client and server chatting if client requests server for arithmetic
operation like add, subtract, and multiplication then server perform all the above
mentioned operations.
If client sends Stop then connection will be reset. Do not show any other exception.

*/
package net.texala.main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws IOException {
		InetAddress ip = InetAddress.getLocalHost();
		int port = 5555;
		Scanner sc = new Scanner(System.in);
		 
		 
		Socket s = new Socket(ip, port); // socket connection.

		DataInputStream dis = new DataInputStream(s.getInputStream()); // Communication-get input stream
		DataOutputStream dos = new DataOutputStream(s.getOutputStream()); // Communication-get output stream

		 while (true) {

			System.out.print("Enter the equation in the form: ");
			System.out.println("'operand operator operand'");

			String inp = sc.nextLine();
			
			if(inp.equals("bye"))
				break;

			dos.writeUTF(inp); // send the equation to server

			String ans = dis.readUTF();
			
			System.out.println("Answer=" + ans);
			 
	 	}
	} 
}