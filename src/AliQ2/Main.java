package AliQ2;
import java.util.*;
public class Main {
    public static void main(String[] args)
    {
        Scanner sc =new Scanner(System.in);
        int m = sc.nextInt();
        int n =sc.nextInt();
        String[][] matrix = new String[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                matrix[i][j]=sc.next();
            }
        }
        int Sx=0;
        int Sy=0;

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j].equals("S"))
                {
                    Sx=i;
                    Sy=j;
                }
            }
        }

    }
    static int walk(String[][] matrix,int i,int j)
    {
        if(i<0||j<0||i>matrix.length||j>matrix[0].length||matrix[i][j].equals("#"))
        {
            return 0;
        }
        if(matrix[i][j].equals("E"))
            return 1;

        return 1+walk(matrix,i-1,j)+
                walk(matrix,i+1,j)
                +walk(matrix,i,j-1)
                +walk(matrix,i,j+1);
    }
}
