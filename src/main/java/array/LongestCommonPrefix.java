package array;

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 如果不存在公共前缀，返回空字符串 ""。
 示例 1:
 输入: ["flower","flow","flight"]
 输出: "fl"
 * @author Franco_Q
 * @date 2019/4/16 11:49
 */
public class LongestCommonPrefix {
    public String longestConmmonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        String head = null;
        String same = null;
        int minLength = getMinLength(strs);
        if (minLength == -1 || minLength == 0 ){
            return "";
        }
        A:for (int i = minLength ;i>0;i--) {
            B:for (int j=0;j<strs.length;j++) {
                if (head == null) {
                    head = strs[j].substring(0,i);
                }else {
                    if (head.equals(strs[j].substring(0,i))) {
                        same = head;
                        if (j==strs.length-1) {
                            return same;
                        }
                        continue B;
                    }else {
                        same=null;
                        head=null;
                        break B;
                    }
                }
            }
        }
        return same==null?"":same;
    }
    private static int getMinLength(String[] strs) {
        int length = -1;
        for (String s : strs) {
            if (length == -1) {
                length = s.length();
            }else {
                if (s.length() < length) {
                    length = s.length();
                }
            }
        }
        return length;
    }
}
