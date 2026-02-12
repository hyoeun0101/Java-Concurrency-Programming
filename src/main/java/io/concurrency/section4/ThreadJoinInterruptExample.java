package io.concurrency.section4;

public class ThreadJoinInterruptExample {
    public static void main(String[] args) {

        Thread mainThread = Thread.currentThread();

        Thread thread1 = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " 실행 중...(" +i + ")");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " 인터럽트 발생");
                mainThread.interrupt();
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 실행 중...");
            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + "에서 " + mainThread.getName() + " interrupt() 호출");
                mainThread.interrupt();
//                System.out.println(Thread.currentThread().getName() + "에서 " + thread1.getName() + " interrupt() 호출");
//                thread1.interrupt();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " 인터럽트 발생");
            }
        });

        thread2.start();

        try {
            thread1.join();
            System.out.println(thread1.getName() + "이 끝나야 " + Thread.currentThread().getName() + "이 실행된다.");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " 인터럽트 발생");
        }
    }

}
