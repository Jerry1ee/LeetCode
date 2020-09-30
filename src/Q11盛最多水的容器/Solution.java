package Q11盛最多水的容器;

/*
给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0)。找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且n的值至少为 2。


示例：

输入：[1,8,6,2,5,4,8,3,7]
输出：49


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/container-with-most-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;    //定义最大面积
        int l = 0;
        int r = height.length-1;

        while(l<r){
            maxArea = Math.max(maxArea,Math.min(height[l],height[r])*(r-l));
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxArea;
    }
}
