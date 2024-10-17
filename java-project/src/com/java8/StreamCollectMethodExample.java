package com.java8;

import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

class Staff {
	private Long id;
	private String firstName;
	private String lastName;
	private String city;
	private double salary;
	private LocalDate dob;

	public Staff(Long id, String firstName, String lastName, String city, double salary, LocalDate dob) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.salary = salary;
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Staff{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\''
				+ ", city='" + city + '\'' + ", salary=" + salary + ", dob=" + dob + '}';
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
}

public class StreamCollectMethodExample {

	public static void main(String[] args) {

		List<Staff> list = Arrays.asList(new Staff(1L, "Mohd", "Ali", "New York", 60000.00, LocalDate.of(1992, 6, 15)),
				new Staff(2L, "Amir", "Suhel", "Los Angeles", 75000.00, LocalDate.of(1989, 11, 25)),
				new Staff(3L, "Raman", "Patel", "Chicago", 55000.00, LocalDate.of(1995, 3, 5)),
				new Staff(4L, "Zara", "Ahmed", "New York", 62000.00, LocalDate.of(1991, 8, 22)),
				new Staff(5L, "Omar", "Naseem", "Los Angeles", 70000.00, LocalDate.of(1988, 12, 30)),
				new Staff(6L, "Liam", "Smith", "Chicago", 58000.00, LocalDate.of(1990, 4, 17)),
				new Staff(7L, "Emma", "Johnson", "New York", 62000.00, LocalDate.of(1993, 9, 12)),
				new Staff(8L, "John", "Williams", "Los Angeles", 73000.00, LocalDate.of(1987, 12, 5)),
				new Staff(9L, "Olivia", "Brown", "Chicago", 60000.00, LocalDate.of(1994, 1, 20)),
				new Staff(10L, "Vishal", "Uthaap", "Los Angeles", 68000.00, LocalDate.of(1996, 6, 25)),
				new Staff(11L, "Earl", "Seth", "Los Angeles", 68000.00, LocalDate.of(1996, 6, 25)));

		// Example usage:
		list.forEach(System.out::println);
		System.out.println("------------------------------------------------------------");

		System.out.println("1: Filtering..........");
		/**
		 * 1. **Filtering:**
		 */
		// How can I filter the staff members who live in a specific city?
		System.out.println("who live in a specific city");
		list.stream().filter(e -> e.getCity().equalsIgnoreCase("New York")).forEach(e -> System.out.println(e.getId()));

		// How can I filter staff members whose salary exceeds a given amount?
		System.out.println("whose salary exceeds a given amount");
		list.stream().filter(e -> e.getSalary() > 70000).forEach(e -> System.out.println(e.getSalary()));

		System.out.println("-------------------------------------------------------------");
		System.out.println("2: Mapping...........");
		/**
		 * 2. **Mapping:**
		 */
		// How can I create a list of staff members' full names (first name and last
		// name combined)?
		System.out.println("staff members' full names (first name and last name combined)");
		List<String> fullNamesList = list.stream().map(e -> e.getFirstName().concat(" " + e.getLastName()))
				.collect(Collectors.toList());
		System.out.println(fullNamesList);

		// How can I get a list of all staff members' salaries?
		System.out.println("list of all staff members' salaries");
		List<Double> salaryList = list.stream().map(e -> e.getSalary()).collect(Collectors.toList());
		System.out.println(salaryList);

		System.out.println("--------------------------------------------------------------");
		System.out.println("3: Sorting.......");
		/**
		 * 3. **Sorting:**
		 */
		// How can I sort the staff members by their last names?
		System.out.println("sort the staff members by their last names");
		list.stream().sorted((a, b) -> a.getLastName().compareToIgnoreCase(b.getLastName()))
				.forEach(e -> System.out.println(e.getLastName()));
		list.stream().sorted(Comparator.comparing(Staff::getLastName));

		// How can I sort the staff members by salary in descending order?
		System.out.println("sort the staff members by salary in descending order");
		list.stream().sorted(Comparator.comparingDouble(Staff::getSalary).reversed())
				.forEach(e -> System.out.println(e.getSalary()));
		list.stream().sorted((a, b) -> (int) (b.getSalary() - a.getSalary()))
				.forEach(e -> System.out.println(e.getSalary()));

		System.out.println("--------------------------------------------------------------");
		System.out.println("4: Grouping...........");
		/**
		 * 4. **Grouping:**
		 */
		// How can I group staff members by their city?
		System.out.println("Group staff members by their city");
		Map<String, List<Long>> collect = list.stream()
				.collect(Collectors.groupingBy(Staff::getCity, Collectors.mapping(Staff::getId, Collectors.toList())));
		System.out.println(collect);

		Map<String, List<Entry<Long, Double>>> collect2 = list.stream()
				.collect(Collectors.groupingBy(Staff::getCity,
						Collectors.mapping(staff -> new AbstractMap.SimpleEntry<>(staff.getId(), staff.getSalary()),
								Collectors.toList())));
		System.out.println("by another way..............");
		System.out.println(collect2);

		// How can I group staff members by the first letter of their last name?
		System.out.println("group staff members by the first letter of their last name");
		Map<Character, List<String>> collect3 = list.stream().collect(Collectors.groupingBy(
				e -> e.getLastName().charAt(0), Collectors.mapping(Staff::getLastName, Collectors.toList())));
		System.out.println(collect3);
		// use sort in the above question
		System.out.println("group staff members by the first letter of their last name in ascending order");
		TreeMap<Character, List<String>> collect4 = list.stream()
				.collect(Collectors.groupingBy(e -> e.getLastName().charAt(0), TreeMap::new,
						Collectors.mapping(Staff::getLastName, Collectors.toList())));
		System.out.println(collect4);

		TreeMap<Character, List<String>> collect5 = list.stream()
				.collect(Collectors.groupingBy(e -> e.getLastName().charAt(0), TreeMap::new,
						Collectors.collectingAndThen(Collectors.mapping(Staff::getLastName, Collectors.toList()),
								listNames -> listNames.stream().sorted().collect(Collectors.toList()))));

		System.out.println("another output");
		System.out.println(collect5);
	}
}
