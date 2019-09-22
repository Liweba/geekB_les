package task2.exception.helper;

import task2.exception.MyArrayDataException;
import task2.exception.MyArraySizeException;

public class HelperMyArrayException {

    private static int defaultArrSize;

    public HelperMyArrayException(int defaultArrSize) {
        this.defaultArrSize = defaultArrSize;
    }

    public static void startAllExceptions(String[][]... arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println("\nПроверяется массив: " + (i+1)+"/"+ arr.length +"");
            try {
                getMyArraySizeException(arr[i], defaultArrSize);
            } catch (MyArraySizeException e){
                e.printStackTrace();
                continue;
            }
            try {
                System.out.println("\n>>Результат расчета: " + getMyArrayDataException(arr[i]));
            } catch (MyArrayDataException e){
                e.printStackTrace();
            }
        }
    }

    public static void getMyArraySizeException(String[][] arr, int defaultArrSize) throws MyArraySizeException{
        String errorText = "Массив должен быть = " + defaultArrSize + "x" + defaultArrSize;
        for (int i = 0; i < arr.length; i++) {
            if (arr.length != defaultArrSize || arr[i].length != defaultArrSize) throw new MyArraySizeException(errorText, defaultArrSize);
        }
    }

    public static int getMyArrayDataException(String[][] arr) throws MyArrayDataException{
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Преобразование не удалось, проверьте ячейку [" + i + "]" + "[" + j + "]");
                }
            }
        }
        return sum;
    }
}
