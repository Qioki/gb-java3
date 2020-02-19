public class Task_2 {
    /*
2. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной
четверки или единицы, то метод вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).
     */
    public boolean findValuesInArray(int[] arr, int[] values) {

        nextValue: for (int value : values) {
            for (int element : arr) {
                if (value == element) continue nextValue;
            }
            return false;
        }
        return true;
    }
}
