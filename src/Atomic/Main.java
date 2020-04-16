package Atomic;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.*;
/**
 * 实际上i++分为三个步骤 “读-改-写”
 * int i = 0;
 * i++;
 * 实际上的操作：
 * int tmp = i;
 * tmp = i+1;
 * i = tmp;
 */
public class Main {
    public static void main(String[] args)
    {
    AtomicDemo ad = new AtomicDemo();
    for(int i=0;i<10;i++)
    {
        new Thread(ad).start();
    }

    }

}

 class AtomicDemo implements Runnable{
    private AtomicInteger serialNumber = new AtomicInteger();

    public int getSerialNumber()
    {
        //获取并递增
        return serialNumber.getAndIncrement();
    }
    @Override
    public void run() {
        try{
            Thread.sleep(200);
            System.out.println(Thread.currentThread().getName()+" : "+getSerialNumber());
        }
        catch (Exception e )
        {
        }
    }
}
