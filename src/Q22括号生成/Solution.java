package Q22括号生成;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        return res;
    }

    void DFS(int n, int index, String s , Stack<String> stack)
    {
        if(index>=n||stack.isEmpty()){
            res.add(s);
            return;
        }
        stack.push("(");
        DFS(n,index+1,s+"(",stack);
        stack.pop();
        DFS(n,index+1,s+")",stack);


    }
}
