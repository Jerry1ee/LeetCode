package 车的可用捕获量;

import java.util.*;
class Solution {
    public int numRookCaptures(char[][] board) {
        int x = 0;int y=0;

        int res =0;
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]=='R')
                {
                    x=i;y=j;break;
                }
            }
        }
        for(int i=x;i>=0;i--)
        {
            if(x==i)continue;
            if(board[i][y]=='.')
            {
                continue;
            }
            else if(board[i][y]=='B')
            {
                break;
            }
            else {
                res++;break;
            }
        }
        for(int i=x;i<board.length;i++)
        {
            if(x==i)continue;
            if(board[i][y]=='.')
            {
                continue;
            }
            else if(board[i][y]=='B')
            {
                break;
            }
            else {
                res++;break;
            }
        }
        for(int j=y;j>=0;j--)
        {
            if(y==j)continue;
            if(board[x][j]=='.')
            {
                continue;
            }
            else if(board[x][j]=='B')
            {
                break;
            }
            else {
                res++;break;
            }
        }
        for(int j=y;j<board[0].length;j++)
        {
            if(y==j)continue;
            if(board[x][j]=='.')
            {
                continue;
            }
            else if(board[x][j]=='B')
            {
                break;
            }
            else {
                res++;break;
            }
        }
        return res;
    }
}