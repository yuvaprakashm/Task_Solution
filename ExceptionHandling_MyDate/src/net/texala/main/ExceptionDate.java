/*
 
DAY : 06
ASSIGNMENT NO : 2

Define a class MyDate with members as day, month, and year. Also, define default
and parameterized constructors. Accept values from the command line and create a
date object. Throw user defined exceptions – InvalidDayException or
InvalidMonthException if the day and month are invalid. If the date is valid, then
display message Valid date.

*/
package net.texala.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class InvalidDateException extends Exception {
	public InvalidDateException(String message) {
		super(message);
	}
}

class InvalidDayException extends InvalidDateException {
	public InvalidDayException(String message) {
		super(message);
	}
}

class InvalidMonthException extends InvalidDateException {
	public InvalidMonthException(String message) {
		super(message);
	}
}

class MyDate {
	int day, mon, yr;

	void accept(int d, int m, int y) {
		day = d;
		mon = m;
		yr = y;
	}

	void display() {
		System.out.println("Date is valid: " + day + "/" + mon + "/" + yr);
	}
}

public class ExceptionDate {
	public static void main(String arg[]) throws Exception {
		char userinput = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do {
			System.out.println("Enter Date in the format dd/mm/yyyy or dd-mm-yyyy :");
			try {
				String inputDate = br.readLine();

				Pattern pattern = Pattern.compile("(\\d{1,2})[-/](\\d{1,2})[-/](\\d{4})");
				Matcher matcher = pattern.matcher(inputDate);

				if (!matcher.matches()) {
					throw new InvalidDateException("Invalid date format. Use dd/mm/yyyy or dd-mm-yyyy.");
				}

				int day = Integer.parseInt(matcher.group(1));
				int mon = Integer.parseInt(matcher.group(2));
				int yr = Integer.parseInt(matcher.group(3));

				int flag = 0;
				try {
					if (mon <= 0 || mon > 12) {
						throw new InvalidMonthException("Invalid month. Month should be between 1 and 12.");
					} else {
						if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8 || mon == 10 || mon == 12) {
							if (day >= 1 && day <= 31)
								flag = 1;
							else
								throw new InvalidDayException("Invalid day for the given month.");
						} else if (mon == 2) {
							if (yr % 4 == 0) {
								if (day >= 1 && day <= 29)
									flag = 1;
								else
									throw new InvalidDayException("Invalid day for the given month.");
							} else {
								if (day >= 1 && day <= 28)
									flag = 1;
								else
									throw new InvalidDayException("Invalid day for the given month.");
							}
						} else {
							if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {
								if (day >= 1 && day <= 30)
									flag = 1;
								else
									throw new InvalidDayException("Invalid day for the given month.");
							}
						}
					}
					if (flag == 1) {
						MyDate dt = new MyDate();
						dt.accept(day, mon, yr);
						dt.display();
					}
				} catch (InvalidDayException | InvalidMonthException ide) {
					System.out.println("Invalid Date: " + ide.getMessage());
				}
			} catch (InvalidDateException ide) {
				System.out.println("Invalid Date: " + ide.getMessage());
			}
			System.out.println("Do you want to run again ? (y/n) :");
			userinput = br.readLine().charAt(0);
		} while (userinput == 'y' || userinput == 'Y');
	}
}
