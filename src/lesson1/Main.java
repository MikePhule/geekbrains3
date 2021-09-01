package lesson1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Task 1.");
        Integer[] array = new Integer[] {1, 2, 3};
        System.out.println("Source array:");
        printArray(array);

        int indexSource = 0;
        int indexDest = 2;
        array = arraySwitch(array, indexSource, indexDest);
        System.out.println("Switched array:");
        printArray(array);

        System.out.println("--------------------------");
        System.out.println("Task 2.");
        List<Integer> list = getArrayList(array);
        System.out.println("Array list:" + list);

        System.out.println("--------------------------");
        System.out.println("Task 3.");
        Box<Orange> orangeBox = new Box<>();
        Box<Apple> appleBox = new Box<>();

        orangeBox.addFruit(new Orange());
//        orangeBox.addFruit(new Orange());

        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());

        Box<Orange> orangeBox1 = new Box<>();
        orangeBox1.addFruit(new Orange());

        orangeBox.moveToAnotherBox(orangeBox1);
        System.out.println(orangeBox.getWeight());
        System.out.println(orangeBox1.getWeight());
        System.out.println(orangeBox1.compare(appleBox));
    }

    private static void printArray(Integer[] array) {
        for (Integer integer : array) {
            System.out.println(integer);
        }
    }

    // Task 1
    private static <T> ArrayList<T> getArrayList(T[] array) {
        ArrayList<T> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, array);
        return arrayList;
    }

    // Task 2
    private static <T> T[] arraySwitch(T[] t, int indexSource, int indexDest) {
        T temp = t[indexDest];
        t[indexDest] = t[indexSource];
        t[indexSource] = temp;
        return t;
    }
}

