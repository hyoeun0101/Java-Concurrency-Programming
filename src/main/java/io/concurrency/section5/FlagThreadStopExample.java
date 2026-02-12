package io.concurrency.section5;

public class FlagThreadStopExample {
    private static volatile boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (running) {
                System.out.println(Thread.currentThread().getName() + " 실행 중...");
            }
            System.out.println("종료!");
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            running = false;
        }).start();
    }
}
