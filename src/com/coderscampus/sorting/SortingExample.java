package com.coderscampus.sorting;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class SortingExample {
    List<User> users = null;

    @BeforeAll
    public void init() {
        users = generateUsers(10);
    }

    @Test
    public void sorting_the_old_way() {

        System.out.println("Before sort by last login...");
        System.out.println("----------------------------");
        outputUsers(users);

        List<User> filteredList = new ArrayList<>();
        for (User user : users) {
            if (user.getLastLogin().plusDays(30).isAfter(LocalDate.now())) {
                filteredList.add(user);
            }

        }
        Collections.sort(filteredList, new Comparator<User>() {

            @Override
            public int compare(User user1, User user2) {
                return user1.getLastLogin().compareTo(user2.getLastLogin());
            }
        });

        System.out.println("---------------------------");
        System.out.println("After sort by last login...");
        System.out.println("---------------------------");
        outputUsers(filteredList);
    }

    @Test
    public void sorting_the_new_way() {

        System.out.println("Before sort by last login...");
        System.out.println("----------------------------");
        outputUsers(users);
        List<User> filteredUsers = users.stream()
                .filter(user -> user.getLastLogin().plusDays(30).isAfter(LocalDate.now()))
                .sorted((o1, o2) -> o1.getLastLogin().compareTo(o2.getLastLogin()))
                .collect(Collectors.toList());

        System.out.println("---------------------------");
        System.out.println("After sort by last login...");
        System.out.println("---------------------------");
        outputUsers(filteredUsers);
    }

    private void outputUsers(List<User> users) {
        users.stream()
                .forEachOrdered(System.out::println);

    }

    private List<User> generateUsers(int count) {
        System.out.println("Generating users");
        List<User> users = new ArrayList<>();
        IntStream.range(0, count)
                .forEach(i -> {
                    users.add(new User(i, generateUsername(), generatePassword(), generateDate()));
                });

        return users;
    }

    private LocalDate generateDate() {
        long minDay = LocalDate.now().minusDays(90).toEpochDay();
        long maxDay = LocalDate.now().toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        return randomDate;
    }

    private String generateUsername() {
        Random random = new Random();
        StringBuffer username = new StringBuffer();
        IntStream.range(0, 8)
                .forEach(i -> {
                    char randomizedCharacter = (char) (random.nextInt(26) + 'a');
                    username.append(randomizedCharacter);
                });
        return username.toString();
    }

    private String generatePassword() {
        Random random = new Random();
        StringBuffer password = new StringBuffer();
        IntStream.range(0, 8)
                .forEach(i -> {
                    char randomizedCharacter = (char) (random.nextInt(52) + 'a');
                    password.append(randomizedCharacter);
                });
        return password.toString();
    }
}
