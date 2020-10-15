package aisd_alex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Aisd_alex {
    public static class node {
int key;
node next;
node prev;

node() {
}
}
    
    
    public static void main(String[] args)throws FileNotFoundException {
        Scanner sc = new Scanner(new File("in.txt"));
        PrintWriter pw = new PrintWriter("out.txt");

int N = sc.nextInt();
int M = sc.nextInt();
int L = sc.nextInt();
int ost = 0;

node[] arr = new node[N];

for (int i = 0; i < N; i++) {
arr[i] = new node();
arr[i].key = i;
}

if (N > 1) {
for (int i = 1; i < N - 1; i++) {
arr[i].next = arr[i + 1];
arr[i].prev = arr[i - 1];
}
arr[0].next = arr[1];
arr[0].prev = arr[N - 1];
arr[N - 1].next = arr[0];
arr[N - 1].prev = arr[N - 2];
}

/*for(int i= 0;i<N;i++){
    System.out.print(arr[i].prev + "/" +arr[i].next);
    System.out.println();
}*/

int m = M;
node tempKey = arr[0];

for (int i = 0; i < N - 1; i++) {
int n = N - i;
if (m >= n) {
M = m % n;
}
if (M == 0) {
M = M + n;
}

for (int j = 0; j < M -1; j++) {
tempKey = tempKey.next;
}
tempKey.prev.next = tempKey.next;
tempKey.next.prev = tempKey.prev;
tempKey = tempKey.next;
}

int otvet = tempKey.key + 1;

ost = L - tempKey.key;
if (ost < 0) {
ost = ost + N;
}

pw.print(otvet);
pw.append('\n');
pw.print(ost);
pw.close();
    }
    
}
