package solution;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];               //В качестве примера берем обычный
        for (int i = 0; i < n; i++) {           //целочисленный массив, но тут может
           array[i] = scanner.nextInt();        //быть массив(или коллекция) из
        }                                       // других типов данных, для которых
                                                // задан свой компоратор
                                                
        HeapUtils.sort(array);                //Вызов соритровки
        System.out.println(Arrays.toString(array));

    
    }
}


class HeapUtils {
    public static void heapify(int[] array, int size, int pos) {    
        while (2 * pos + 1 < size) {                       //Процедура нормализации
            int t = 2 * pos + 1;                           //подкучи в куче с  
                                                           //головой в pos
            if (2 * pos + 2 < size && array[2 * pos + 1] < array[2 * pos + 2]) {
                t = 2 * pos + 2;
            }
            if (array[pos] < array[t]) {
                swap(array, pos, t);
                pos = t;
            } else {
                break;
            }
        }
    }

    public static int[] heapMake(int[] array) {  //Построение кучи из массива при
        int n = array.length;                    //помощи функции heapify  
        for (int i = n - 1; i >= 0; i--) {
            heapify(array, n, i);
        }
        return array;
    }

    public static void sort(int[] array) { //Собственно сама сортировка
        int n = array.length;
        heapMake(array);
        while (n > 0) {
            swap(array, 0, n - 1);
            n--;
            heapify(array, n, 0);
        }

    }

    private static void swap(int[] array, int i, int j) { //Меняет местами
        int temp = array[i];                                //элементы с  
        array[i] = array[j];                                //индексами i и j
        array[j] = temp;                                    //в массиве array
    }

}