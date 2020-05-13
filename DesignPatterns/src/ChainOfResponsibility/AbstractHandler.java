package ChainOfResponsibility;

/**
 * @description: AbstractHandler
 * @date: 2020/5/13 11:44
 * @author: Finallap
 * @version: 1.0
 */
public abstract class AbstractHandler {
    protected AbstractHandler nextHandler;

    public void setNextHandler(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(int parameter);
}
