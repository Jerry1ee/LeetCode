package TestVolatile;

/**
 * volatile: 当多个线程进行操作共享数据时，可以保证内存中的数据是可见的
 *
 */
public class TestVolatile {
    public static void main(String[] args)
    {
        ThreadDemo td = new ThreadDemo();
        new Thread(td).start();

        while (true)
        {
            if(td.isFlag()){
                System.out.println("----------------");
                break;
            }
        }
    }


}
class ThreadDemo implements Runnable{
    private volatile boolean  flag = false;
    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag =true;
        System.out.println("flag="+isFlag());
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
