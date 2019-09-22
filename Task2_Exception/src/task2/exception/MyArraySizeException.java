package task2.exception;

public class MyArraySizeException extends Exception {
    private int defaultArrSize;

    public int getNumber() {
        return defaultArrSize;
    }

    public MyArraySizeException(String msg, int defaultArrSize) {
        super(msg);
        this.defaultArrSize = defaultArrSize;
    }
}