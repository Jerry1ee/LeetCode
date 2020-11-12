package Q31下一个排列;

/*
实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/next-permutation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public void nextPermutation(int[] nums) {

        int i = nums.length-2;
        //从后往前找第一个不符合递增的 x
        while(i>=0&&nums[i]>=nums[i+1]){
            i--;
        }
        //把第一个不符合递增的 x 和第一个大于它的值进行交换
        //因为到x之前都是递增的，所以从尾部依次遍历，第一个大于x的一定是最小的大于x的
        if(i>=0){
            int j = nums.length-1;
            while(j>=0&&nums[j]<=nums[i]){
                j--;
            }
            swap(nums,i,j);
        }
        //反转后半部分
        reverse(nums,i+1,nums.length-1);

    }

    void reverse(int[] arr,int i,int j){
        while(i<j){
            swap(arr,i,j);
            i++;
            j--;
        }
    }
    void swap(int[] arr , int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}