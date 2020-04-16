package TestCopyOnWriteArraySet;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * 写入并复制
 */
public class TestCopyOnWriteArraySet {

    public static void main(String[] args)
    {
        HelloThread ht = new HelloThread();
        for (int i=0;i<10;i++)
        {
            new Thread(ht).start();
        }
    }

}
class HelloThread implements  Runnable{

//    private static List<String> list = Collections.synchronizedList(new ArrayList<>());
    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
    static {
        list.add("A");
        list.add("B");
        list.add("C");

    }
    @Override
    public void run() {
        Iterator<String> it = list.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
            list.add("A");
        }
    }
}
