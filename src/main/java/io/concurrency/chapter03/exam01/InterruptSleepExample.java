package io.concurrency.chapter03.exam01;

public class InterruptSleepExample {
    public static void main(String[] args) throws InterruptedException {

        Thread sleepingThread = new Thread(() -> {
            try {
                Thread.sleep(20000);

            } catch (InterruptedException e) {
                // 2) InterruptedException 예외 발생
                System.out.println("interrupt!!");
            }
        });

        sleepingThread.start();

        Thread.sleep(1000);

        // 1) interrupt() 발생.
        sleepingThread.interrupt();
    }
}
