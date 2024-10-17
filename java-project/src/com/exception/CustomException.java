package com.exception;

import java.util.List;

class InvalidOrderException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidOrderException() {
		super("The order is Invalid");
	}

	public InvalidOrderException(String message) {
		super(message);
	}
}

class OrderConfigurationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderConfigurationException() {
		super("Configuration of the order is incorrect");
	}

	public OrderConfigurationException(String message) {
		super(message);
	}

}

class Order {
	private List<Integer> items;
	private String configuration;

	public Order() {

	}

	public Order(List<Integer> items, String configuration) {
		super();
		this.setItems(items);
		this.setConfiguration(configuration);
	}

	public List<Integer> getItems() {
		return items;
	}

	public void setItems(List<Integer> items) {
		this.items = items;
	}

	public String getConfiguration() {
		return configuration;
	}

	public void setConfiguration(String configuration) {
		this.configuration = configuration;
	}

}

class OrderProcessor {
	public void validateOrder(Order order) throws InvalidOrderException {
		if (order == null || order.getItems().isEmpty()) {
			throw new InvalidOrderException("Order is empty or null");
		}
	}

	public void configureOrder(Order order) {
		if (order.getConfiguration() == null) {
			throw new OrderConfigurationException("Order lacks necessary configuration");
		}
	}
}

public class CustomException {

	public static void main(String[] args) {

		OrderProcessor processor = new OrderProcessor();
		try {
			processor.validateOrder(null); // This will throw InvalidOrderException
		} catch (InvalidOrderException e) {
			System.out.println("Error: " + e.getMessage());
		}

		processor.configureOrder(new Order()); // This will throw OrderConfigurationException

	}

}
