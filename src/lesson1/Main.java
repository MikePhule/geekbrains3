package lesson1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] array = new Integer[] {1, 2, 3};
//        int indexSource = 0;
//        int indexDest = 2;
//        array = arraySwitch(array, indexSource, indexDest);
//        for (Integer integer : array) {
//            System.out.println(integer);
//        }

//        List<Integer> list = getArrayList(array);
//        System.out.println(list);

        Box<Orange> orangeBox = new Box<>();
        Box<Apple> appleBox = new Box<>();
        Box<Fruit> fruitBox = new Box<>();
        fruitBox.addFruit(new Orange());

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

    private static <T> ArrayList<T> getArrayList(T[] array) {
        ArrayList<T> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, array);
        return arrayList;
    }

    private static <T> T[] arraySwitch(T[] t, int indexSource, int indexDest) {
        T temp = t[indexDest];
        t[indexDest] = t[indexSource];
        t[indexSource] = temp;
        return t;
    }
}

abstract class Fruit {
    float weight;

    public float getWeight() {
        return weight;
    }
}

class Orange extends Fruit {
    public Orange() {
        this.weight = 1.5f;
    }
}

class Apple extends Fruit {
    public Apple() {
        this.weight = 1f;
    }
}

class Box <T extends Fruit> {
    List<T> list;

    public Box() {
        this.list = new ArrayList<T>();
    }

    public float getWeight() {
        float weight = 0;
        for (T t : list) {
            weight += t.getWeight();
        }
        return weight;
    }

    public void addFruit(T t) {
        list.add(t);
    }

    public boolean compare(Box<?> box) {
        return this.getWeight() == box.getWeight();
    }

    public void moveToAnotherBox(Box<T> box) {
        for (T t : list) {
            box.addFruit(t);
        }
        list.clear();
    }

    public void print() {
        for (T t : list) {
            System.out.println(t);
        }
    }
}