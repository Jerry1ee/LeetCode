package TestCountDownLatch;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        //初始值为5，每次有线程完成就递减1，直到0才可以继续执行
        CountDownLatch latch = new CountDownLatch(5);
        LatchDemo latchDemo =new LatchDemo(latch);

        long start = System.currentTimeMillis();
        for (int i=0;i<10;i++)
        {
            new Thread(latchDemo).start();
        }

        latch.await();
        long end = System.currentTimeMillis();
        System.out.println("耗费时间："+(end-start));
    }
}
class LatchDemo implements Runnable{

    private CountDownLatch latch;

    public LatchDemo(CountDownLatch latch)
    {
        this.latch = latch;
    }
    @Override
    public void run() {

        synchronized (this)
        {
            try{
                for(int i = 0;i<50000;i++)
                {
                    if(i%2==0)
                    {
                        System.out.println(i);
                    }
                }
            }
            finally {
                latch.countDown();
            }
        }
    }
}
