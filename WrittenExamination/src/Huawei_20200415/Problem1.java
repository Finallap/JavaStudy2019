package Huawei_20200415;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @description: Problem1:AC100%
 * @date: 2020/4/15 18:59
 * @author: Finallap
 * @version: 1.0
 */
public class Problem1 {
    private static class Person {
        public String name;
        public int votes;

        public Person(String name, int votes) {
            this.name = name;
            this.votes = votes;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        in.close();

        String[] strs = input.split(",");

        if (input.length() == 0 || strs.length == 0 || strs.length >= 100) {
            System.out.println("error.0001");
            return;
        }

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            if (hashMap.containsKey(strs[i])) {
                int votes = hashMap.get(strs[i]) + 1;
                hashMap.put(strs[i], votes);
            } else {
                String pattern = "[A-Z]{1}[a-z]*";
                boolean valid = Pattern.matches(pattern, strs[i]);
                if (!valid) {
                    System.out.println("error.0001");
                    return;
                }
                hashMap.put(strs[i], 1);
            }
        }

        PriorityQueue<Person> queue = new PriorityQueue<Person>((o1, o2) -> {
            if (o2.votes - o1.votes != 0)
                return o2.votes - o1.votes;
            return o1.name.compareTo(o2.name);
        });
        for (String key : hashMap.keySet()) {
            Person person = new Person(key, hashMap.get(key));
            queue.add(person);
        }

        if (!queue.isEmpty()) {
            Person person = queue.peek();
            System.out.println(person.name);
        } else {
            System.out.println("error.0001");
        }
    }
}
