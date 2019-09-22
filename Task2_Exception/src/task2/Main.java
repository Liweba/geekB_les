package task2;

import task2.exception.helper.HelperMyArrayException;

public class Main {
    private static int defaultArrSize = 4;

    public static void main(String[] args) {
        String[][] arr = {
                {"1","1","1","1"},
                {"1","1","1","1"},
                {"1","1","1","1"},
                {"1","1","1","1"}
        };
        String[][] arr2 = {
                {"1","1","1"},
                {"1","1","1","1"},
                {"1","1","1","1"},
                {"1","1","1","1"}
        };
        String[][] arr3 = {
                {"1","1","1","1p"},
                {"1","1","1","1"},
                {"1","1","1","1"},
                {"1","1","1","1"}
        };
        new HelperMyArrayException(defaultArrSize);
        HelperMyArrayException.startAllExceptions(arr, arr2, arr3);
    }




}
