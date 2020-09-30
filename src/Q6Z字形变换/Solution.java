package Q6Z字形变换;

/*
 *将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);
示例 1:

输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
示例 2:

输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:

L     D     R
E   O E   I I
E C   I H   N
T     S     G


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zigzag-conversion
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import java.util.*;
//每行都添加一个StringBuilder作为字符接收者，例如，要求numRows为3行，输入字符串为 "leetcodeisgood"
/*
 *  _
 *  _
 *  _
 *  刚开始就添加三个StringBuilder，当然要求字符串长度要大于numRows，然后从上往下添加字符，添加完三个之后变成
 *  l _
 *  e _
 *  e _
 *  此时下表到达底部，再添加下标就要向上走，到第二行，再add到StringBuilder时，就自动加到第二个了，如下
 *  l _
 *  e t _
 *  e _
 */

class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        List<StringBuilder> strList = new ArrayList<>();

        for(int i = 0;i<Math.min(s.length(),numRows);i++){
            strList.add(new StringBuilder());
        }

        int curRow = 0;
        boolean down = true;

        int index = 0;
        while(index<s.length()){
            strList.get(curRow).append(s.charAt(index++));
            if(down){
                curRow++;
            }else{
                curRow--;
            }
            if(curRow == 0){
                down = true;
            }
            if(curRow == strList.size()-1){
                down = false;
            }
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row: strList ){
            res.append(row);
        }
        return res.toString();

    }
}
