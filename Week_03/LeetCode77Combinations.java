//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode77Combinations {
    public static void main(String[] args) {
        Solution solution = new LeetCode77Combinations().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            if (k == n || k == 0) {
                List<Integer> row = new LinkedList<>();
                for (int i = 1; i <= k; ++i) {
                    row.add(i);
                }
                return new LinkedList<>(Arrays.asList(row));
            }
            // n - 1 里边选 k - 1 个
            List<List<Integer>> result = combine(n - 1, k - 1);
            //每个结果加上 n
            result.forEach(e -> e.add(n));
            //把 n - 1 个选 k 个的结果也加入
            result.addAll(combine(n - 1, k));
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}