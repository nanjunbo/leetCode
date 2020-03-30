package self;

/**
 * 一个线程输出质数，一个线程输出其他数
 */
public class ThreadShowNumber {
    private static volatile int num = 1;
    public static void main(String[] args) {
        Object object = new Object();

        new Thread(new Runnable(){
            public void run() {
                synchronized (object){
                    while (true){
                        object.notify();

                        while (isPrimeNum(num) && num <=100){
                            System.out.println("a线程打印质数 ：" +num);
                            num++;
                        }
                        if (num > 100){
                            break;
                        }
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable(){
            public void run() {
                synchronized (object){
                    while (true){
                        object.notify();
                        while (!isPrimeNum(num) && num <=100){
                            System.out.println("b线程打印其他数 ：" +num);
                            num++;
                        }
                        if (num > 100){
                            break;
                        }
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }

    public static boolean isPrimeNum(int n) {
        for (int i = 2; i < n; i++) {
            if (n%i==0) {
                return false;
            }
        }
        return true;
    }
}
