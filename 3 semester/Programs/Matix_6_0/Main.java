package sample;
import java.util.*;


public class Main  {
    public static void main(String[] args){
        Controller l1 = new Controller();
        String s = new String();
        int kol1;
        int kol2;

        System.out.print("Input size of matrix: ");
        kol1 = l1.FuncKC();
        kol2 = l1.FuncKC();

        System.out.println("Input elements of matrix: ");
        s = l1.FuncK();
        StringTokenizer st = new StringTokenizer(s," \t\n\r");
        int [][]M = new int [kol1][kol2];

        for(int i=0;i<kol1;i++)
        {
            for(int y =0;y<kol2;y++) {
                if (st.hasMoreTokens()) {
                    M[i][y] = Integer.parseInt(st.nextToken());
                } else {
                    M[i][y] = 0;
                }
            }
        }

        System.out.println("Matrix is: ");

        for(int i=0; i<kol1;i++)
        {
            for(int p=0;p<kol2;p++) {
                System.out.print(M[i][p] + " ");
            }
            System.out.println();
        }

        int n = kol1;
        int m = kol2;
        int []c = new int[n+1];
        int []y = new int[m+1];
        for(int j=1; j<=n;j++)
        {
            c[j]=0;
        }
//Подсчет суммы
        for (int o = 0; o < n; o++)
        {
            for (int u = 0; u < m; u++)
            {
                c[o] += M[o][u];
            }
           // System.out.print(c[o] + "   ");
        }
//Сорт. массив сумм и матрицу
        int x, l, k, i;

        for(k=1;k<=n-1;k++)
        {
            l=k; x=c[l];
            for(i=k+1;i<=n;i++)
                if(c[i]<x)
                {
                    l=i; x=c[l];
                    for(int j=1; j<=m;j++){
                        y[j] = M[l][j];
                    }
                }
            c[l]=c[k];
            c[k]=x;
            for(int j=1; j<=m;j++)
            {
                M[l][j]=M[k][j];
                M[k][j]=y[j];
            }
        }

        System.out.println("Sort Massiv : ");
        System.out.println();
        for(int a=1; a<=n;a++)
        {
            for(int b=1; b<=m;b++)
                System.out.println(M[a][b] + " ");
            System.out.println();
        }

    }
}
