package Q1002查找常用字符;

/*
给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。

你可以按任意顺序返回答案。

 

示例 1：

输入：["bella","label","roller"]
输出：["e","l","l"]
示例 2：

输入：["cool","lock","cook"]
输出：["c","o"]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-common-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import java.util.*;

class Solution {
    public List<String> commonChars(String[] A) {
        int[] chars = new int[26];
        Arrays.fill(chars,Integer.MAX_VALUE);
        for(String a : A){
            int[] cur = new int[26];
            int len = a.length();
            for(int i = 0;i<len;i++){
                ++cur[a.charAt(i)-'a'];
            }
            for(int i=0;i<26;i++){
                chars[i] = Math.min(cur[i],chars[i]);
            }
        }

        List<String> resList = new ArrayList();
        for(int i=0;i<26;i++){
            for(int j =0;j<chars[i];j++){
                resList.add(String.valueOf((char)('a'+i)));
            }
        }
        return resList;
    }
}
