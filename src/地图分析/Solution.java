package 地图分析;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Queue<int[]> queue = new ArrayDeque<>();

        //先把所有陆地都入队
        for(int i = 0;i<n;i++)
        {
            for(int j =0;i<n;j++)
            {
                if(grid[i][j]==1)
                {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        //从第一个陆地开始，扩散式地遍历海洋，最后遍历到的海洋就是最远的

        int[] point =null ;
        while (!queue.isEmpty()){
            point = queue.poll();

            //取得陆地的x y坐标
            int x = point[0];int y=point[1];
            //将陆地四周的海洋入队

            boolean hasOcean = false;
            for(int i=0;i<4;i++)
            {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(newX<0||newY<0||newX>=n||newY>=n||grid[newX][newY]!=0)
                {
                    continue;
                }
                grid[newX][newY]=grid[x][y]+1;
                hasOcean =true;
                queue.offer(new int[]{newX,newY});
            }
            // 没有陆地或者没有海洋，返回-1。
            if (point == null || !hasOcean) {
                return -1;
            }
        }

        // 返回最后一次遍历到的海洋的距离。
        return grid[point[0]][point[1]] - 1;

    }
}