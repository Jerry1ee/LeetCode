package MultiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args)
    {
        AlternateDemo alternateDemo = new AlternateDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=20;i++)
                {
                    alternateDemo.loopA(i);
                }
            }
        },"A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=20;i++)
                {
                    alternateDemo.loopB(i);
                }
            }
        },"B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=20;i++)
                {
                    alternateDemo.loopC(i);
                    System.out.println("_____________");
                }
            }
        },"C").start();

    }
}
class AlternateDemo{
    private int number = 1;     //当前正在执行线程的标记

    private Lock lock= new ReentrantLock() ;

    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    /**
     *
     * @param totalLoop
     */
    public void loopA(int totalLoop){
        lock.lock();
        try {
            //1.判断当前线程是否为1
            if(number != 1)
            {
                condition1.await();
            }
                System.out.println(Thread.currentThread().getName()+"\t" +
                        "\t"+ totalLoop);

            //3.A打印完毕，唤醒其他线程
            number = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopB(int totalLoop){
        lock.lock();
        try {
            //1.判断当前线程是否为1
            if(number != 2)
            {
                condition2.await();
            }

                System.out.println(Thread.currentThread().getName()+"\t" +
                        "\t"+ totalLoop);

            //3.A打印完毕，唤醒其他线程
            number = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopC(int totalLoop){
        lock.lock();
        try {
            //1.判断当前线程是否为1
            if(number != 3)
            {
                condition3.await();
            }

                System.out.println(Thread.currentThread().getName()+"\t" +
                       "\t"+ totalLoop);

            //3.A打印完毕，唤醒其他线程
            number = 1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

