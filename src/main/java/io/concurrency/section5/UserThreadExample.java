package io.concurrency.section5;

public class UserThreadExample {
    public static void main(String[] args) throws InterruptedException {
        // 사용자 스레드 1 생성
        Thread userThread1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + " 실행 중...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " 실행 종료");
        });

        // 사용자 스레드 2 생성
        Thread userThread2 = new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                System.out.println(Thread.currentThread().getName() + " 실행 중...");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " 실행 종료");
        });

        userThread1.start();
        userThread2.start();

        System.out.println(Thread.currentThread().getName() + " 실행 종료");

        // 모든 사용자 스레드가 종료되어야 어플리케이션이 종료된다.

    }


}
