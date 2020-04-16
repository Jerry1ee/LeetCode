package 分割回文串;
import java.util.*;
/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class Solution {
    List<List<String>> resList=  new ArrayList<>();
    public List<List<String>> partition(String s) {


        List<String> subList = new ArrayList<>();


        addPalindrome(subList,s,0);
        return resList;
    }

    public void addPalindrome(List<String> subList,String s ,int begin)
    {

        if(begin==s.length())
        {
            resList.add(new ArrayList<>(subList));
        }
        for(int i = begin ;i<s.length();i++)
        {
            if(isPalindrome(s.substring(begin,i+1)))
            {
                subList.add(s.substring(begin,i+1));
                addPalindrome(subList,s,i+1);
                subList.remove(subList.size()-1);

            }
        }
    }

    public boolean isPalindrome(String s)
    {
        if(new StringBuilder(s).reverse().toString().equals(s))
            return true;
            return false;
    }

}
