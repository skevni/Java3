package ru.geekbrains.sklyarov.java3core.homework1;

import java.util.ArrayList;
import java.util.Arrays;
/*
Задание не нужно былопонимать буквально и делать обощенным весь класс, можно было ограничиться только лишь статическим обощенным методом в лассе main
* */
public class SomeArray<T> {
    private final T[] array;

    public SomeArray(T[] array) {
        this.array = array;
    }

    @Override
    public String toString() {
//        return "SomeClass{" +
//                "array=" + Arrays.toString(array) +
//                '}';
        return Arrays.toString(array);
    }

    /**
     * Перемещение элементов между позициями массива from и to (значения меняются местами)
     * @param from с какой позиции массива
     * @param to на какую позицию. Затем to перемещается на позицию from
     */
    public void moveItems(int from, int to) {
        T temp;

        temp = array[to];
        array[to] = array[from];
        array[from] = temp;

    }

    /**
     * преобразование массива в ArrayList
     *
     * @return ArrayList<T>
     */
    public ArrayList<T> arrayToArrayList() {
        return new ArrayList<>(Arrays.asList(array));
    }
}
