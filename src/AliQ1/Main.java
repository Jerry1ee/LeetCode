package AliQ1;
import java.util.*;
public class Main {
    public static void main(String[] args)
    {
        Scanner sc =new Scanner(System.in);
        while (sc.hasNextDouble())
        {
            double n = sc.nextDouble();
            if(n==0){

                System.out.println(0);break;
            }
            if(n==1)
            {
                System.out.println(1);break;
            }
            double sum =0;
            for(double i =1;i<=n;i++)
            {
                sum+=(i*NpickK(n,i))%(Math.pow(10,9)+7);
            }
            System.out.println((int)sum);
        }


    }
    static double NpickK(double n,double k)
    {
        if(n==k)return 1;
        if(k==1)return n;
        double fenzi =1;
        for(int i=0;i<k;i++)
        {
            fenzi = fenzi*n%(Math.pow(10,9)+7);
            n--;
        }
        double fenmu =1;
        while(k>0)
        {
            fenmu = fenmu*k%(Math.pow(10,9)+7);
            k--;
        }
        return fenzi/fenmu;
    }
}
