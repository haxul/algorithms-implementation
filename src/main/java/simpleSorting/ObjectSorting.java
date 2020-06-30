package simpleSorting;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class ObjectSorting {
    public static void main(String[] args) {
        Person person = new Person("lemon", 22);
        Person person2 = new Person("banana", 22);
        Person person3 = new Person("berry", 22);
        Person person4 = new Person("apple", 22);

        List<Person> list = new ArrayList<>();
        list.add(person);
        list.add(person2);
        list.add(person3);
        list.add(person4);

        System.out.println(list);
        System.out.println(select(list));
    }

    private static List<Person> bubble(List<Person> list) {
        for (int out = 0; out < list.size(); out++) {
            for (int in = out; in < list.size(); in++) {
                if (list.get(in).compareTo(list.get(out)) < 0) {
                    Person tmp = list.get(out);
                    list.set(out, list.get(in));
                    list.set(in, tmp);
                }
            }
        }
        return list;
    }
    private static List<Person> insert(List<Person> list) {
        int in, out;

        for (out = 0; out < list.size(); out++) {
            in = out;
            Person marker = list.get(out);
            while (in > 0 && list.get(in -1).compareTo(marker) >= 0) {
                list.set(in, list.get(in - 1));
                in--;
            }
            list.set(in, marker);
        }
        return list;
    }
    private static List<Person> select(List<Person> list) {
        for (int out = 0; out < list.size(); out++) {
            int min = out;
            for (int in = out; in < list.size(); in++) {
                if (list.get(in).compareTo(list.get(min)) < 0) min = in;
            }
            Person tmp = list.get(out);
            list.set(out, list.get(min));
            list.set(min, tmp);
        }
        return list;
    }
}

@AllArgsConstructor
@Data
class Person implements Comparable<Person> {
    private String name;
    private int age;


    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.name);
    }
}
