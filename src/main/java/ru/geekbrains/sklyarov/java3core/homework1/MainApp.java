package ru.geekbrains.sklyarov.java3core.homework1;

import java.util.ArrayList;
import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
/*
Задание не нужно было понимать буквально и делать обобщенным весь класс, можно было ограничиться только лишь
статическим обощенным методом в классе main
Преподаватель объяснил, что сильно усложнили.
Но я как раз первое задание понял так, что нужно позволить создать массив любого типа, поэтому целый обощенный класс.

* */

        // 1. Поменять 2 элемента массива местами

        SomeArray<Double> arr = new SomeArray<>(new Double[]{0.45, 1.55, 6.78, 999.9});
        arr.moveItems(0, 3);
        System.out.println(arr.toString());

        // 2. Преобразовать в ArrayList
//        SomeArray<Integer> arr2 = new SomeArray<>(new Integer[]{1,2,3,4,5,6,7,8,9});
        Float[] arr2 = {0.45f, 1.55f, 6.78f, 999.9f};
        ArrayList<Float> l = toList(arr2);
        System.out.println("Тип следующего объекта: " + l.getClass().getName());

        System.out.println(l.toString());

        // 3.
        Apple apple = new Apple(1);
        Orange orange = new Orange(1.5);
        Box<Apple> appleBox = new Box<>(apple);
        Box<Orange> orangeBox = new Box<>(orange);
        /* предыдущая идея по добавлению в конструктор объекта фрукта и количества была ошибочной, т.к. я передавал
            один объект и хранил в листе ссылки на этот объект. При изменении веса у одного фрукта, вес менялся у всех
            это не верно. Необходимо в каждый элемен ArrayList ложить новый объект фрукта. Н - невнимательность
         */
        for(int i = 0; i < 6; i++){
            appleBox.addFruit(apple);
        }

        for(int i = 0; i < 5; i++){
            orangeBox.addFruit(orange);
        }
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

    private static <T>ArrayList<T> toList(T[] arr){
        return new ArrayList<>(Arrays.asList(arr));
    }

}
