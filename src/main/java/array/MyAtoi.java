package array;

/**
 * 字符串转换整数
 * 示例 1:
 输入: "42"
 输出: 42
 示例 2:
 输入: "   -42"
 输出: -42
 解释: 第一个非空白字符为 '-', 它是一个负号。
 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 示例 3:
 输入: "4193 with words"
 输出: 4193
 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 示例 4:
 输入: "words and 987"
 输出: 0
 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 因此无法执行有效的转换。
 示例 5:
 输入: "-91283472332"
 输出: -2147483648
 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 因此返回 INT_MIN (−231) 。
 * @author Franco_Q
 * @date 2019/4/15 11:26
 */
public class MyAtoi {
    public int myAtoi(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        int flag = 1,i=0;
        long result = 0;
        //判断空字符的个数，并且确定空字符结束的位置
        while(i<str.length() && str.charAt(i)==' ') {
            i++;
        }
        //如果统计的空字符个数与字符串长度相同，则判断为这个空字符，不能转换
        if (i == str.length()) {
            return 0;
        }
        //由于上面是i++，所以此时i为空字符之后的第一个非空字符的索引值，此位置判断为flag为正还是负的位置，并分别赋值
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            flag = str.charAt(i) == '+'?1:-1;
            i++;
        }
        //过去这符号位之后，应该是判断是否是数字字符，如果不是则不会执行下面的for循环，
        //并且下一位不是数字则其不会再进行while循环
        while(i <str.length() && str.charAt(i)>='0' && str.charAt(i) <='9') {
            result = 10 * result+(str.charAt(i++) - '0');
            if (result > Integer.MAX_VALUE) {
                return flag==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
        }
        return Integer.parseInt(String.valueOf(result*flag));

    }
}
