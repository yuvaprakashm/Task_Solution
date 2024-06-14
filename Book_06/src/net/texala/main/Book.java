package net.texala.main;

public class Book {
	private String name;
	private Author[] authors;
	private double price;
	private int qtyInStock = 0;

	public Book(String name, Author[] authors, double price, int qtyInStock) {
		this.name = name;
		this.authors = authors;
		this.price = price;
		this.qtyInStock = qtyInStock;
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

	public int getQtyInStock() {
		return qtyInStock;
	}

	public void printAuthors() {
		System.out.println("The authors are:");
		for (Author author : authors) {
			if (author != null) {
				System.out.println("* " + author.getName());
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();

		result.append("Title: ").append(name).append("\n");
		result.append("Authors: ");
		for (Author author : authors) {
			result.append(author.getName()).append(", ");
		}
		result.setLength(result.length() - 2);
		result.append("\nPrice: $").append(price).append("\n");
		result.append("Quantity in Stock: ").append(qtyInStock);
		return result.toString();

	}

}
