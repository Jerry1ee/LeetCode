package HuaweiQ2;

import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String[] tmp = scanner.nextLine().split(" ");
            String target = tmp[0];
            String [] strings = tmp[1].split("],");
            boolean has = false;
            if(!target.contains("[")){
                for(int i=0;i<strings.length;i++)
                {
                    List<String> tmpList = new ArrayList<>();
                    String s1[] = strings[i].split("\\[");
                    String s2[] =s1[1].split(",");
                    if(s1[0].equals(target)){
                        has = true;
                        System.out.print(s2[0].substring(5)+" ");
                        System.out.print(s2[1].substring(5)+" ");
                        if(s2[2].contains("]")){
                            System.out.print(s2[2].substring(4,s2[2].length()-1)+"\r\n");
                        }else {
                            System.out.print(s2[2].substring(4)+"\r\n");
                        }
                    }
                }
                if(!has) System.out.println("FAIL");
            }
            else {
                while (tmp[1].indexOf(target)!=-1)
                {
                    int next = tmp[1].indexOf(target);
                    has =true;
                    String tmp11[]= target.split("\\[");
                    String tmp22[]= tmp11[1].split(",");
                    System.out.print(tmp22[0].substring(5)+" ");
                    System.out.print(tmp22[1].substring(5)+" ");
                    System.out.print(tmp22[2].substring(4,tmp22[2].length()-1)+"\r\n");
                    tmp[1]= tmp[1].substring(next+target.length());
                }
                if(!has)
                    System.out.println("FAIL");

            }

        }
    }
}