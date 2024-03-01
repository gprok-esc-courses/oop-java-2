package test_java_classes;

import com.github.javafaker.Faker;

import java.util.ArrayList;

public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        Faker faker = new Faker();
        for(int i = 0; i < 50; i++) {
            names.add(faker.name().fullName());
        }

//        for(int i = 0; i < names.size(); i++) {
//            System.out.println(names.get(i));
//        }

        for(String name : names) {
            System.out.println(name);
        }

        ArrayList<Integer> values = new ArrayList<>();
        values.add(5);
    }
}
