package io.concurrency.chapter01.exam01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ConcurrencyParallelismExamTest {
    ConcurrencyParallelismExam example = new ConcurrencyParallelismExam();
    @Test
    @DisplayName("CPU 코어 개수: n개, 작업 개수 : n개 => 순차 처리 작업 시간은 (작업처리시간 * n)초")
    public void test_stream() {
        int cpuCore = Runtime.getRuntime().availableProcessors();
        int workCnt = cpuCore;
        long workTime = 500;

        System.out.println("CPU 코어 개수 : " + cpuCore);
        System.out.println("작업 개수: " + workCnt);

        List<Integer> data = example.createData(workCnt);

        long st = System.currentTimeMillis();
        example.doSum(data, workTime);
        long et = System.currentTimeMillis();

        long time = example.printGetTime(st, et);

        assertThat(time).isGreaterThanOrEqualTo(workCnt * workTime);
        // 한 개의 코어가 16개의 작업을 처리함 => 작업 1개 처리 시간(500ms) * 16 = 8초
    }

    @Test
    @DisplayName("CPU 코어 개수: n개, 작업 개수: n개 => 병렬 처리 작업 시간은 (작업처리시간)초")
    public void test_stream_parallelism() {
        int cpuCore = Runtime.getRuntime().availableProcessors();
        int workCnt = cpuCore;
        long workTime = 500;

        System.out.println("CPU 코어 개수 : " + cpuCore);
        System.out.println("작업 개수: " + workCnt);

        List<Integer> data = example.createData(workCnt);

        long st = System.currentTimeMillis();
        example.doSumParallel(data, workTime);
        long et = System.currentTimeMillis();

        long time = example.printGetTime(st, et);
        assertThat(time).isGreaterThanOrEqualTo(workTime);
        // 한 개의 코어가 1개의 작업을 처리함 => 작업 1개 처리 시간(500ms) * 1 = 0.5초

    }


    @Test
    @DisplayName("CPU 코어 개수: n개, 작업 개수: n * 2개 => 병렬 처리 작업 시간은 (작업처리시간 * 2)초")
    public void test_stream_parallelism2() {
        int cpuCore = Runtime.getRuntime().availableProcessors();
        int workCnt = cpuCore * 2;
        long workTime = 500;

        System.out.println("CPU 코어 개수 : " + cpuCore);
        System.out.println("작업 개수: " + workCnt);

        List<Integer> data = example.createData(workCnt);

        long st = System.currentTimeMillis();
        example.doSumParallel(data, workTime);
        long et = System.currentTimeMillis();

        long time = example.printGetTime(st, et);

        assertThat(time).isGreaterThanOrEqualTo(workTime * 2);
        // 한 개의 코어가 2개의 작업을 처리함 => 작업 1개 처리 시간(500ms) * 2 = 1초
    }

    @Test
    @DisplayName("CPU 코어 개수: n개, 작업 개수: n + 1개 => 병렬 처리 작업 시간은 (작업처리시간 * 2)초")
    public void test_stream_parallelism3() {
        int cpuCore = Runtime.getRuntime().availableProcessors();
        int workCnt = cpuCore + 1;
        long workTime = 500;

        System.out.println("CPU 코어 개수 : " + cpuCore);
        System.out.println("작업 개수: " + workCnt);

        List<Integer> data = example.createData(workCnt);

        long st = System.currentTimeMillis();
        example.doSumParallel(data, workTime);
        long et = System.currentTimeMillis();

        long time = example.printGetTime(st, et);

        assertThat(time).isGreaterThanOrEqualTo(workTime * 2);
        // 한 개의 코어가 2개의 작업을 처리함 => 작업 1개 처리 시간(500ms) * 2 = 1초

        // 결론 : 작업의 수가 CPU 코어 개수보다 조금 많으면 병렬성의 이점이 줄어든다.!!
    }
}