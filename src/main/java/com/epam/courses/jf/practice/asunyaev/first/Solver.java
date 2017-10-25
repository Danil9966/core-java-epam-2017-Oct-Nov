package com.epam.courses.jf.practice.asunyaev.first;

import com.epam.courses.jf.practice.common.first.ISolver;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Solver implements ISolver {

    public static void main(String[] args) {
        Solver solver = new Solver();
        solver.task4();
    }

    @Override
    public void task1() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int currentLength = 0;
        String currentString;
        int maxLength = 0;
        int minLength = 80;
        String maxString = "";
        String minString = "";

        scan.nextLine();

        for (int i = 0; i < N; i++) {
            currentString = scan.nextLine();
            currentLength = currentString.length();

            if (currentLength >= maxLength) {
                maxLength = currentLength;
                maxString = currentString;
            }

            if (currentLength <= minLength) {
                minLength = currentLength;
                minString = currentString;
            }
        }

        System.out.printf("MIN (%d): \"%s\"%n", minLength, minString);
        System.out.printf("MAX (%d): \"%s\"%n", maxLength, maxString);
    }

    @Override
    public void task2() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        HashMap<Integer, String> lines = new HashMap<>();
        int[] lengths = new int[N];
        String currentString;

        scan.nextLine();

        for (int i = 0; i < N; i++) {
            currentString = scan.nextLine();
            lengths[i] = currentString.length();
            lines.put(lengths[i], currentString);
        }

        Arrays.sort(lengths);

        for (int i = 0; i < N; i++) {
            lines.get(lengths[i]);
            System.out.printf("(%d): \"%s\"%n", lengths[i], lines.get(lengths[i]));
        }
    }

    @Override
    public void task3() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int averageLength = 0;
        HashMap<Integer, String> lines = new HashMap<>();
        int[] lengths = new int[N];
        String currentString;

        scan.nextLine();

        for (int i = 0; i < N; i++) {
            currentString  = scan.nextLine();
            lengths[i] = currentString.length();
            lines.put(lengths[i], currentString);
        }

        averageLength = (int) Arrays.stream(lengths).average().getAsDouble();
        System.out.printf("AVERAGE (%d)%n", averageLength);

        for (int i = 0; i < N; i++) {
            if (lengths[i] < averageLength) {
                System.out.printf("(%d): \"%s\"%n", lengths[i], lines.get(lengths[i]));
            }
        }
    }

    @Override
    public void task4() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();
        HashMap<String, HashSet> words = new HashMap<>();
        String currentWord;
        String maxWord = "";
        int maxLength = 80;

        for (int i = 0; i < N; i++) {
            currentWord = scan.next();
            HashSet letters = new HashSet();
            for (int j = 0; j < currentWord.length(); j++) {
                letters.add(currentWord.charAt(j));
            }
            words.put(currentWord, letters);
        }

        for(Map.Entry<String, HashSet> entry : words.entrySet()) {
            int currentLength = entry.getValue().size();
            if (currentLength < maxLength) {
                maxLength = currentLength;
                maxWord = entry.getKey();
            }
        }
        System.out.println(maxWord);
    }

    @Override
    public void task9() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int k = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(k + "\t");
                k++;
            }
            System.out.println();
        }
    }

    @Override
    public void task11() {
        Scanner scan = new Scanner(System.in);
        int monthNumber = 0;
        String string = scan.nextLine();

        try {
            monthNumber = Integer.valueOf(string);
            if (monthNumber <= 1 && monthNumber >= 12) {
                System.out.println("INCORRECT INPUT DATA");
            }
            switch (monthNumber) {
                case 1:
                    System.out.println("January");
                    break;
                case 2:
                    System.out.println("February");
                    break;
                case 3:
                    System.out.println("March");
                    break;
                case 4:
                    System.out.println("April");
                    break;
                case 5:
                    System.out.println("May");
                    break;
                case 6:
                    System.out.println("June");
                    break;
                case 7:
                    System.out.println("July");
                    break;
                case 8:
                    System.out.println("August");
                    break;
                case 9:
                    System.out.println("September");
                    break;
                case 10:
                    System.out.println("October");
                    break;
                case 11:
                    System.out.println("November");
                    break;
                case 12:
                    System.out.println("December");
                    break;
            }
        } catch(NumberFormatException e) {
            System.out.println("INCORRECT INPUT DATA");
        }
    }

    @Override
    public void task12() {
        Scanner scanner = new Scanner(System.in);
        final int k = scanner.nextInt();
        final int DIMENSION = scanner.nextInt();
        int[][] matrix = readMatrix(scanner, DIMENSION);
        Arrays.sort(matrix, new Comparator<int[]>() {
            @Override
            public int compare(final int[] row1, final int[] row2) {
                final Integer value1 = row1[k];
                final Integer value2 = row2[k];
                return value1.compareTo(value2);
            }
        });
        printMatrix(matrix, DIMENSION);
    }

    @Override
    public void task13() {
        Scanner scanner = new Scanner(System.in);
        final int shift = scanner.nextInt();
        final int DIMENSION = scanner.nextInt();
        int[][] matrix = readMatrix(scanner, DIMENSION);
        int newIndex = 0;
        int[][] shiftedMatrix = new int[DIMENSION][DIMENSION];

        if (shift == 0) {
            printMatrix(matrix, DIMENSION);
        } else {
            for (int index = 0; index < DIMENSION; index++) {
                newIndex = index + shift >= 0
                            ? (index + shift) % DIMENSION
                            : (index + shift) + DIMENSION;
                copyRow(matrix, index, shiftedMatrix, newIndex);
            }
        }

        printMatrix(shiftedMatrix, DIMENSION);

    }

    private void copyRow(int[][] fromMatrix, int rowIndex1, int[][] toMatrix, int rowIndex2) {
        for (int i = 0; i < fromMatrix.length; i++) {
            toMatrix[rowIndex2][i] = fromMatrix[rowIndex1][i];
        }
    }

    private int[][] readMatrix(Scanner scanner, int dimension) {
        int[][] matrix = new int[dimension][dimension];
        for (int row = 0; row < dimension; ++row) {
            for (int col = 0; col < dimension; ++col) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private void printMatrix(int[][] matrix, int dimension) {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

}