package DZ_1_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayListMaker <T> {
    public ArrayList<T> arrToArrayList(T[] arr) {
        return new ArrayList<T>(Arrays.asList(arr));
        /*ArrayList<T> al = new ArrayList<T>();
        Collections.addAll(al, arr);
        return al;*/
    }
}
