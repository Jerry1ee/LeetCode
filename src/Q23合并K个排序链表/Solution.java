package Q23合并K个排序链表;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：
 * 合并两个有序链表，转换为k个，即依次两两合并K-1次
 */

// Definition for singly-linked list.
  class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
        if(lists.length==1)return lists[0];
        for(int i =1;i<lists.length;i++)
        {
            lists[0] = mergeList(lists[0],lists[i]);
        }
        return lists[0];
    }

    ListNode mergeList(ListNode list1, ListNode list2)
    {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        while (list1!=null &&list2!=null)
        {
            if(list1.val>list2.val)
            {
                cur.next = list2;
                list2 = list2.next;
            }
            else {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }
        cur.next = list1==null?list2:list1;
        return pre.next;
    }
}