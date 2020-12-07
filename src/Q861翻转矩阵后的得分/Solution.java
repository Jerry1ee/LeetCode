package Q861翻转矩阵后的得分;

/**
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 *
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 *
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 *
 * 返回尽可能高的分数。
 *
 *  
 *
 * 示例：
 *
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/score-after-flipping-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int matrixScore(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        //尽量让每一行开头都是1，所以每一行的第一列贡献值如下：
        int ans = m*(1<<(n-1));

        for(int j =1;j<n;j++){
            int nOnes = 0;
            for(int i = 0;i<m;i++){

                //nOnes代表 1 的个数
                //如果该行第一列为1，则直接加上原始值，否则加上反转之后的值
                if(A[i][0] == 1){
                    nOnes += A[i][j];
                }else{
                    nOnes += 1-A[i][j];
                }
            }
            int k = Math.max(m-nOnes, nOnes);
            ans += k*(1<<(n-1-j));
        }
        return ans;
    }
}