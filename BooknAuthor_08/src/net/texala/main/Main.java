package net.texala.main;

public class Main {
	public static void main(String[] args) {

		Book javaDummy = new Book("Java for Dummy", 19.99, 99);
		System.out.println(javaDummy);
		System.out.print("The authors are: ");
		javaDummy.printAuthors();

		javaDummy.addAuthor(new Author("Tan Ah Teck", "AhTeck@somewhere.com", 'm'));
		javaDummy.addAuthor(new Author("Paul Tan", "Paul@nowhere.com", 'm'));

		System.out.println(javaDummy);
		System.out.print("The authors are: ");
		javaDummy.printAuthors();

		javaDummy.setPrice(29.99);
		javaDummy.setQtyInStock(150);

		System.out.println("Updated Book Details:");
		System.out.println(javaDummy);
	}
}
