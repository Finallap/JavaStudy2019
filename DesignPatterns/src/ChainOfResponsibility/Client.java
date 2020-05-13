package ChainOfResponsibility;

/**
 * @description: Client
 * @date: 2020/5/13 12:12
 * @author: Finallap
 * @version: 1.0
 */
public class Client {
    private static AbstractHandler getHandlerChain() {
        AbstractHandler handler1 = new ConcreteHandler1();
        AbstractHandler handler2 = new ConcreteHandler2();

        handler1.setNextHandler(handler2);

        return handler1;
    }

    public static void main(String[] args) {
        AbstractHandler handlerChain = getHandlerChain();

        handlerChain.handleRequest(5);
        handlerChain.handleRequest(55);
        handlerChain.handleRequest(155);
        handlerChain.handleRequest(32);
    }
}
