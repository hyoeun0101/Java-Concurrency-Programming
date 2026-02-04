package io.concurrency.chapter03.exam01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ThreadSleepExampleTest {

    @Nested
    @DisplayName("Thread sleep 예제 코드")
    class ThreadSleepExample {
        @Test
        public void thread_sleep_for3Seconds() throws InterruptedException {
            long start = System.currentTimeMillis();
            // 3초 동안 대기 상태로 전환.
            Thread.sleep(3000);

            long end = System.currentTimeMillis();
            System.out.println("3초 이상 sleep이 되어야 함. " + (end-start));
            assertTrue(end-start >= 3000);
        }

        @Test
        public void sleep_interrupted_throwInterruptedException() throws InterruptedException {
            Thread sleeper = new Thread(() -> {
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    System.out.println("인터럽트 발생");

                    // InterruptedException이 발생하면 interrupt flag는 보통 clear된다.
                    // 실무에서는 상태를 보존하기 위해 다시 interrupt 걸어두는 게 관례.
                    Thread.currentThread().interrupt();

                    boolean interrupted = Thread.currentThread().isInterrupted();
                    System.out.println("interrupted = " + interrupted);
                    assertTrue(interrupted);
                }
            }, "thread-sleeper");

            sleeper.start();

            Thread.sleep(100);

            sleeper.interrupt();

        }

    }



}