package ChainOfResponsibility;

/**
 * @description: ConcreteHandler2
 * @date: 2020/5/13 12:10
 * @author: Finallap
 * @version: 1.0
 */
public class ConcreteHandler2 extends AbstractHandler {
    @Override
    public void handleRequest(int parameter) {
        if (parameter <= 100) {
            System.out.format("%s处理了请求，parameter<=100\n", this.getClass().getSimpleName());
        } else if (nextHandler != null) {
            this.nextHandler.handleRequest(parameter);
        }
    }
}
