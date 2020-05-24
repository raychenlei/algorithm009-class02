
//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组

package leetcode.editor.cn;

import java.util.Arrays;

public class LeetCode66PlusOne {
    public static void main(String[] args) {
        Solution solution = new LeetCode66PlusOne().new Solution();
        System.out.println(Arrays.toString(solution.plusOne(new int[]{9,9,9})));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            int length = digits.length;
            for (int i = length -1; i >= 0 ; i--) {
                digits[i]++;
                digits[i] = digits[i] % 10;
                //只有是0的时候才进位
                if (digits[i] != 0) {
                    return digits;
                }
            }
            //最高位进位，其余各位都是0
            int[] result = new int[length + 1];
            result[0] = 1;
            return result;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}