package io.concurrency.section4;

import org.junit.jupiter.api.Test;

public class ThreadPriorityExampleTest {
    @Test
    void thread_priority() {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 실행 중...");
        });

        System.out.println("우선순위=" + thread.getPriority());

        thread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("우선순위=" + thread.getPriority());
    }

}
