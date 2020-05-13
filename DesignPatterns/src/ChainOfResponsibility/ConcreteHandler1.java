package ChainOfResponsibility;

/**
 * @description: ConcreteHandler1
 * @date: 2020/5/13 11:48
 * @author: Finallap
 * @version: 1.0
 */
public class ConcreteHandler1 extends AbstractHandler {
    @Override
    public void handleRequest(int parameter) {
        if (parameter <= 10) {
            System.out.format("%s处理了请求，parameter<=10\n", this.getClass().getSimpleName());
        } else if (nextHandler != null) {
            this.nextHandler.handleRequest(parameter);
        }
    }
}
