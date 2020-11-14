package Q1122数组的相对排序;

/*
给你两个数组，arr1 和 arr2，

arr2 中的元素各不相同
arr2 中的每个元素都出现在 arr1 中
对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。

 

示例：

输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
输出：[2,2,2,1,4,3,3,9,6,7,19]
 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/relative-sort-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/*
 两种方案
 */
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //找出arr1中最大的数字 upper，然后创建长度为 upper+1 times数组
        int upper = 0;
        for(int i : arr1){
            upper = Math.max(upper,i);
        }
        int[] times = new int[upper+1];
        //遍历arr1 数组，将每个数字出现的次数记录在times数组中
        for(int i : arr1){
            times[i]++;
        }
        //创建res数组作为返回结果
        int[] res = new int[arr1.length];
        //遍历arr2数组，检查times数组中当前arr2中元素的数量
        //将arr2中元素按times中数量添加到res数组中
        int index = 0;
        for(int i : arr2){
            while(times[i]>0){
                res[index++] = i;
                times[i] -= 1;
            }
        }
        //再遍历一遍times数组，找到数量不为0的元素，加入res数组
        for(int i=0;i<times.length;i++){
            while(times[i]>0){
                res[index++] = i;
                times[i] -= 1;
            }
        }
        return res;
    }
}
/*
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
    将arr1转换为list
        List<Integer> list = new ArrayList();
        for(int i : arr1){
            list.add(i);
        }
        把arr2存入哈希表，元素值为key，元素的下标为value，注意这里下标值一定不会超过1000
        Map<Integer,Integer> map = new HashMap();
        for(int i=0;i<arr2.length;i++){
            map.put(arr2[i],i);
        }
        自定义collections的排序函数，arr2包括的且下标靠前的则 "小"
        Collections.sort(list, (x,y) ->{
            if(map.containsKey(x)||map.containsKey(y)) return map.getOrDefault(x,1001)-map.getOrDefault(y,1001);
            return x-y;
        });
        for(int i =0;i<arr1.length;i++){
            arr1[i] = list.get(i);
        }
        return arr1;
    }
}
 */

