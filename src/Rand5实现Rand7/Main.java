package Rand5实现Rand7;

import java.util.Random;

public class Main {

    public static void main(String[] args)
    {
        for(int i=0;i<100;i++)
        {
            int x = ~(1<<31);
            while (x>21)
            {
                x = 5*(rand5()-1)+rand5();
            }
            x %=7;
            System.out.print(x+" ");
        }

    }
    static int rand5()
    {
        Random random = new Random();
        return random.nextInt(5)+1;
    }

}
