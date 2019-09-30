import java.util.Arrays;

public class Main {
    static final int size = 10000000;
    static final int h = size / 2;
    public static void main(String[] args) {
        float[] arr = new float[size];
        for (int i = 0; i < size; i++)arr[i] = 1;//2) Заполняют этот массив единицами;
        Method1(arr);
        Method2(arr);
    }
    public static void Method1(float[] arr){ //Первый просто бежит по массиву и вычисляет значения.
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время обработки в основном потоке: " + (System.currentTimeMillis() - startTime) + "ms. Потрачено на: " + arr.length + " строк \n ");
    }
    public static void Method2(float[] arr){
        float[] a1 = new float[h], a2 = new float[h];

        long startTimeSplitting = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        System.out.println("На разбивку ушло: "+(System.currentTimeMillis() - startTimeSplitting) + "ms");

        MainThread Test1 =  new MainThread(a1, System.currentTimeMillis());
        MainThread Test2 =  new MainThread(a2, System.currentTimeMillis());
        Test1.start();
        Test2.start();
        try {
            Test1.join();
            Test2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Время обработки в 1 потоке: "+(System.currentTimeMillis() - Test1.getStartTime()) + "ms. Потрачено на: " + Test1.getArr().length + " строк");
        System.out.println("Время обработки в 2 потоке: "+(System.currentTimeMillis() - Test2.getStartTime()) + "ms. Потрачено на: " + Test2.getArr().length + " строк");

        long startTimeSplice = System.currentTimeMillis();
        System.arraycopy(Test1.getArr(), 0, arr, 0, h); //Пример обратной склейки:
        System.arraycopy(Test2.getArr(), 0, arr, h, h); //Пример обратной склейки:
        System.out.println("Время склейки: " + (System.currentTimeMillis() - startTimeSplice) + "ms");

        System.out.println("Общее время на все работы: " + (System.currentTimeMillis() - startTimeSplitting) + "ms");
    }
}
