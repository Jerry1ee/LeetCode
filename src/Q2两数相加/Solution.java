package Q2两数相加;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

 //Definition for singly-linked list.
  class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1==null)return l2;
        if(l2==null)return l1;
        ListNode tmp = new ListNode(0);
        ListNode reslist = tmp;
        while(l1!=null&&l2!=null)
        {
            tmp.next = new ListNode(l2.val+l1.val);
            tmp = tmp.next;
            l1=l1.next;
            l2=l2.next;
        }

        if(l2==null)
        {
            tmp.next = l1;
        }
        if(l1==null)
        {
            tmp.next = l2;
        }
        ListNode tmp2 = reslist;
        while(tmp2!=null)
        {
            if(tmp2.val>9)
            {
                if(tmp2.next!=null)
                {
                    tmp2.next.val += tmp2.val/10;
                }
                else{
                    tmp2.next= new ListNode(tmp2.val/10);
                }
                tmp2.val = tmp2.val%10;
            }

            tmp2 = tmp2.next;
        }

        return reslist.next;



    }
}
