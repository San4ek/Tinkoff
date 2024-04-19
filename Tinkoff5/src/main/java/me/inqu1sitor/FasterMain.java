package me.inqu1sitor;

import java.util.Arrays;
import java.util.Scanner;

public class FasterMain {

    static int raws;
    static String[] forest;
    static int[][] results=new int[2][3];

    public static void main(String[] args) {

        try(Scanner in=new Scanner(System.in)) {
            raws=in.nextInt();
            in.nextLine();

            forest=new String[raws];

            for (int i=0; i<raws; ++i) {
                forest[i]=in.nextLine();
            }
        }

        for (int i=0; i<raws; ++i) {
            if (forest[i].charAt(0)=='W' &&
                    forest[i].charAt(1)=='W' &&
                    forest[i].charAt(2)=='W') break;

            results[1][0]=forest[i].charAt(0)!='W' ? Math.max(results[0][0],results[0][1]) : -1;
            results[1][2]=forest[i].charAt(2)!='W' ? Math.max(results[0][2],results[0][1]) : -1;
            results[1][1]=forest[i].charAt(1)!='W' ? Math.max(results[0][2],results[0][0]) : -1;

            for (int j=0; j<3; ++j) {
                checkMushroom(i,j);
            }

            results[0]=results[1].clone();
        }

        System.out.println(Arrays.stream(results[1]).max().getAsInt());
    }

    public static void checkMushroom(int raw, int index) {
        if (results[1][index]!=-1 && forest[raw].charAt(index)=='C') ++results[1][index];
    }
}