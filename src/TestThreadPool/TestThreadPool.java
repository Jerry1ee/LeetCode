package TestThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 一、线程池 ：提供了一个线程队列，队列中保存着所有等待状态的线程
 *        避免了创建和销毁线程的额外开销，提高了响应速度
 * 二、线程池体系结构：
 *        java.util.concurrent.Executor ：负责线程的使用与调度的根接口
 *        |-- ExecutorService 子接口： 线程池的主要接口
 *          |-- ThreadPoolExecutor ： 线程池的实现类
 *          |-- ScheduledExecutorService 子接口 ： 负责线程的调度
 *              |-- ScheduledThreadPoolExecutor ： 继承了线程池的实现类（ThreadPoolExecutor），实现了ScheduledExecutorService接口
 *  三、工具类：Executors
 *      ExecutorService newFixedThreadPool()：创建固定大小的线程池
 *      ExecutorService newCachedThreadPool()：缓存线程池，线程池数量不固定，可根据需求自动更改数量
 *      ExecutorService newSingleThreadExecutor()：创建单个线程池。线程池中只有一个线程
 *
 *      ScheduledExecutorService newScheduledThreadPool()：创建固定大小的线程，延迟或定时地执行任务
 *
 */
public class TestThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolDemo tpd = new ThreadPoolDemo();
        //1.创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);

        List<Future> list = new ArrayList<>();

        for(int i=0;i<10;i++)
        {
            Future<Integer> future = pool.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int sum = 0;
                    for(int i=0;i<100;i++)
                    {
                        sum+=i;
                    }
                    return sum;
                }
            });

            list.add(future);
        }

       for(Future future:list)
       {
           System.out.println(future.get());
       }

        //2.为线程池中的线程分配任务
//        for(int i = 0;i<100;i++)
//        {
//            pool.submit(tpd);
//        }

        //3.关闭线程池
        pool.shutdown();
    }
}

class ThreadPoolDemo implements Runnable{
    private int i =0;

    @Override
    public void run() {
        while(i<=100){
            System.out.println(Thread.currentThread().getName()+":"+ i++);
        }
    }
}