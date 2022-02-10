package task1;

import static task1.Main.CONCURRENT_LINKED_QUEUE;
import static task1.Main.TIME_WORK_SPEC;

public class Specialist implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(TIME_WORK_SPEC);
                String acceptedCall = CONCURRENT_LINKED_QUEUE.poll();
                if (acceptedCall == null){
                    System.out.println("Специалисту "+ Thread.currentThread().getName() +" нечего обрабатывать");
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
