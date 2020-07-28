package com.springbootexample.springbootdemo.review.Thread;

import java.util.concurrent.*;

class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        // 模拟计算需要一秒
        Thread.sleep(1000);
        return 2;
    }
    public static void main(String args[]) throws ExecutionException, InterruptedException {
        // ①实现Callable接口
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> result = executor.submit(task);
        // 注意调用get方法会阻塞当前线程，直到得到结果。
        // 所以实际编码中建议使用可以设置超时时间的重载get方法。
        System.out.println(result.get());


        // ②继承futureTask类
        ExecutorService executor2 = Executors.newCachedThreadPool();
        FutureTask<Integer> futureTask = new FutureTask<>(new Task());
        executor2.submit(futureTask);
        System.out.println(futureTask.get());
    }

}