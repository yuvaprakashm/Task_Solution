/*
DAY:09
ASSIGNMENT NO :01
 
Write a Java program to find the numeric address of the following web sites.
·www.ignou.ac.in
·www.indiatimes.com
·www.rediff.com
·www.apple.com
In addition to this, find the Internet Address of your local host.
Hint: InetAddress address = InetAddress.getByName
("www.google.com");

*/
package net.texala.main;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class IPAddressFinder {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char userinput;
		do {
			System.out.print("Enter the first website URL (e.g., www.ignou.ac.in): ");
			String website1 = scanner.nextLine();
			findNumericAddress(website1);

			findLocalHostAddress();
			System.out.println("Do you want to execute again (y/n) ? :");
			userinput = scanner.next().charAt(0);
			scanner.nextLine();
		} while (userinput == 'Y' || userinput == 'y');
		scanner.close();
	}

	private static void findNumericAddress(String hostName) {
		try {
			InetAddress address = InetAddress.getByName(hostName);
			System.out.println("Numeric Address for " + hostName + ": " + address.getHostAddress());
		} catch (UnknownHostException e) {
			System.out.println("Unable to find address for " + hostName);
		}
	}

	private static void findLocalHostAddress() {
		try {
			InetAddress localHost = InetAddress.getLocalHost();
			System.out.println("Local Host Address: " + localHost.getHostAddress());
		} catch (UnknownHostException e) {
			System.err.println("Unable to find local host address");
		}
	}
}
