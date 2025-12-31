package io.concurrency.chapter01.exam01;

import java.util.ArrayList;
import java.util.List;

public class ConcurrencyParallelismExam {

    public List<Integer> createData(int num) {
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            data.add(num);
        }
        return data;
    }

    public long doSumParallel(List<Integer> data, long workTime) {
        return data.parallelStream().mapToLong(i -> {
            try {
                Thread.sleep(workTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return (long) i * i;
        }).sum();
    }

    public long doSum(List<Integer> data, long workTime) {
        return data.stream().mapToLong(i -> {
            try {
                Thread.sleep(workTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return (long) i * i;
        }).sum();
    }

    public long printGetTime(long startTime, long endTime) {
        long time = endTime - startTime;
        System.out.println("처리 시간 : " + time + "ms");
        return time;
    }

}
