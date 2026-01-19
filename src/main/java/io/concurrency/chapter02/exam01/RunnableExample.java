package io.concurrency.chapter02.exam01;

public class RunnableExample {
    public static void main(String[] args) {
        // Runnable 구현
        MyRunnalbe myRunnalbe = new MyRunnalbe();
        Thread thread1 = new Thread(myRunnalbe);
        thread1.start();
    }
}


class MyRunnalbe implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " : 스레드 실행 중...");
    }
}