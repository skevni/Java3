package ru.geekbrains.sklyarov.java3core.homework1;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    ArrayList<T> box;


    // пустая коробка
    public Box() {
        this.box = new ArrayList<>();
    }
    // заполненная фруктом
    public Box(T fruit) {
        this.box = new ArrayList<>();
        this.box.add(fruit);
    }

    public void addFruit(T fruit) {
        box.add(fruit);
    }

    public double getWeight() {
        double sum = 0.0;
        for (T t : box) {
            sum += t.getWeight();
        }
        return sum;
    }

    public boolean compare(Box<?> box) {
        return Math.abs(this.getWeight() - box.getWeight()) < 0.00001;
    }

    public void moveToAnotherBox(Box<T> newBox) {
        newBox.box.addAll(box);
        box.clear();
    }

}
