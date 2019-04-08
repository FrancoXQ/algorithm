package array;

/**
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 示例 1：
 输入: "babad"
 输出: "bab"
 注意: "aba" 也是一个有效答案。
 * @author Franco_Q
 * @date 2019/4/8 15:52
 */
public class longestPalindrome {
    /**
     * 从中心出发寻找回文
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n<=1) {
            return s;
        }
        String longest = "";
        String str;
        for (int i =0 ;i<n-1;i++) {
            str = findPalindrome(s, i, i);
            if (str.length() > longest.length()) {
                longest = str;
            }
            str = findPalindrome(s, i, i+1);
            if (str.length() > longest.length()) {
                longest = str;
            }
        }
        return longest;
    }

    private String findPalindrome(String s, int left, int right) {
        int n = s.length();
        int l = left;
        int r = right;
        while (l>=0 && r<=n-1 && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l+1,r);
    }

}
