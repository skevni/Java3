package ru.geekbrains.sklyarov.java3core.homework1;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    ArrayList<T> box;
    T content;

    // пустая коробка
    public Box() {
        this.box = new ArrayList<>();
    }

    // заполняем количеством фруктов
    public Box(T content, int count) {
        this.content = content;
        this.box = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            this.box.add(content);
        }

    }

    public void addFruit(int count) {
        for (int i = 0; i < count; i++) {
            box.add(content);
        }
    }

    public void addFruit(T fruit) {
        box.add(content);
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
