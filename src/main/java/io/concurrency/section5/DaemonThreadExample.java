package io.concurrency.section5;

public class DaemonThreadExample {
    public static void main(String[] args) {
        Thread userThread = new Thread(() -> {
            try {
                System.out.println("사용자 스레드 실행 중..");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("사용자 스레드 실행 종료");
        });


        Thread daemonThread = new Thread(() -> {
            while (true){
                try {
                    System.out.println("데몬 스레드 실행 중..");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("데몬 스레드 실행 종료");
            }
        });
        daemonThread.setDaemon(true);

        userThread.start();
        daemonThread.start();

        System.out.println("메인 스레드 실행 종료.");


    }
}
