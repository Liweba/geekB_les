public class ARunnable implements Runnable{

    @Override
    public void run() {
        synchronized (Main.mon) {
            try {
                for (int i = 0; i < Main.count; i++) {
                    while (Main.currentLetter != "A") {
                        Main.mon.wait();
                    }
                    System.out.print("A");
                    Main.currentLetter = "B";
                    Main.mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
