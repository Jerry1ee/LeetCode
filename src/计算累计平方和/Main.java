package 计算累计平方和;

import java.util.*;
class Main{
    public static void main(String[] args)
    {
        Scanner scanner  = new Scanner(System.in);
        int T =scanner.nextInt();
        for(int t = 0;t<T;t++)
        {

            int x =scanner.nextInt();
            int sum = 0;
            if(isNum(x))
            {
                System.out.println(true);
            }
            else {
                System.out.println(false);
            }

        }
    }

    static boolean isNum(int x)
    {
        HashSet<Integer> set = new HashSet<>();
        while (true)
        {
            int sum =0;
            while (x>0)
            {
                int tmp = x%10;
                sum += tmp*tmp;
                x /=10;
            }
            if(sum==1){
                return true;
            }
            if(set.contains(sum))return false;

            x = sum;
            sum = 0;
        }
    }
}