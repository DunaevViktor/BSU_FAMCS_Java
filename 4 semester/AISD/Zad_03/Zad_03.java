package zad_03;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class Zad_03 {

public static void main(String args[]) throws FileNotFoundException {
    
    Scanner sc = new Scanner(new File("input.txt"));
    int count = sc.nextInt();
    
    int firstSize[] = new int[count+1];
    int secondSize[] = new int[count+1];
    int i = 1;
        while (i < count+1) {
            firstSize[i] = sc.nextInt();
            secondSize[i] = sc.nextInt();
            i++;
        }

    int f[][] = new int[count+1][count+1];
        for (int j = 1; j < count+1; j++) {
            f[j][j] = 0;
        }
        
    for (int p = 1; p < count ; p++) {
        for (int l = 1; l < count - p+1; l++) {
            int minNum = Integer.MAX_VALUE;
            int j = l + p ;
                for (int k = l; k <= j - 1; k++) {
                if (minNum > (f[l][k] + f[k + 1][j] + firstSize[l] * secondSize[k] * secondSize[j])){
                    minNum = f[l][k] + f[k + 1][j] + firstSize[l] * secondSize[k] * secondSize[j];
                }
            f[l][j] = minNum;
            }       
        }
    }
    
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(f[1][count]);
        pw.close();
    }
}
    
