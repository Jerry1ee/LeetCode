package 帕斯卡三角形;

import java.util.*;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        List<Integer> preList = new ArrayList<Integer>();
        for(int i=1;i<=numRows;i++)
        {

            List<Integer> subList = new ArrayList<Integer>();
            for(int j=0;j<i;j++)
            {
                if(j!=0&&j!=i-1)
                {
                    subList.add(preList.get(j-1)+preList.get(j));
                }
                else {
                    subList.add(1);
                }
            }
            preList = subList;
            resList.add(subList);
        }
        return resList;
    }
}