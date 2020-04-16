package 机器人的运动范围;

/**
 * 题目描述
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），
 * 因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class Solution {

    public int movingCount(int threshold, int rows, int cols)
    {
        int times =0;
        if(rows==0||cols==0)return 0;
        if(threshold==0)return 1;
        boolean[][] matrix = new boolean[rows][cols];
        return move(matrix,rows,cols,0,0,threshold);

    }
    int move(boolean[][] matrix,int rows,int cols,int i,int j,int k)
    {
        //递归结束条件
        if(i<0||j<0||i>=rows||j>=cols||matrix[i][j]==true)
        {
            return 0;
        }
        //若此格子没被访问
        int sum = 0;
        int tmpi = i;
        int tmpj = j;
        while(tmpi>0)
        {
            int tmp = tmpi%10;
            sum +=tmp;
            tmpi /=10;
        }
        while(tmpj>0)
        {
            int tmp = tmpj%10;
            sum +=tmp;
            tmpj /=10;
        }
        if(sum>k)
        {

            return 0;
        }
        matrix[i][j]=true;
       return 1+ move(matrix, rows,cols,i-1, j, k)+
        move(matrix, rows,cols,i+1, j, k)+
        move(matrix, rows,cols,i, j-1, k)+
        move(matrix, rows,cols, i, j+1, k);
    }

}