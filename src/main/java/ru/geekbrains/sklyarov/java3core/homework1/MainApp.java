package ru.geekbrains.sklyarov.java3core.homework1;

import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args) {
        // 1. Поменять 2 элемента массива местами

        SomeArray<Double> arr = new SomeArray<>(new Double[]{0.45, 1.55, 6.78, 999.9});
        arr.moveItems(0, 3);
        System.out.println(arr.toString());

        // 2. Преобразовать в ArrayList
//        SomeArray<Integer> arr2 = new SomeArray<>(new Integer[]{1,2,3,4,5,6,7,8,9});

        ArrayList<Double> l = arr.arrayToArrayList();
        System.out.println("Тип следующего объекта: " + l.getClass().getName());

        System.out.println(l.toString());

        // 3.
        Apple apple = new Apple(1);
        Orange orange = new Orange(1.5);

        Box<Apple> appleBox = new Box<>(apple, 6);
        Box<Orange> orangeBox = new Box<>(orange, 6);

        appleBox.addFruit(3);

        appleBox.addFruit(apple);
        orangeBox.addFruit(orange);

        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());

        System.out.println(appleBox.compare(orangeBox));

        Box<Apple> appleBox1 = new Box<>();
        appleBox.moveToAnotherBox(appleBox1);
//        System.out.println(appleBox.getWeight());
//        System.out.println(appleBox1.getWeight());
    }

}
