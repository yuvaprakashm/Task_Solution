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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class ArithmeticServer {
	public static void main(String args[]) throws IOException {

		ServerSocket ss = new ServerSocket(5555); // socket connection.
		Socket s = ss.accept();

		DataInputStream dis = new DataInputStream(s.getInputStream()); // Communication-get input stream
		DataOutputStream dos = new DataOutputStream(s.getOutputStream()); // Communication-get output stream

		while (true) {

			String input = dis.readUTF();

			if (input.equals("bye"))
				break;

			System.out.println("Equation received:-" + input);
			int result;

			StringTokenizer st = new StringTokenizer(input); // Use StringTokenizer to break the equation into operand
																// and operation

			int oprnd1 = Integer.parseInt(st.nextToken());
			String operation = st.nextToken();
			int oprnd2 = Integer.parseInt(st.nextToken());

			if (operation.equals("+")) {
				result = oprnd1 + oprnd2;
			}

			else if (operation.equals("-")) {
				result = oprnd1 - oprnd2;
			} else if (operation.equals("*")) {
				result = oprnd1 * oprnd2;
			} else {
				result = oprnd1 / oprnd2;
			}
			System.out.println("Sending the result...");

			dos.writeUTF(Integer.toString(result)); // send the result back to the client.
		}
	}
}