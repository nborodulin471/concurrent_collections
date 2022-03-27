package task1;

import java.util.concurrent.*;

public class Main {
    public static final int COUNT_CALLS = 10;
    public static final int TIME_WORK_SPEC = 4000;
    public static final int TIME_WAIT_CALL = 2000;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Начало работы call-центра");
        final ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue();
        final ExecutorService threadPool = Executors.newFixedThreadPool(3);

        threadPool.submit(new ATS(queue));
        threadPool.submit(new Specialist(queue));
        threadPool.submit(new Specialist(queue));

        threadPool.awaitTermination(30, TimeUnit.SECONDS);
        threadPool.shutdown();
        System.out.println("Работа call-центра завершена");
    }

}
