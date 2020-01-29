package DZ_1_2;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    /*
1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
2. Написать метод, который преобразует массив в ArrayList;
     */

    public static void main(String[] args) {

        Swaper<String> swaper = new Swaper<>();
        String[] arr = "Goodbye World. Hello Lorem Ipsum".split(" ");
        swaper.swapInArray(arr, 0, 2);

        System.out.println(Arrays.toString(arr));


        ArrayListMaker<String> alMaker = new ArrayListMaker<>();
        ArrayList<String> al = alMaker.arrToArrayList(arr);
        System.out.println(al.getClass().getName());
    }

}
