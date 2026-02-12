package io.concurrency.section4;

public class ThreadInterruptExample {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " 실행 중...");
                if (Thread.interrupted()) {
                    System.out.println("인터럽트 상태 초기화됐습니다.");
                    break;
                }
            }
            System.out.println("인트럽트 상태: " + Thread.currentThread().isInterrupted()); //false
            Thread.currentThread().interrupt();
            System.out.println("인트럽트 상태: " + Thread.currentThread().isInterrupted()); //true
        });

        thread.start();

        Thread.sleep(1000);

        thread.interrupt();

        System.out.println("인트럽트 상태: " + thread.isInterrupted()); //true
    }




}
