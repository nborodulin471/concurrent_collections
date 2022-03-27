package task1;

import java.util.concurrent.ConcurrentLinkedQueue;

import static task1.Main.TIME_WORK_SPEC;

public class Specialist implements Runnable {
    private ConcurrentLinkedQueue<String> queue;

    public Specialist(ConcurrentLinkedQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(TIME_WORK_SPEC);
                String acceptedCall = queue.poll();
                if (acceptedCall == null) {
                    System.out.println("Специалисту " + Thread.currentThread().getName() + " нечего обрабатывать");
                    break;
                }
                System.out.println(String.format("Специалист %s обработал запрос %s",
                        Thread.currentThread().getName(), acceptedCall));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
