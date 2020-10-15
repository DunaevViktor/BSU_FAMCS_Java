/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

//16.	Для заданной целочисленной матрицы найти максимум среди сумм элементов диагоналей,
// параллельных главной диагонали матрицы.

public class Matrix {

    public double Zad16(int n,double [][]M,double sum_diag,double max_sum_diag){

        int i,j;

        for(i=0;i<n-1;i++) //в матрице n-1 диагоналей выше главной. //-1
        {
            sum_diag=0;
            for(j=0;j<i+1;j++)
            {
                sum_diag+=M[j][j+n-1-i];//Разница между столбцом и строкой меняется от n-1 до 1
                // вычисляется сумма текущей диагонали.
                //System.out.print("A[" + j + " " + (j+n-1-i) + "]");//выводится, какие элементы считаются
            }
            if(sum_diag>max_sum_diag)//если текущая сумма больше найденного максимума, заменить
                max_sum_diag=sum_diag;
            //System.out.println();

        }

        for(i=0;i<n-1;i++) //в матрице n-1 диагоналей ниже главной.
        {
            sum_diag=0;
            for(j=0;j<i+1;j++)
            {
                sum_diag+=M[j+n-1-i][j];//Разница между столбцом и строкой меняется от n-1 до 1
               // System.out.print("A[" + (j+n-1-i) + " " + j + "]");//выводится, какие элементы считаются
            }
            if(sum_diag>max_sum_diag)
                max_sum_diag=sum_diag;
            //System.out.println();
        }
        return max_sum_diag;
    }
}
