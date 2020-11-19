package Q402移掉K位数字;

/**
 * 定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 *
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public String removeKdigits(String num, int k) {

        /**
         * 先找第一个不递增的元素，删除它
         * 然后清除0
         * 再次遍历
         */
        if(k == num.length()) return "0";
        StringBuilder s = new StringBuilder(num);

        for(int i =0;i<k ;i++){
            int index = 0;
            for(int j =1;j<s.length() && s.charAt(j) >= s.charAt(j-1);j++) index = j;
            s.delete(index, index+1);
            while(s.length()>1 && s.charAt(0) == '0') s.delete(0,1);
        }
        return s.toString();
    }
}
