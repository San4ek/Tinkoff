package me.inqu1sitor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        int raws=in.nextInt();
        in.nextLine();

        String[] arr=new String[raws];

        for (int i=0; i<raws; ++i) {
            arr[i]=in.nextLine();
        }
        in.close();

        quickSort(arr,0,raws-1);

        for (String str : arr) {
            String[] strParts=str.split("/");

            if (strParts.length==1) {
                System.out.println(strParts[0]);
            } else {
                for (int i=0; i<strParts.length-1; ++i) {
                    System.out.print("  ");
                }
                System.out.println(strParts[strParts.length-1]);
            }
        }
    }

    public static void quickSort(String[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private static int partition(String[] arr, int begin, int end) {
        int middle=(begin+end)/2;

        String pivot = arr[middle];

        swap(arr,middle,end);

        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i++;

                swap(arr,i,j);
            }
        }

        swap(arr,i+1,end);

        return i+1;
    }

    public static void swap(String[] arr, int i, int j) {
        String swapTemp = arr[i];
        arr[i] = arr[j];
        arr[j] = swapTemp;
    }
}