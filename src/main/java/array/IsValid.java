package array;

import com.sun.deploy.util.StringUtils;

import java.util.Stack;

/**
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 有效字符串需满足：
 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串。
 * @author Franco_Q
 * @date 2019/4/18 11:40
 */
public class IsValid {
    public boolean isValis(String s) {
        if (s == null || s.length() ==0) {
            return true;
        }
        final char[] charArray = s.toCharArray();
        final Stack<Character> stack = new Stack<Character>();
        for (char c : charArray) {
            if (c == '(' || c == '{' || c == '[') {
                stack.add(c);
            }else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                if (c==')' && stack.peek() == '(') {
                    stack.pop();
                }else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
