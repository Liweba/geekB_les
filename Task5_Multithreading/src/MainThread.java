public class MainThread extends Thread
{
    float [] arr;
    long startTime;

    public MainThread(float[] arr, long startTime) {
        this.arr = arr;
        this.startTime = startTime;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    public float[] getArr() {
        return arr;
    }

    public long getStartTime() {
        return startTime;
    }
}