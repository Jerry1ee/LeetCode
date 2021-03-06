package Q290单词规律;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author lzy
 */
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arrString = s.split(" ");
        char[] patterns = pattern.toCharArray();
        if(patterns.length != arrString.length) return false;
        Map<Character, String> charToStr = new HashMap<>();
        Map<String, Character> strToChar = new HashMap<>();

        for (int i =0; i < patterns.length; i++) {
            if (charToStr.get(patterns[i]) == null &&
                    strToChar.get(arrString[i]) == null) {
                charToStr.put(patterns[i], arrString[i]);
                strToChar.put(arrString[i], patterns[i]);
            } else if (charToStr.get(patterns[i]) != null &&
                    strToChar.get(arrString[i]) != null) {
                if (!charToStr.get(patterns[i]).equals(arrString[i])||
                        strToChar.get(arrString[i]) != patterns[i] ) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
