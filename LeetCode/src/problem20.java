import java.util.Stack;

public class problem20 {
    public boolean isValid(String s) {
        if ((s.length() & 1) == 1) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                char c = 0;
                if (!stack.empty()) c = stack.pop();
                if ((s.charAt(i) == ')' && c != '(') || (s.charAt(i) == '}' && c != '{') || (s.charAt(i) == ']' && c != '['))
                    return false;
            }
        }
        return stack.empty();
    }
}
