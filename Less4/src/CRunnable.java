public class CRunnable implements Runnable{

    @Override
    public void run() {
        synchronized (Main.mon) {
            try {
                for (int i = 0; i < Main.count; i++) {
                    while (Main.currentLetter != "C") {
                        Main.mon.wait();
                    }
                    System.out.print("C");
                    Main.currentLetter = "A";
                    Main.mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
