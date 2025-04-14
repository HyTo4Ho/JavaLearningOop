package ru.academits.java.suslov.lambda_main;

import ru.academits.java.suslov.lambda.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Mikhail", 33));
        people.add(new Person("Svetlana", 15));
        people.add(new Person("Anastasia", 27));
        people.add(new Person("George", 27));
        people.add(new Person("Lemon", 11));
        people.add(new Person("Elena", 67));
        people.add(new Person("Alena", 45));
        people.add(new Person("Rowling", 87));
        people.add(new Person("Mikhail", 19));

        people.forEach(p -> System.out.print(p.getName() + "(" + p.getAge() + ") "));

        List<String> uniqueNames = people.stream().map(Person::getName).distinct().toList();

        System.out.println();

        System.out.print("Уникальные имена: ");
        uniqueNames.forEach(p -> System.out.print(p + " "));
        System.out.println();

        List<Person> minorPeoples = people.stream().filter(x -> x.getAge() < 18).toList();
        OptionalDouble averageAge = minorPeoples.stream().mapToInt(Person::getAge).average();

        System.out.printf("Средний возраст несовершеннолетних: %.2f", averageAge.getAsDouble());
        System.out.println();

        Map<String, Double> peoplesMap = people.stream().collect(Collectors.groupingBy(Person::getName, Collectors.averagingInt(Person::getAge)));

        System.out.print(peoplesMap);

        System.out.println("Имена людей 20 - 45 лет:");
        people.stream().filter(person -> person.getAge() >= 20 && person.getAge() <= 45).sorted(Comparator.comparingInt(Person::getAge).reversed()).forEach(person -> System.out.println(person.getName()));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите – сколько элементов нужно вычислить:");
        int countFibonacciNumbers = scanner.nextInt();

        System.out.printf("Первые %d чисел Фибоначчи:", countFibonacciNumbers);
        Stream.iterate(new int[]{1, 0, 1}, numbers -> new int[]{numbers[0], numbers[2], numbers[1] + numbers[2]}).limit(countFibonacciNumbers).forEach(numbers -> System.out.print(numbers[1] + " "));
    }
}