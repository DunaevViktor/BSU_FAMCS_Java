package sample;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {

    private static int currentIndex = -1;

    private static Integer next(String numbers[]) {
        ++currentIndex;
        while (currentIndex < numbers.length
                && numbers[currentIndex].equals(""))
            ++currentIndex;
        return currentIndex < numbers.length ? Integer
                .parseInt(numbers[currentIndex]) : null;
    }

    public static void main(String args[]) throws IOException {
        FileInputStream inFile = new FileInputStream("Input.txt");
        byte[] str = new byte[inFile.available()];
        inFile.read(str);
        String text = new String(str);

        String[] numbers = text.split("\\D"); //регулярное выражение, которое означает группу чисел.
        int i, j;
        int n = next(numbers), m = next(numbers);
        int matr[][] = new int[n][m];

        for (i = 0; i < n; ++i)
            for (j = 0; j < m; ++j)
                matr[i][j] = next(numbers);

        for (i = 0; i < n; ++i, System.out.println())
            for (j = 0; j < m; ++j)
                System.out.print(matr[i][j] + " ");
    }
}
