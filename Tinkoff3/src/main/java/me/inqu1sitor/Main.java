package me.inqu1sitor;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int myCounter;
    static int counter;

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        int raws=in.nextInt();
        in.nextLine();

        String[] myArr=new String[raws];

        int i=0;

        for (char ch : in.nextLine().toCharArray()) {
            myArr[i++]= String.valueOf(ch);
        }
        in.close();

        String[] arr=myArr.clone();

        quickSort(myArr,0,raws-1);
        QuickSort(arr,0,raws-1);

        /*for (String str : myArr) {
            String[] strParts=str.split("/");

            if (strParts.length==1) {
                System.out.println(strParts[0]);
            } else {
                for (int i=0; i<strParts.length-1; ++i) {
                    System.out.print("  ");
                }
                System.out.println(strParts[strParts.length-1]);
            }
        }*/

        System.out.println(Arrays.toString(myArr));
        System.out.println("myCounter: "+ myCounter);
        System.out.println(Arrays.toString(arr));
        System.out.println("counter: "+counter);
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
        myCounter +=3;

        int i = begin-1;

        for (int j = begin; j < end; ++j) {
            ++myCounter;

            if (arr[j].compareTo(pivot) < 0) {
                i++;
                ++myCounter;

                if (i!=j) {
                    swap(arr, i, j);
                    myCounter +=3;
                }
            }
        }

        swap(arr,i+1,end);
        counter+=3;

        return i+1;
    }

    public static void QuickSort(String[] array, int low, int high) {
        if (array.length == 0)
            return;//завершить выполнение, если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        String opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i].compareTo(opora)<0) {
                ++counter;
                i++;
            }

            while (array[j].compareTo(opora)>0) {
                ++counter;
                j--;
            }

            if (i <= j) {//меняем местами
                swap(array,i,j);
                counter +=5;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            QuickSort(array, low, j);

        if (high > i)
            QuickSort(array, i, high);
    }

    public static void swap(String[] arr, int i, int j) {
        String swapTemp = arr[i];
        arr[i] = arr[j];
        arr[j] = swapTemp;
    }
}