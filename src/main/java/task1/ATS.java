package task1;

import java.util.concurrent.ConcurrentLinkedQueue;

import static task1.Main.*;

public class ATS implements Runnable {
    private ConcurrentLinkedQueue<String> queue;

    public ATS(ConcurrentLinkedQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public synchronized void run() {
        try {
            for (int i = 0; i < COUNT_CALLS; i++) {
                String msg = "тест" + i;
                queue.add("тест" + i);
                System.out.println("Поступил звонок с сообщением " + msg);
                Thread.sleep(TIME_WAIT_CALL);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
