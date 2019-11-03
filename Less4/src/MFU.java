public class MFU {
    Object mfuScan = new Object();
    Object mfuPrint = new Object();

    public void mfuPrint(String fileName, int page) {
        synchronized (mfuPrint) {
            System.out.println("Start print - fileName: " + fileName);
            for (int i = 0; i < page; i++) {
                System.out.println("p => " + i);
            }
            System.out.println("End print - fileName: " + fileName);
        }

    }

    public void mfuScan(String fileName, int page) {
        synchronized (mfuScan) {
            System.out.println("Start scan - fileName: " + fileName);
            for (int i = 0; i < page; i++) {
                System.out.println("s => " + i);
            }
            System.out.println("End scan - fileName: " + fileName);
        }
    }
}
