package 最长回文子串;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];

        int maxLength = 0;
        String res ="";
        for(int len =1;len<=length;len++)
        {
            for(int i=0;i<length;i++)
            {
                int j = i+len-1;
                if(j>=length)break;
                dp[i][j] = (len==1||len==2||dp[i+1][j-1])&&(s.charAt(i)==s.charAt(j));
                if(dp[i][j]&&len>maxLength)
                {
                    maxLength = len;
                    res = s.substring(i,j+1);
                }
            }
        }
        return res;

    }

}