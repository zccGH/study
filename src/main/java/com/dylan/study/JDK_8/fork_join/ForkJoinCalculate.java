package com.dylan.study.JDK_8.fork_join;

import java.util.concurrent.RecursiveTask;

public class ForkJoinCalculate extends RecursiveTask<Long> {

    private long start;
    private long end;

    public ForkJoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    //临界值
    private static final long THRESHOLD=10000L;

    @Override
    protected Long compute() {
        long length = end - start;
        if (length<=THRESHOLD) {
            long sum=0;
            for (long i = start; i <= end; i++) {
                sum+=i;
            }
            return sum;
        }else{
            long middle = (end + start) / 2;
            ForkJoinCalculate left=new ForkJoinCalculate(start,middle);
            left.fork();//拆分，并将子任务压入线程队列

            ForkJoinCalculate right=new ForkJoinCalculate(middle+1,end);
            right.fork();
            return left.join()+right.join();
        }
    }
}
