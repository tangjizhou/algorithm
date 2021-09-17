package net.mshome.twisted.algorithm.java;

import java.util.ArrayList;
import java.util.List;

/**
 * javac -source 1.8 -Xlint:all ParadigmWarning.java
 *
 * @author tangjizhou
 * @since 2021/8/9
 */
public class ParadigmWarning<T> {


    private List items = new ArrayList<>();

    public static void main(String[] args) {
        ParadigmWarning warning = new ParadigmWarning();
        warning.addItems("hello");
        warning.addItems("world");
        warning.print();

        List<? super Fruit> fruits = new ArrayList<>();
        fruits.add(new Apple());
        fruits.add(new BigApple());
        fruits.add(new Fruit());

        List<? super Apple> list = new ArrayList<>();
        list.add(new BigApple());
        list.add(new Apple());
    }

    public void addItems(String item) {
        items.add(item);
    }

    public void print() {
        items.forEach(System.out::println);
    }


    static class Fruit {

    }

    static class Apple extends Fruit {

    }

    static class BigApple extends Apple {

    }


}
