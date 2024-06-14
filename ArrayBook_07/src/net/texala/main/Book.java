package net.texala.main;

public class Book {
	private String name;
	private Author[] authors = new Author[5];
	private int numAuthors = 0;
	private double price;
	private int qtyInStock;

	public Book(String name, Author[] authors, double price, int qtyInStock) {
		this.name = name;
		this.authors = authors;
		this.price = price;
		this.qtyInStock = qtyInStock;
		this.numAuthors = authors.length;
	}

	public String getName() {
		return name;
	}

	public Author[] getAuthors() {
		return authors;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumAuthors() {
		return numAuthors;
	}

	public void setNumAuthors(int numAuthors) {
		this.numAuthors = numAuthors;
	}

	public int getQtyInStock() {
		return qtyInStock;
	}

	public void setQtyInStock(int qtyInStock) {
		this.qtyInStock = qtyInStock;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", price=" + price + ", qtyInStock=" + qtyInStock + "]";
	}

	public void printAuthors() {
		System.out.println("The authors are:");
		for (Author author : authors) {
			if (author != null) {
				System.out.println("- " + author.getName());
			}
		}
	}
}
