package HuaweiQ1;

import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine())
        {
            String[] vote = scanner.nextLine().split(",");
            Map<String,Integer> map = new HashMap<>();
            for(int i=0;i<vote.length;i++)
            {
                if(vote[i].charAt(0)>'Z'||vote[i].charAt(0)<'A'){
                    System.out.println("error.0001");
                    return;
                }
                for(int j=1;j<vote[i].length();j++)
                {
                    if(vote[i].charAt(j)>'z'||vote[i].charAt(j)<'a'){
                        System.out.println("error.0001");
                        return;
                    }
                }
                if(map.get(vote[i])==null){
                    map.put(vote[i],1);
                }
                else {
                    map.put(vote[i],map.get(vote[i])+1);
                }
            }
            List<String> list = new ArrayList<>();
            int max = 0;
            for(Integer i:map.values())
            {
                if(i>=max)max=i;
            }
            for(String s:map.keySet())
            {
                if(map.get(s)>=max)
                    list.add(s);
            }
            String[] res = new String[list.size()];
            for(int i =0;i<res.length;i++)
            {
                res[i] = list.get(i);
            }
            Arrays.sort(res);
            System.out.println(res[0]);

        }
    }
}
