//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode242ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new LeetCode242ValidAnagram().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            //计数法，用hashMap存各个元素出现的次数，当在s中出现时计数加一，在t中出现时计数减一，最后如果map里的value全是0，则返回true
            if (s.length() != t.length()) return false;
            Map<Character, Integer> map = new HashMap<>();
            for(int i = 0; i < s.length(); i ++){
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
                map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
            }
            for (Integer value : map.values()) {
                if (value != 0) return false;
            }
            return true;

        }
    }

    class Solution2 {
        public boolean isAnagram(String s, String t) {
            //sort，比较
            char[] charsS = s.toCharArray();
            char[] charsT = t.toCharArray();
            Arrays.sort(charsS);
            Arrays.sort(charsT);
            return String.valueOf(charsS).equals(String.valueOf(charsT));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}