import java.util.Stack;

//使用两个栈模拟队列
public class problem9<E> {
    Stack<E> stack1 = new Stack<E>();
    Stack<E> stack2 = new Stack<E>();

    public void push(E e) {
        stack1.push(e);
    }

    public E pop() throws Exception {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.empty())
            throw new Exception("Queue is empty");
        else
            return stack2.pop();
    }

    public boolean empty() { //判断队是否为空
        return stack1.empty() && stack2.empty();
    }
}
