package Callable;


import java.util.concurrent.*;

public class TestCallable {
    public static void main(String[] args)
    {
        ThreadDemo td=  new ThreadDemo();

        //用 FutureTask 接收结果
        FutureTask<Integer> result = new FutureTask<>(td);

        new Thread(result).start();

        //接收运算结果
        try {
            Integer sum = result.get();
            System.out.println("1-100的和为："+ sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class ThreadDemo implements Callable<Integer>
{
    @Override
    public Integer call() throws Exception {
        int sum =0;
        for (int i=1;i<101;i++)
        {
            System.out.println(i);
            sum+=i;
        }

        return sum;
    }
}