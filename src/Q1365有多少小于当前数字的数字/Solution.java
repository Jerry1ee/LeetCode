package Q1365有多少小于当前数字的数字;

import java.util.*;
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] sorted = Arrays.stream(nums).sorted().toArray();
        for (int i = 0; i < sorted.length; i++) {
            if (i == 0 || sorted[i] != sorted[i - 1]) {
                map.put(sorted[i], i);
            }
        }
        return Arrays.stream(nums).map(num -> map.get(num)).toArray();
    }
}