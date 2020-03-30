package self;

import java.util.ArrayList;
import java.util.List;

/**
 * 10个线程，分别加100万个数，用wait跟notify实现
 */
public class AddNumbersByThreads {
    public static void main(String[] args) throws Exception {
        long sum = 0;
        Object[] lock = new Object[10];
        for (int i =0;i<10;i++){
            lock[i] = new Object();
        }
        List<Add> addList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Add add = new Add(100000 * i, lock[i]);
            add.start();
            addList.add(add);
        }
        for (int i = 0; i < 10; i++) {
            synchronized (lock[i]) {
                while (!addList.get(i).getHasNotify()){
                    lock[i].wait();
                }
            }
        }
        for (Add add : addList) {
            sum += add.getSumNumber();
        }
        System.out.println("sum number is " + sum);
    }
}
class Add extends Thread{
    private long startNum;
    private volatile long sumNumber;
    private volatile boolean hasNotify;
    public long getSumNumber() {
        return sumNumber;
    }
    public boolean getHasNotify() {
        return hasNotify;
    }
    private  Object lock;
    public Add(long startNum ,Object lock){
        this.startNum = startNum;
        this.lock = lock;
    }
    public void run() {
        long sum = 0;
        synchronized (lock){
            for (int i = 100000;i >0; i--){
                sum = sum + startNum + i;
                i --;
            }
            sumNumber = sum;
            hasNotify = true;
            lock.notify();
        }
    }
}
