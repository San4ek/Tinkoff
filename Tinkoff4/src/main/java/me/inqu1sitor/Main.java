package me.inqu1sitor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        int size=in.nextInt();
        char turn=in.next().charAt(0);

        int[][] matrix=new int[size][size];

        for (int i=0; i<size; ++i) {
            for (int j=0; j<size; ++j) {
                matrix[i][j]=in.nextInt();
            }
        }

        in.close();

        if (size==1) {
            System.out.println(0);
            System.exit(0);
        }

        StringBuilder actions=new StringBuilder();

        int counter=0;

        switch (turn) {
            case 'L' -> counter=turnLeft(matrix,size,actions);
            case 'R' -> counter=turnRight(matrix,size,actions);
        }

        System.out.println(counter);
        System.out.print(actions);
    }

    public static int turnLeft(int[][] matrix, int size, StringBuilder actions) {
        int lowBorder=size/2;

        int counter=0;

        for (int j=0; j<lowBorder; ++j) {
            for (int i = j; i < size-1-j; ++i) {
                if (matrix[j][i] != matrix[i][size - 1-j]) {
                    int temp = matrix[j][i];
                    matrix[j][i] = matrix[i][size - 1-j];
                    matrix[i][size - 1-j] = temp;
                    actions.append(j).append(" ").append(i).append(" ").append(i).append(" ").append(size - 1-j).append('\n');
                    ++counter;
                }
                if (matrix[i][size - 1-j] != matrix[size - 1-j][size - 1 - i]) {
                    int temp = matrix[i][size - 1-j];
                    matrix[i][size - 1-j] = matrix[size - 1-j][size - 1 - i];
                    matrix[size - 1-j][size - 1 - i] = temp;
                    actions.append(i).append(" ").append(size - 1-j).append(" ").append(size - 1-j).append(" ").append(size - 1 - i).append('\n');
                    ++counter;
                }
                if (matrix[size - 1-j][size - 1 - i] != matrix[size - 1 - i][j]) {
                    int temp = matrix[size - 1-j][size - 1 - i];
                    matrix[size - 1-j][size - 1 - i] = matrix[size - 1 - i][j];
                    matrix[size - 1 - i][j] = temp;
                    actions.append(size - 1).append(" ").append(size - 1 - i).append(" ").append(size - 1 - i).append(" ").append(j).append('\n');
                    ++counter;
                }
            }
        }

        return counter;
    }

    public static int turnRight(int[][] matrix, int size, StringBuilder actions) {
        int lowBorder=size/2;

        int counter=0;

        for (int j=0; j<lowBorder; ++j) {
            for (int i = j; i < size-1-j; ++i) {
                if (matrix[i][j] != matrix[size - 1-j][i]) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[size - 1-j][i];
                    matrix[size - 1-j][i] = temp;
                    actions.append(i).append(" ").append(j).append(" ").append(size-i-j).append(" ").append(i).append('\n');
                    ++counter;
                }
                if (matrix[size - 1-j][i] != matrix[size - 1 - i][size - 1-j]) {
                    int temp = matrix[size - 1-j][i];
                    matrix[size - 1-j][i] = matrix[size - 1 - i][size - 1-j];
                    matrix[size - 1 - i][size - 1-j] = temp;
                    actions.append(size-i-j).append(" ").append(i).append(" ").append(size - 1-i).append(" ").append(size - 1 - j).append('\n');
                    ++counter;
                }
                if (matrix[size - 1-i][size - 1 - j] != matrix[j][size - 1 - i]) {
                    int temp = matrix[size - 1-i][size - 1 - j];
                    matrix[size - 1-i][size - 1 - j] = matrix[j][size - 1 - i];
                    matrix[j][size - 1 - i] = temp;
                    actions.append(size - 1-i).append(" ").append(size - 1 - j).append(" ").append(j).append(" ").append(size-1-i).append('\n');
                    ++counter;
                }
            }
        }

        return counter;
    }
}