public class BRunnable implements Runnable{

    @Override
    public void run() {
        synchronized (Main.mon) {
            try {
                for (int i = 0; i < Main.count; i++) {
                    while (Main.currentLetter != "B") {
                        Main.mon.wait();
                    }
                    System.out.print("B");
                    Main.currentLetter = "C";
                    Main.mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
