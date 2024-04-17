package me.inqu1sitor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        int size=in.nextInt();

        int[] marks=new int[size];

        for (int i=0; i<size; ++i) {
            marks[i]=in.nextInt();
        }

        if (size<7) {
            System.out.println(-1);
            System.exit(0);
        }


        in.close();

        int result = getResult(size, marks);

        System.out.println(result);
    }

    private static int getResult(int size, int[] marks) {
        int fast=0;

        int result=-1;

        int counter=0;

        for (int slow = 0; slow<= size -7; ++slow) {
            if (slow!=0 && counter!=0 && marks[slow-1]==5) --counter;


            while (fast<=slow+6) {
                if (marks[fast]<4) {
                    slow=fast;
                    ++fast;
                    counter=0;
                    break;
                }

                if (marks[fast]==5) ++counter;

                ++fast;
            }

            if (counter!=0 && counter>result) result=counter;
        }
        return result;
    }
}