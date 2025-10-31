package parallel;

import util.MyLogger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import static util.MyLogger.*;

public class ParallelMain5 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "3");
        System.out.println(ForkJoinPool.commonPool());

        ExecutorService requestPool = Executors.newFixedThreadPool(100);
        int nThreads = 3;
        for (int i = 1; i <= nThreads; i++) {
            String requestName = "request" + i;
            requestPool.submit(() -> logic(requestName));
            Thread.sleep(100);
        }
        requestPool.close();
    }

    private static void logic(String requestName) {
        log("[" + requestName + "] START");
        long startTime = System.currentTimeMillis();

        int sum = IntStream.rangeClosed(1, 4)
                .parallel()
                .map(i -> HeavyJob.heavyTask(i, requestName))
                .reduce(0, Integer::sum);

        long endTime = System.currentTimeMillis();
        log("[" + requestName + "] time: " + (endTime - startTime) + "ms, sum:" + sum);
    }
}
