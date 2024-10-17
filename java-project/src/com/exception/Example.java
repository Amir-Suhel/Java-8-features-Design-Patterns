package com.exception;

class Resource {
	private int id;

	public Resource(int id) {
		this.id = id;
	}
}

class ResourceManager {
	public Resource getResource(int id) throws ResourceNotFoundException {
		if (id == 10) {
			new Resource(id);
		} else {
			throw new ResourceNotFoundException("Resource with id: " + id + " not found");
		}
		return null;
	}
}

class ResourceNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object resourceId) {
		super(resourceId != null ? resourceId.toString() : null);
	}

}

public class Example {

	public static void main(String[] args) {
		ResourceManager manager = new ResourceManager();
		try {
			manager.getResource(0);
		} catch (ResourceNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

}
