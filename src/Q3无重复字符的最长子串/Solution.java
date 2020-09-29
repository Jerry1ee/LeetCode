package Q3无重复字符的最长子串;

import java.util.*;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();

        int start = 0;
        for(int end = 0;end<s.length();end++){
            Character tmp = s.charAt(end);
            if(map.containsKey(tmp)){
                start = Math.max(start,map.get(tmp));
            }
            res = Math.max(res,end-start+1);
            //记录如果当前字符重复了，去掉该字符后的开始位置
            map.put(tmp,end+1);
        }
        return res;
    }

}