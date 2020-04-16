package 字符串中的第一个唯一字符;

/**
 *    给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *     案例:
 *
 *     s = "leetcode"
 *     返回 0.
 *
 *     s = "loveleetcode",
 *     返回 2.
 *
 *
 *     注意事项：您可以假定该字符串只包含小写字母。
 */

import java.util.*;
public class Solution {
    public int firstUniqChar(String s) {
        int res = -1;
        Map<Character,Integer> linkedMap = new LinkedHashMap<Character, Integer>();

        char[] tmp = s.toCharArray();
        int length = tmp.length;
        for(int i = 0;i<length;i++)
        {
            if(linkedMap.get(tmp[i])==null)
            {
                linkedMap.put(tmp[i],1);
            }
            else {
                linkedMap.put(tmp[i],linkedMap.get(tmp[i])+1);
            }
        }
        for(int i =0;i<length;i++)
        {
            if(linkedMap.get(tmp[i])==1)
            {
                return i;
            }
        }
        return res;
    }
}
