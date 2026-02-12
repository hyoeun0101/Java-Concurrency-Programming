package io.concurrency.section4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ThreadJoinExampleTest {

    @Test
    @DisplayName("thread1 실행이 끝난 다음 thread2가 실행된다.")
    void thread_join_example() throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "실행 중...");
            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + "실행 종료.");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "실행 중...");
            try {
                // 내부적으로 wait을 호출. thread1의 실행이 끝나면 notify가 호출됨.
                thread1.join();
                System.out.println(thread1.getName() + "이 끝나야 " + Thread.currentThread().getName() + "이 실행된다.");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();

        thread2.join();
    }
}