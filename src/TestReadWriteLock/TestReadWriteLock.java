package TestReadWriteLock;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestReadWriteLock {
    public static void main(String[] args)
    {
        ReadWriteLockDemo rw = new ReadWriteLockDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                rw.setNumber(new Random().nextInt(111));
            }
        },"Write:").start();

        for(int i= 0;i<100;i++)
        {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    rw.getNumber();
                }
            },"Read:") .start();
        }

    }
}
class ReadWriteLockDemo{
    private  int number = 0;

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    //读
    public void getNumber(){
        lock.readLock().lock();

        try{
            System.out.println(Thread.currentThread().getName()+":"
                    + number);
        }
        finally {
            lock.readLock().unlock();
        }

    }

    //写
    public void setNumber(int number)
    {
        lock.writeLock().lock();
        try
        {
            System.out.println(Thread.currentThread().getName());
            this.number = number;
        }
        finally {
            lock.writeLock().unlock();
        }

    }

}
