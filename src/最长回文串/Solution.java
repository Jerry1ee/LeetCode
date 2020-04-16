package 最长回文串;

import java.util.*;
/**
 * 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
class Solution {
    public int longestPalindrome(String s) {
        if(s.length()==0)return 0;
        if(s.length()==1)return 1;

        int[] count = new int[128];

        int ans = 0;
        for(char c:s.toCharArray())
        {
            count[c]++;
        }
        /**
         * 在代码中，我们用 ans 存储回文串的长度，由于在遍历字符时，ans 每次会增加 v / 2 * 2，
         * 因此 ans 一直为偶数。但在发现了第一个出现次数为奇数的字符后，我们将 ans 增加 1，这样 ans 变为奇数，
         * 在后面发现其它出现奇数次的字符时，我们就不改变 ans 的值了。
         */
        for(int i : count)
        {
            ans+= i/2*2;
            if(i%2==1&&ans%2==0)
            {
                ans++;
            }
        }
        return ans;
    }
}