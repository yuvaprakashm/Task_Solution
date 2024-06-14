/*

Day :06
ASSIGNMENT NO: 10

Write a Java program that share bank account by using synchronization, object locks
and also use wait and notify method. In addition, perform the following operation.
If withdraw amount is below 1000, than cannot withdraw the amount, in such a case
thread will request to deposit.
If deposit balance is greater than withdraw balance, then user can withdraw.
Hint:
class Account{
boolean flag; /set initial boolean true
//create two methods
depositAmount();
withdrawAmount();
}

*/

package net.texala.main;

class Account {
	private int balance = 1000;
	private boolean flag = true;

	public synchronized void depositAmount(int amount) {
		while (flag == false) {
			try {

				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		balance = balance + amount;// it update balance by adding the deposit amount
		System.out.println(Thread.currentThread().getName() + " deposited: " + amount); // 500
		System.out.println("\nBalance after deposit: " + balance);

		flag = false;
		notify();
	}

	public synchronized void withdrawAmount(int amount) {
		while (flag || balance < amount) {
			try {

				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		balance = balance - amount; // it update balance by subtracting the amount
		System.out.println(Thread.currentThread().getName() + " withdrew: " + amount); // 300
		System.out.println("\nBalance after withdrawal: " + balance);

		flag = true;
		notify();
	}
}
