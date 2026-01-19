package io.concurrency.chapter02.exam01;

public class ThreadExample {
    public static void main(String[] args) {

        // Thread 상속
        MyThread myThread = new MyThread();
        myThread.start();


        // 익명 클래스
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " : 스레드 실행 중...");
            }
        });
        thread1.start();


        // 람다
        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " : 스레드 실행 중...");
        });
        thread2.start();


    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " : 스레드 실행 중...");
    }
}