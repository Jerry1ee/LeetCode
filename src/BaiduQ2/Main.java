package BaiduQ2;


import javax.xml.parsers.DocumentBuilder;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt())
        {
            int n =scanner.nextInt();
            int max =n;
            int k=0;
            double[] arr= new double[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=scanner.nextDouble();
            }
            int index =-1;
            index = maxIndex(arr);
            while (arr[index]>=max)
            {
                k++;
                arr[index]-=n+1;
                index =  maxIndex(arr);
                max--;
            }
            System.out.println(k);

        }
    }

    static int maxIndex(double[] arr)
    {
        double max = 0;
        int index = -1;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>max)
            {
                max=arr[i];
                index = i;
            }
        }
        return index;
    }
}
