package lesson1;

import java.util.ArrayList;
import java.util.List;

class Box<T extends Fruit> {
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
