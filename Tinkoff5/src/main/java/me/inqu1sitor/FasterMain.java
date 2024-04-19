package me.inqu1sitor;

import java.util.Arrays;
import java.util.Scanner;

public class FasterMain {

    static int raws;
    static String[] forest;
    static int[] results=new int[3];

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

            results[0]=Math.max(results[0],results[1]);
            results[2]=Math.max(results[2],results[1]);
            results[1]=Math.max(results[0],results[2]);

            for (int j=0; j<3; ++j) {
                checkMushroom(i,j);
            }

            System.out.println(Arrays.toString(results));
        }

        System.out.println(Arrays.stream(results).max().getAsInt());
    }

    public static void checkMushroom(int raw, int index) {
        if (forest[raw].charAt(index)=='C') ++results[index];
    }
}