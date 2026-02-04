package io.concurrency.section5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ThreadExceptionExampleTest {
    @Test
    @DisplayName("스레드 내부에서 발생한 예외는 외부에서 잡을 수 없다.")
    void thread_cannot_catch_exception() {
        try {
            new Thread(() -> {
                throw new RuntimeException("스레드 예외 발생");
            }).start();
        } catch (Exception e) {
            //출력되지 않음.
            System.out.println("스레드에서 예외가 발생했습니다: " + e);
        }
    }

    @Test
    void set_UncaughtExceptionHandler_for_all_threads() {
        //모든 스레드의 예외를 처리할 핸들러 지정.
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                // 스레드 내부에서 예외가 발생하면 호출됨.
                System.out.println(t.getName() + "에서 예외 발생: " + e);
            }
        });

        Thread thread1 = new Thread(() -> {
            throw new RuntimeException("예외 발생[1]");
        });

        Thread thread2 = new Thread(() -> {
            throw new RuntimeException("예외 발생[2]");
        });

        thread1.start();
        thread2.start();
    }

    @Test
    void set_UncaughtExceptionHandler_for_each_threads() {
        Thread thread1 = new Thread(() -> {
            throw new RuntimeException("예외 발생[1]");
        });
        thread1.setUncaughtExceptionHandler((t, e)
                -> System.out.println(t.getName() + "에서 예외 발생함[1]: " + e));
        thread1.start();

        Thread thread2 = new Thread(() -> {
            throw new RuntimeException("예외 발생[2]");
        });
        thread2.setUncaughtExceptionHandler((t, e)
                -> System.out.println(t.getName() + "에서 예외 발생함[2]:" + e));
        thread2.start();
    }

}