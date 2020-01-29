public class Main {
 
    public static void main(String[] args) {
        Box<Apple> box1 = new Box<>();
        Box<Orange> box2 = new Box<>();

        box1.put(new Apple[]{ new Apple(), new Apple(), new Apple(), new Apple(), new Apple(), new Apple()});
        box2.put(new Orange[]{ new Orange(), new Orange(), new Orange(), new Orange()});

        System.out.println("Apple box weight: " + box1.getWeight());
        System.out.println("Orange box weight: " + box2.getWeight());

        System.out.println("box1" + (box1.compare(box2) ? " == " : " != ") + "box2");

        Box<Apple> newBox = new Box<>();
        box1.shiftToAnotherBox(newBox);

        System.out.println("box1 weight: " + box1.getWeight());
        System.out.println("newBox weight: " + newBox.getWeight());
    }
}