package HuaweiQ3;

import java.util.*;

public class Main {
    static int max = 0;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        try{
            while (scanner.hasNextInt())
            {
                int N =scanner.nextInt();
                int[] pickTimes = new int[N];
                boolean[] visited = new boolean[N];
                for(int i =0;i<N;i++){
                    pickTimes[i]=scanner.nextInt();
                }
                Map<Integer,List<Integer>> pickMap = new HashMap<>();
                for(int i=0;i<N;i++)
                {
                    Integer tmp = scanner.nextInt();
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(scanner.nextInt());
                    for(int j =0;j<pickTimes[i];j++)
                    {
                        tmpList.add(scanner.nextInt());
                    }
                    pickMap.put(tmp,tmpList);
                }
                for(int i:pickMap.keySet()){
                    DFS(pickMap.get(i),0,i-1,visited,pickMap);
                }
                if(max==Integer.MAX_VALUE) System.out.println("NA");
                else {
                    System.out.println(max);
                }
            }
        }
        catch (Exception e ){
            System.out.println("NA");
        }

    }
    static void DFS(List<Integer> pickList, int depth, int x, boolean[] visited, Map<Integer, List<Integer>> pickMap){
        if(pickList.size()<=1){
            depth+=pickList.get(0);
            max = Math.max(max,depth);
            return;
        }
        depth += pickList.get(0);
        for(int i=1;i<pickList.size();i++)
        {
            visited[pickList.get(i)-1]=true;
            DFS(pickMap.get(pickList.get(i)),depth,pickList.get(i)-1,visited,pickMap);
        }
    }
}
