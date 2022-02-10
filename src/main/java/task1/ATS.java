package task1;

import static task1.Main.*;

public class ATS implements Runnable {

    @Override
    public synchronized void run() {
        try {
            for (int i = 0; i < COUNT_CALLS; i++) {
                String msg = "тест" + i;
                CONCURRENT_LINKED_QUEUE.add("тест" + i);
                System.out.println("Поступил звонок с сообщением " + msg);
                Thread.sleep(TIME_WAIT_CALL);
            }
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
