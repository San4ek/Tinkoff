package me.inqu1sitor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        int n=in.nextInt();
        int m=in.nextInt();

        int[][] matrix=new int[n][m];

        for (int i=0; i<n; ++i) {
            for (int j=0; j<m; ++j) {
                matrix[i][j]=in.nextInt();
            }
        }

        in.close();

        if (n==1 && m==1) {
            System.out.println(matrix[0][0]);
            System.exit(0);
        }

        for (int i=0; i<m; ++i) {
            for (int j=n-1; j>=0; --j) {
                System.out.print(matrix[j][i]+" ");
            }
            System.out.print("\n");
        }
    }
}