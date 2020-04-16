package ShuffleAnArray;

/**
 * 打乱一个没有重复元素的数组。
 *
 * 示例:
 *
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 *
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 *
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 */

import java.util.*;

class Solution {
    private int[] arrays ;
    Random random = new Random(31);
    public Solution(int[] nums) {

        this.arrays = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return arrays;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] array = arrays.clone();
        for(int i =0;i<array.length;i++)
        {
            swap(array,i,randRange(i,array.length));
        }
        return array;

    }
    public void swap(int[] array,int i,int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private int randRange(int min, int max) {
        return random.nextInt(max - min) + min;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
