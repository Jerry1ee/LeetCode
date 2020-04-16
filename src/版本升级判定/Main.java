package 版本升级判定;

/**
 * 给定两个版本号，只有在版本号更高的时候，才可以升级。「.」号作为分割符使用，版本号中只有数和.号。
 *
 * 例如：0.1<1.1
 * 1.2<13.37
 *
 *
 * 输入描述:
 * 第一行为m(1<=m<=100000)，表示测试组数，接下来m行，表示m次查询。
 *
 * 每行两个版本号，空格分隔。一个版本号中最多只会出现3个「.」。每个版本号中数字1<=x<=100。
 *
 * 输出描述:
 * 对于每一次查询，输出是否可以升级，是则输出"true"，否则输出"false" (引号不要输出)
 *
 * 输入例子1:
 * 2
 * 6.6.6 6.6.7
 * 1 1.0
 *
 * 输出例子1:
 * true
 * false
 *
 * 例子说明1:
 * 1和1.0被认为是相同的版本号
 *
 * 输入例子2:
 * 1
 * 1 1.0.0.2
 *
 * 输出例子2:
 * true
 */
import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T =scanner.nextInt();
        scanner.nextLine();
        for(int t = 0 ;t<T;t++)
        {
            String[] strings = scanner.nextLine().split(" ");
            String[] strings1 = strings[0].split("\\.");
            String[] strings2 = strings[1].split("\\.");
            int i =0;int j =0;
            boolean out = false;
            while (i<strings1.length&&j<strings2.length)
            {
                if(Integer.valueOf(strings2[j])>Integer.valueOf(strings1[i]))
                {
                    System.out.println(true);
                    out =true;
                    break;
                }
                else if (Integer.valueOf(strings2[j])<Integer.valueOf(strings1[i])){
                    System.out.println(false);
                    out =true;
                    break;
                }
                else {
                    i++;
                    j++;
                }
            }
            while(i<strings1.length&&!out){
                if(!strings1[i].equals("0"))
                {
                    System.out.println(false);
                    out =true;
                    break;
                }
            }
            while (j<strings2.length&&!out){
                if(Integer.valueOf(strings2[j])>0)
                {
                    System.out.println(true);
                    out = true;
                    break;
                }
            }
        }
    }
}
