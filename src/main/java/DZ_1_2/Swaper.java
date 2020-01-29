package DZ_1_2;


public class Swaper<T> {

    public void swapInArray(T[] arr, int indexA, int indexB) {
        if(arr == null || indexA < 0 || indexB < 0 || indexA >= arr.length || indexB >= arr.length) return;
        T temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }
}
