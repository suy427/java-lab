package com.sondahum.multithread.javaconcurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyConcurrency {
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    void test() {
        CompletableFuture.runAsync(() -> {

        }, executor);
    }
}
