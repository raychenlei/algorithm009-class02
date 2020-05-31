//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表

package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode94BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new LeetCode94BinaryTreeInorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            traversal(root, res);
            return res;
        }

        private void traversal(TreeNode root, List<Integer> res) {
            if (root == null) return;
            traversal(root.left, res);
            res.add(root.val);
            traversal(root.right, res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}