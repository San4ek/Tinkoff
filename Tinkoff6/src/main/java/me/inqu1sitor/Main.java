package me.inqu1sitor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][][] opt = new int[100][100][2];
        int[][] mat = new int[100][100];

        int f1 = 0, f2 = 0;
        for (int i = 0; i < n; i++) {
            String x = scanner.next();
            for(int j = 0; j < n; j++) {
                opt[i][j][0] = opt[i][j][1] = 100000;
                mat[i][j] = x.charAt(j);
                if(mat[i][j] == 'S') {
                    opt[i][j][0] = 0;
                    mat[i][j] = '.';
                }
                if(mat[i][j] == 'F') {
                    f1 = i;
                    f2 = j;
                    mat[i][j] = '.';
                }
            }
        }

        for(int k = 0; k < 400; k++){
            for (int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(opt[i][j][0] >= 0){
                        for(int g1 = -2; g1 <= 2; g1++){
                            if(g1 == 0) continue;
                            for(int g2 = -2; g2 <= 2; g2++){
                                if(g2 == 0) continue;
                                if(Math.abs(g1) == Math.abs(g2)) continue;
                                int nx1 = i + g1, nx2 = j + g2;
                                if(nx1 >= 0 && nx1 < n && nx2 >= 0 && nx2 < n){
                                    int p = 0;
                                    if(mat[nx1][nx2] == 'G'){
                                        p = 1;
                                    }
                                    if(opt[nx1][nx2][p] > opt[i][j][0] + 1){
                                        opt[nx1][nx2][p] = opt[i][j][0] + 1;
                                    }
                                }
                            }
                        }
                    }
                    if(opt[i][j][1] >= 0){
                        for(int g1 = -1; g1 <= 1; g1++) {
                            for (int g2 = -1; g2 <= 1; g2++) {
                                if(g1 == 0 && g2 == 0) continue;
                                int nx1 = i + g1, nx2 = j + g2;
                                if(nx1 >= 0 && nx1 < n && nx2 >= 0 && nx2 < n) {
                                    int p = 1;
                                    if(mat[nx1][nx2] == 'K'){
                                        p = 0;
                                    }
                                    if(opt[nx1][nx2][p] > opt[i][j][1] + 1){
                                        opt[nx1][nx2][p] = opt[i][j][1] + 1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        int mx = opt[f1][f2][0];
        if(mx > opt[f1][f2][1]){
            mx = opt[f1][f2][1];
        }
        if(mx == 100000) {
            System.out.print(-1);
        } else {
            System.out.print(mx);
        }
        scanner.close();
    }
}