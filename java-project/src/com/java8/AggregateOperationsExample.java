//package com.java8;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//class Person {
//    private String name;
//    private int age;
//
//    public Person(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    @Override
//    public String toString() {
//        return "Person{name='" + name + "', age=" + age + '}';
//    }
//}
//
//public class AggregateOperationsExample {
//    public static void main(String[] args) {
//        // Create a list of Person objects
//        List<Person> people = new ArrayList<>();
//        people.add(new Person("Ravi", 25));
//        people.add(new Person("Sita", 30));
//        people.add(new Person("Arjun", 22));
//        people.add(new Person("Lakshmi", 20));
//        people.add(new Person("Rahul", 25));
//
//        // Filter people older than 25
//        List<Person> filteredPeople = people.stream()
//            .filter(person -> person.getAge() > 25)
//            .collect(Collectors.toList());
//        System.out.println("Filtered People: " + filteredPeople);
//
//        // Extract names of all people
//        List<String> names = people.stream()
//            .map(Person::getName)
//            .collect(Collectors.toList());
//        System.out.println("Names: " + names);
//
//        // Sum of ages of all people
//        int totalAge = people.stream()
//            .map(Person::getAge)
//            .reduce(0, Integer::sum);
//        System.out.println("Total Age: " + totalAge);
//
//        // Group people by age
//        Map<Integer, List<Person>> peopleByAge = people.stream()
//            .collect(Collectors.groupingBy(Person::getAge));
//        System.out.println("People grouped by age: " + peopleByAge);
//    }
//}