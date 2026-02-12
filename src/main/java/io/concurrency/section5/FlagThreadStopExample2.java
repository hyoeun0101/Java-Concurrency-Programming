package io.concurrency.section5;

import java.util.concurrent.atomic.AtomicBoolean;

public class FlagThreadStopExample2 {
    private static AtomicBoolean running = new AtomicBoolean(true);

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (running.get()) {
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
            running.set(false);
        }).start();
    }
}
