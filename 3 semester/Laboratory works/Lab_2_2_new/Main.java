/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;

public class Main{

    
    public static void main(String[] args)throws IOException {

        int i=0; int j=0;
        
        double sum_diag, max_sum_diag;
        max_sum_diag=0;
        
        InputFile inp = new InputFile("Input.txt");
        int n1;
        int m1;
        n1 = inp.sizeTake();
        m1 = inp.sizeTake();
        double M[][] = new double[n1][m1];
        
        M = inp.create2XMatrix(n1, m1);
        
            System.out.println("Matrix is: ");
        for (i = 0; i < n1; ++i, System.out.println()) {
            for (j = 0; j < m1; ++j) {
                System.out.print(M[i][j] + " ");
            }
        }

            sum_diag = M[n1-1][0];
            Matrix M1 = new Matrix();
            double otv;
            otv = M1.Zad16(n1,M,sum_diag,max_sum_diag);
            System.out.println("Maximum summ is: " + otv + " ");
    }
}

