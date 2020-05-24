
//将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表

package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;
import leetcode.editor.cn.common.ListUtils;

public class LeetCode21MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution2 solution = new LeetCode21MergeTwoSortedLists().new Solution2();
        ListNode l1 = ListUtils.buildList(1, 2, 4);
        ListNode l2 = ListUtils.buildList(1, 3, 4);
        ListUtils.printList(solution.mergeTwoLists(l1,l2));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/****
 * 解法1:使用递归
 * l1和l2的第一个节点比较，较小的节点入选到结果，next指向剩下的阶段合并后的首节点
 * 递归退出条件：l1和l2有一个是空
 * @description
 * @author chenlei
 * @date 2020/5/22 6:12 PM
 * @version 1.0
 **/
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }

        if (l1.val <= l2.val){
            //l1指向剩下的节点合并后的首节点
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    /****
     * 解法2：使用迭代来代替递归，使用节点指针移动
     * @description
     * @author chenlei
     * @date 2020/5/22 6:11 PM
     * @version 1.0
     **/
    class Solution2 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            //用来快速定位到最终结果的首节点
            ListNode preHead = new ListNode(-1);
            //定义一个指针，用来遍历链表
            ListNode prev = preHead;

            while (l1 != null && l2 != null){
                if (l1.val <= l2.val){
                    prev.next = l1;
                    l1 = l1.next;
                    prev = prev.next;
                }else {
                    prev.next = l2;
                    l2 = l2.next;
                    prev = prev.next;
                }
            }

            //最后l1或者l2为空，剩下的连接到结果链表后
            if (l1 == null){
                prev.next = l2;
            }else {
                prev.next = l1;
            }
            return preHead.next;
        }
    }
}