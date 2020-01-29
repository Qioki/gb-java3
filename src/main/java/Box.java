import java.util.ArrayList;
import java.util.Arrays;

public class Box <T extends Fruit> {

    ArrayList<T> fruits = new ArrayList<>();

    public void put(T[] fruitArr) {
        fruits.addAll(Arrays.asList(fruitArr));
    }
    public void put(ArrayList<T> fruits) {
        this.fruits.addAll(fruits);
    }
    public float getWeight() {
        if(fruits.size() == 0) return 0;
        return fruits.size() * fruits.get(0).getWeight();
    }
    public boolean compare(Box<?> anotherBox) {
        return getWeight() == anotherBox.getWeight();
    }
    public void shiftToAnotherBox(Box<T> box) {
        box.put(fruits);
        fruits.clear();
    }

}
