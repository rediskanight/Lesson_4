//4.1
package com.geekbrains;
//ctrl + alt + L - формат кода

import java.util.Random;
import java.util.Scanner;

public class Java1_Lesson4 {
    private final static int SIZE = 3;
    private final static int DOTS_TO_WIN = 3;
    private final static char DOT_EMPTY = '.';
    private final static char DOT_X = 'X';
    private final static char DOT_0 = '0';
    private static char[][] MAP;
    private final static Scanner SCANNER = new Scanner(System.in);
    private final static Random RANDOM = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanturn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил Человек");
                break;
            }
            if (isMApFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_0)) {
                System.out.println("победил ИИ");
                break;
            }
            if (isMApFull()) {
                System.out.println("ничья");
                break;
            }

        }
        System.out.println("Игра окончена");
    }

    private static boolean checkWin(char symbol) {
        for (int i = 0; i < SIZE; i++) {
            if (MAP[i][0] == symbol && MAP[i][1] == symbol && MAP[i][2] == symbol)
                return true;
        }
        for (int i = 0; i < SIZE; i++) {
            if (MAP[0][i] == symbol && MAP[1][i] == symbol && MAP[2][i] == symbol)
                return true;
        }
        if (MAP[1][1] == symbol && (MAP[2][2] == symbol && MAP[0][0] == symbol || MAP[2][0] == symbol && MAP[0][2] == symbol))
            return true;
        return false;
    }

    private static boolean isMApFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (MAP[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void aiTurn() {
        int x, y;
        do {
            x = RANDOM.nextInt(SIZE);
            y = RANDOM.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер сходил в точку " + (x + 1) + " " + (y + 1));
        MAP[y][x] = DOT_0;
    }

    private static void humanturn() {
        int x, y;
        do {
            System.out.println("Введите Координаты в формате X и Y");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellValid(x, y));
        MAP[y][x] = DOT_X;
    }

    private static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y > SIZE)
            return false;

        if (MAP[y][x] == DOT_EMPTY)
            return true;
        return false;

    }

    public static void initMap() {
        MAP = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }

        }

    }

    private static void printMap() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + " ");
            }
            System.out.println();

        }
        System.out.println();
    }


}