package sample;
import java.io.FileInputStream;
import java.io.IOException;

public class Main  {

    private static int currentIndex = -1; //индекс символа
    private static Integer next(String numbers[]) {
        ++currentIndex;// 0
        while (currentIndex < numbers.length
                && numbers[currentIndex].equals(""))
            //пока индекс меньше длинны строки
            ++currentIndex;
        return currentIndex < numbers.length ? Integer
                .parseInt(numbers[currentIndex]) : null;
        //если да , то преобразовать в число , если нет , то вернуть 0
    }

    public static void main(String[] args)throws IOException{


        FileInputStream inFile = new FileInputStream("Input.txt");
        byte[] str = new byte[inFile.available()];
        inFile.read(str);
        String text = new String(str);

        String[] numbers = text.split("\\D"); //регулярное выражение, которое означает группу чисел.
        int a, b;
        int kol1 = next(numbers), kol2 = next(numbers);
        int M[][] = new int[kol1][kol2];

        for (a = 0; a < kol1; ++a) {
            for (b = 0; b < kol2; ++b) {
                M[a][b] = next(numbers);
            }
        }

        System.out.println("Matrix is: ");
        for (a = 0; a < kol1; ++a, System.out.println()) {
            for (b = 0; b < kol2; ++b) {
                System.out.print(M[a][b] + " ");
            }
        }
        System.out.println();
/////////////////////////////////////////////////
        int []mas2 = new int[kol1];

        for (int i = 0; i<kol1; i++) {
            for (int j = 0; j < kol2; ++j) {
                mas2[i] += M[i][j];
            }
            System.out.println("Summ of " + i + " str = " + mas2[i]);
        }

        System.out.println();

        for (int i = 0; i < kol1 - 1; i++) {
            for (int j = i + 1; j < kol1; j++) {
                if (mas2[i] > mas2[j]) {

                    mas2[i] = mas2[i] + mas2[j];  // a = a + b;
                    mas2[j] = mas2[i] - mas2[j];  //b = a - b;
                    mas2[i] = mas2[i] - mas2[j];  //a = a - b;

                    int[] x;
                    x = M[i];
                    M[i] = M[j];
                    M[j] = x;
                }
            }
        }

        System.out.println("Matrix Sort: ");
        for (int i = 0; i < kol1; ++i) {
            for (int j = 0; j < kol2; ++j) {
                System.out.print(M[i][j] + " ");
            }
           System.out.println();
        }

    }
}