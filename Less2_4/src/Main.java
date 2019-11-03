public class Main {
    public static final int count = 5;
    public static volatile String currentLetter = "A";
    public static final Object mon = new Object();

    public static void main(String[] args) {
        /**Старт задания 4.2*/
        MFU mfu = new MFU();
        new Thread(new Runnable() {
            @Override
            public void run() {mfu.mfuPrint("PrintOne", 3);}
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {mfu.mfuScan("ScanOne", 9);}
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {mfu.mfuPrint("PrintTwo", 4);}
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {mfu.mfuScan("ScanTwo", 2);}
        }).start();
        /**Конец задания 4.2*/

        /**Старт задания 4.1*/
//        new Thread(new ARunnable()).start();
//        new Thread(new BRunnable()).start();
//        new Thread(new CRunnable()).start();
        /**Конец задания 4.1*/

    }
}
