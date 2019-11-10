package dopDZ;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x = 10, y = 5;
        int[][] arr = new int[x][y];
        int row = 0, col = 0, dataX = 1, dy = 0, status = 0, position = y;

        for (int i = 0; i < x*y; i++) { //общее кол-во ячеек
            arr[row][col] = i + 1; // Заполнение массива
            if (--position == 0) { //Поверям счестчик ходов и каждый раз уменьшаем
                position = y * (status % 2) + x * ((status + 1) % 2) - (status / 2 - 1) - 2;
                int saveDx = dataX;
                dataX = -dy;
                dy = saveDx;
                status++; //Таким образом завершатся махинации с счетчиком ходов
            }
            col += dataX;
            row += dy;
        }

/** Обычный вывод из массива*/
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
}