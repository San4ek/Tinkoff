package me.inqu1sitor;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int raws = in.nextInt();
        in.nextLine();

        char[][] forest = new char[raws][3];

        for (int i = 0; i < raws; ++i) {
            String raw = in.nextLine();
            forest[i][0] = raw.charAt(0);
            forest[i][1] = raw.charAt(1);
            forest[i][2] = raw.charAt(2);
        }

        in.close();

        int[] results=new int[3];

        Instant start=Instant.now();
        results[0] = goThisWay(forest, 0, 0, raws);
        results[1] = goThisWay(forest, 0, 1, raws);
        results[2] = goThisWay(forest, 0, 2, raws);

        int result= Arrays.stream(results).max().getAsInt();

        Instant end=Instant.now();

        System.out.println(Duration.between(start, end));

        System.out.println(result);
    }

    public static int goThisWay(char[][] forest, int raw, int i, int raws) {

        int counter=0;

        if (forest[raw][i] == 'W') return counter;

        if (raw!=raws-1) {
            if (i == 0 || i == 1) {
                int res = goThisWay(forest, raw + 1, 0, raws);
                if (res>counter) counter=res;
            }

            if (i == 0 || i == 1 || i == 2) {
                int res = goThisWay(forest, raw + 1, 1, raws);
                if (res>counter) counter=res;
            }
            if (i == 1 || i == 2) {
                int res = goThisWay(forest, raw + 1, 2, raws);
                if (res>counter) counter=res;
            }
        }

        return (forest[raw][i]=='C') ? counter+1 : counter;
    }
}