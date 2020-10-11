package Q416分割等和子集;

/*

给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

注意:

每个数组中的元素不会超过 100
数组的大小不会超过 200
示例 1:

输入: [1, 5, 11, 5]

输出: true

解释: 数组可以分割成 [1, 5, 5] 和 [11].

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int len = nums.length;

        if(len <2 ) return false;

        int sum = 0;
        int maxNum = nums[0];
        for(int i = 0;i<len;i++){
            sum+=nums[i];
            maxNum = Math.max(maxNum,nums[i]);
        }

        if(sum%2 != 0)return false;
        int target = sum/2;
        if(maxNum>target) return false;

        boolean[][] dp= new boolean[len][target+1];
        for (int i = 0; i < len; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < len; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len - 1][target];
    }
}
