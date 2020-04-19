package Q46全排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//class Solution {
//
//    List<List<Integer>> resList = new ArrayList<>();
//    public List<List<Integer>> permute(int[] nums) {
//
//        fullArrange(nums,0);
//        return resList;
//    }
//    void fullArrange(int nums[],int index){
//        if(index>=nums.length){
//            List<Integer> subList = Arrays.stream(nums).boxed().collect(Collectors.toList());
//            if(!resList.contains(subList))
//            resList.add(subList);
//        }
//        for(int j = index;j<nums.length;j++){
//            swap(nums,j,index);
//            fullArrange(nums,index+1);
//            swap(nums,j,index);
//        }
//
//    }
//    void swap(int[] nums , int i ,int j){
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }
//}
class Solution {

    List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {

        List<Integer> subList =new ArrayList<>();
        fullArrange(nums,subList);
        return resList;
    }
    void fullArrange(int[] nums,List<Integer> subList){
        if(subList.size()==nums.length){
            resList.add(new ArrayList<>(subList));
            return;
        }
        for(int i =0;i<nums.length;i++){
            if(!subList.contains(nums[i])){
                subList.add(nums[i]);
                fullArrange(nums,subList);
                subList.remove(subList.size()-1);
            }
        }
    }
}