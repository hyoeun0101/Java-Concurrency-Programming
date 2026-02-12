package io.concurrency.section5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ThreadStopExampleTest {

    @Test
    @DisplayName("flag variable을 사용하여 스레드 중단하기.")
    void flag_variable_example() {

    }
    static class Worker implements Runnable {

        private boolean running = true;

        @Override
        public void run() {
            while(running) {
                System.out.println(Thread.currentThread().getName() + " 실행 중...");
            }
        }
    }
}
