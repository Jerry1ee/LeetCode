package BaiduQ1;

import java.util.*;
public class Main {
    public static void main(String[] args)
    {
        Scanner scanner  = new Scanner(System.in);
        while (scanner.hasNextInt())
        {
            int n = scanner.nextInt();
            int max =0;
            for(int i=1;i<=n;i++)
            {
                for(int j=i;j<=n;j++)
                {
                    max = Math.max(lcm(i,j)-gcd(i,j),max);
                }
            }
            System.out.println(max);
        }

    }
    static int gcd(int a,int b)
    {
        if(b==0)return a;

        return gcd(b,a%b);
    }
    static int lcm(int a,int b)
    {
        int max=0;
        int min=0;
        if(a>b)
        {
            max=a;
            min=b;
        }
        else {
            max=b;
            min=a;
        }

        int res= max;

        return res;

    }
}
