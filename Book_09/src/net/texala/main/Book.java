package net.texala.main;

import java.util.ArrayList;

public class Book {
	private String name;
	private ArrayList<Author> authors = new ArrayList<>();
	private double price;
	private int qtyInStock;

	public Book(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public Book(String name, double price, int qtyInStock) {
		this.name = name;
		this.price = price;
		this.qtyInStock = qtyInStock;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Author> getAuthors() {
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

	public void setQtyInStock(int qtyInStock) {
		this.qtyInStock = qtyInStock;
	}

	public boolean removeAuthorByName(String authorName) {
		for (Author author : authors) {
			if (author.getName().equalsIgnoreCase(authorName)) {
				authors.remove(author);

				System.out.println("Authors after removal: ");
				for (Author updatedAuthor : authors) {
					System.out.println("* " + updatedAuthor.getName());
				}

				return true;
			}
		}
		return false;
	}
}