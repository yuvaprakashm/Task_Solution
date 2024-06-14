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

public class bank {
	public static void main(String[] args) {
		Account account = new Account();

		Thread depositThread = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				account.depositAmount(500);
			}
		}, "DepositThread");

		Thread withdrawThread = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				account.withdrawAmount(500);
			}
		}, "WithdrawThread");

		depositThread.start();
		withdrawThread.start();
	}
}
