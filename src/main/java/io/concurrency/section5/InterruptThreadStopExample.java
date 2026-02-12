package io.concurrency.section5;

public class InterruptThreadStopExample {

    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            while (!Thread.interrupted()) {
                System.out.println(Thread.currentThread().getName() + " 실행 중...");
            }
            System.out.println(Thread.currentThread().getName() + " 실행 종료.");
            System.out.println("인터럽트 상태 : " + Thread.currentThread().isInterrupted());
        });

        worker.start();

        Thread.sleep(2000);

        worker.interrupt();
    }
}

