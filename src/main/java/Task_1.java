import java.util.Arrays;

public class Task_1 {

    /*
1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,
иначе в методе необходимо выбросить RuntimeException. Написать набор тестов для этого метода
(по 3-4 варианта входных данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].*/

    public int[] copyArray(int[] arr, int afterValue) throws RuntimeException {
        int elementIndex = -1;

        for (int i = arr.length-1; i > 0; i--) {
            if(arr[i] == afterValue) {
                elementIndex = i+1;
                break;
            }
        }
        if(elementIndex == -1)
            throw new RuntimeException();

        int[] newArr = new int[arr.length - elementIndex];
        System.arraycopy(arr, elementIndex, newArr, 0, newArr.length);

        System.out.println(Arrays.toString(newArr));
        return newArr;
    }
}