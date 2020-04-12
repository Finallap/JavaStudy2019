package AntFinancial_20200316;

import java.util.Stack;

/**
 * @description: problem3
 * @date: 2020/3/16 20:41
 * @author: Finallap
 * @version: 1.0
 */
public class problem3 {
    String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < path.length(); i++) {
            String dirName = "";
            while (i < path.length() && path.charAt(i) != '/')
                dirName += path.charAt(i);

            if (!dirName.equals("..") && !dirName.equals("."))
                stack.push(dirName);

            if (stack.isEmpty() && dirName.equals(".."))
                stack.pop();
        }

        if (stack.isEmpty())
            return "/";

        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append("/" + stack.pop());
        }

        return sb.toString();
    }
}
