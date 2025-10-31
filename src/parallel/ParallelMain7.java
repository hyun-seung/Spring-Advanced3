package parallel;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

import static util.MyLogger.log;

public class ParallelMain7 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "3");
        System.out.println(ForkJoinPool.commonPool());

        ExecutorService requestPool = Executors.newFixedThreadPool(100);

        ExecutorService logicPool = Executors.newFixedThreadPool(400);

        int nThreads = 3;
        for (int i = 1; i <= nThreads; i++) {
            String requestName = "request" + i;
            requestPool.submit(() -> logic(requestName, logicPool));
            Thread.sleep(100);
        }
        requestPool.close();
        logicPool.close();
    }

    private static void logic(String requestName, ExecutorService es) {
        log("[" + requestName + "] START");
        long startTime = System.currentTimeMillis();

        List<Future<Integer>> futures = IntStream.range(1, 4)
                .mapToObj(i -> es.submit(() -> HeavyJob.heavyTask(i, requestName)))
                .toList();

        int sum = futures.stream()
                .mapToInt(f -> {
                    try {
                        return f.get();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .sum();

        long endTime = System.currentTimeMillis();
        log("[" + requestName + "] time: " + (endTime - startTime) + "ms, sum:" + sum);
    }
}
