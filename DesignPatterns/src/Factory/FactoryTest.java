package Factory;

/**
 * @description: Factory:简单工厂模式，工厂方法模式
 * @date: 2020/3/1 15:33
 * @author: Finallap
 * @version: 1.0
 */
public class FactoryTest {
    public static void main(String[] args) {
        //简单工厂模式
        Factory factory = new Factory();
        ConcreteProduct1 concreteProduct1 = (ConcreteProduct1) factory.getProduct("ConcreteProduct1");
        ConcreteProduct2 concreteProduct2 = (ConcreteProduct2) factory.getProduct("ConcreteProduct2");
        concreteProduct1.show();
        concreteProduct2.show();

        //工厂方法模式
        AbstractFactory concreteFactory1 = new ConcreteFactory1();
        AbstractFactory concreteFactory2 = new ConcreteFactory2();
        ConcreteProduct1 concreteProduct1_1 = (ConcreteProduct1) concreteFactory1.getProduct();
        ConcreteProduct2 concreteProduct2_1 = (ConcreteProduct2) concreteFactory2.getProduct();
        concreteProduct1_1.show();
        concreteProduct2_1.show();
    }
}

//抽象产品
interface AbstractProduct {
    void show();
}

//创建具体的产品
class ConcreteProduct1 implements AbstractProduct {
    @Override
    public void show() {
        System.out.println("具体产品1显示...");
    }
}

class ConcreteProduct2 implements AbstractProduct {
    @Override
    public void show() {
        System.out.println("具体产品2显示...");
    }
}

//简单工厂
class Factory {
    public AbstractProduct getProduct(String productName) {
        if (productName.equalsIgnoreCase("ConcreteProduct1")) {
            return new ConcreteProduct1();
        } else if (productName.equalsIgnoreCase("ConcreteProduct2")) {
            return new ConcreteProduct2();
        } else {
            return null;
        }
    }
}

interface AbstractFactory {
    AbstractProduct getProduct();
}

class ConcreteFactory1 implements AbstractFactory {
    @Override
    public ConcreteProduct1 getProduct() {
        return new ConcreteProduct1();
    }
}

class ConcreteFactory2 implements AbstractFactory {
    @Override
    public ConcreteProduct2 getProduct() {
        return new ConcreteProduct2();
    }
}