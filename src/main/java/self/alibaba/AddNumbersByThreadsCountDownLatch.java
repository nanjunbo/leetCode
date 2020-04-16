package self.alibaba;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 10个线程，分别加100万个数，CountDownLatch
 */

public class AddNumbersByThreadsCountDownLatch extends Thread{
    private long startNum;
    private AtomicLong sumNumbers;
    private CountDownLatch countDownLatch;

    public AddNumbersByThreadsCountDownLatch (long startNum,  AtomicLong sumNumbers, CountDownLatch countDownLatch){
        this.startNum = startNum;
        this.sumNumbers = sumNumbers;
        this.countDownLatch = countDownLatch;
    }

    public void run() {
        long sum = 0;
        for (long i = 0; i<100000; i++){
            sum = startNum + sum + i;
        }
        System.out.println("sum:" + sum);
        sumNumbers.getAndAdd(sum);
        countDownLatch.countDown();
    }

    public static void main(String[] args) throws Exception {
        Thread[] threadList = new Thread[10];
        CountDownLatch countDownLatch = new CountDownLatch(10);
        AtomicLong sumNumber = new AtomicLong();
        for (int i = 0; i<10; i++){
            threadList[i] = new AddNumbersByThreadsCountDownLatch(1000000*i, sumNumber, countDownLatch);
            threadList[i].start();
        }
        countDownLatch.await();
        System.out.println("sum number is " + sumNumber);
    }
}
