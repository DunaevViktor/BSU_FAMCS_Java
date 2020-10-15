package sample;
import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;

public class Main{

    private static int currentIndex = -1;
    private static Integer next(String numbers[]) {
        ++currentIndex;
        while (currentIndex < numbers.length
                && numbers[currentIndex].equals(""))
            ++currentIndex;
        return currentIndex < numbers.length ? Integer
                .parseInt(numbers[currentIndex]) : null;
    }

    public static void main(String[] args)throws IOException {

        Controller l = new Controller();
        int sum_diag, max_sum_diag;
        max_sum_diag=0;

        FileInputStream inFile = new FileInputStream("Input.txt");
        byte[] str = new byte[inFile.available()];
        inFile.read(str);
        String text = new String(str);

        String[] numbers = text.split("\\D"); //регулярное выражение, которое означает группу чисел.
        int i, j;
        int n = next(numbers), m = next(numbers);
        int M[][] = new int[n][m];

        for (i = 0; i < n; ++i) {
            for (j = 0; j < m; ++j) {
                M[i][j] = next(numbers);
            }
        }

        System.out.println("Matrix is: ");
        for (i = 0; i < n; ++i, System.out.println()) {
            for (j = 0; j < m; ++j) {
                System.out.print(M[i][j] + " ");
            }
        }


            sum_diag = M[n-1][0];
            Matrix m1 = new Matrix();
            int otv;
            otv = m1.Zad16(n,M,sum_diag,max_sum_diag);
            System.out.println("Maximum summ is: " + otv + " ");
    }
}

