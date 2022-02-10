package task1;

import java.util.concurrent.*;

public class Main {
    public static final int COUNT_CALLS = 10;
    public static final int TIME_WORK_SPEC = 4000;
    public static final int TIME_WAIT_CALL = 2000;
    public static ConcurrentLinkedQueue<String> CONCURRENT_LINKED_QUEUE = new ConcurrentLinkedQueue();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Начало работы call-центра");
        final ExecutorService threadPool = Executors.newFixedThreadPool(3);

        threadPool.submit(new ATS());
        threadPool.submit(new Specialist());
        threadPool.submit(new Specialist());

        threadPool.awaitTermination(30, TimeUnit.SECONDS);
        threadPool.shutdown();
        System.out.println("Работа call-центра завершена");
    }

}
