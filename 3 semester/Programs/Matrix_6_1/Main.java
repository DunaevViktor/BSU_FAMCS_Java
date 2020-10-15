package sample;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Controller l = new Controller();
        String s = new String();
        int kol1;
        int kol2;

        System.out.print("Input size of matrix: ");
        kol1 = l.FuncKC();
        kol2 = l.FuncKC();

        System.out.println("Input elements of matrix: ");
        s = l.FuncK();
        StringTokenizer st = new StringTokenizer(s, " \t\n\r");
        int[][] M = new int[kol1][kol2];

        for (int i = 0; i < kol1; i++) {
            for (int y = 0; y < kol2; y++) {
                if (st.hasMoreTokens()) {
                    M[i][y] = Integer.parseInt(st.nextToken());
                } else {
                    M[i][y] = 0;
                }
            }
        }

        System.out.println("Matrix is: ");

        for (int i = 0; i < kol1; i++) {
            for (int p = 0; p < kol2; p++) {
                System.out.print(M[i][p] + " ");
            }
            System.out.println();
        }


        // массив индексов
        System.out.println("Strings: ");
        int[] index = new int[kol1];
        for (int b = 0; b < kol1; b++)
        {
            index[b] = b;
            System.out.print(b + "    ");
        }
        System.out.println();

        // подсчет суммы строк
        int[] sum = new int[kol1];
        for (int o = 0; o < kol1; o++)
        {
            for (int u = 0; u < kol2; u++)
            {
                sum[o] += M[o][u];
            }
           System.out.print(sum[o] + "   ");
        }
        System.out.println();
        System.out.println();

        // сортировка массива сумм
       // int[] sum1 = new int[kol1];
        //sum1 = Arrays.copyOf(sum,kol1);
        Arrays.sort(sum);
        //Arrays.sort(index);

        for (int h=0;h<kol1;h++)
        {

        }
        System.out.println("Sort Strings: ");
        for (int r = 0; r < kol1; r++)
        {
            System.out.print(index[r] + "    ");
        }
        System.out.println();
        for (int e = 0; e < kol1; e++)
        {
            System.out.print(sum[e] + "   ");
        }
//////////////////////////////////////////////////////////

        int[][] mas2 = new int[kol1][kol2];
        for (int d = 0; d < kol1; d++)
        {
            for (int g = 0; g<kol2; g++)
            {
                mas2[d][g] = M[index[d]][g];
            }
        }

        System.out.println();
        System.out.println();
        // Вывод отсортированной матрицы
        System.out.println("Sort Matrix: ");
        for (int z = 0; z < kol1; z++)
        {
            for (int f = 0; f < kol2; f++)
            {
                System.out.print(mas2[z][f] + " ");
            }
            System.out.println();
        }


    }
}

