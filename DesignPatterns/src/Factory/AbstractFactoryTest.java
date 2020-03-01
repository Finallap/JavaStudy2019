package Factory;

/**
 * @description: AbstractFactoryTest:抽象工厂模式
 * @date: 2020/3/1 16:57
 * @author: Finallap
 * @version: 1.0
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        AbstractFactory1 miFactory = new MiFactory();
        AbstractFactory1 appleFactory = new AppleFactory();
        miFactory.makePC();
        miFactory.makePhone();
        appleFactory.makePC();
        appleFactory.makePhone();
    }
}

interface PC {
    void make();
}

class MiPC implements PC {
    public MiPC() {
        this.make();
    }

    @Override
    public void make() {
        System.out.println("make xiaomi PC!");
    }
}

class MAC implements PC {
    public MAC() {
        this.make();
    }

    @Override
    public void make() {
        System.out.println("make MAC!");
    }
}

interface Phone {
    void make();
}

class MiPhone implements Phone {
    public MiPhone() {
        this.make();
    }

    @Override
    public void make() {
        System.out.println("make xiaomi phone!");
    }
}

class IPhone implements Phone {
    public IPhone() {
        this.make();
    }

    @Override
    public void make() {
        System.out.println("make iphone!");
    }
}

interface AbstractFactory1 {
    Phone makePhone();

    PC makePC();
}

class MiFactory implements AbstractFactory1 {
    @Override
    public MiPhone makePhone() {
        return new MiPhone();
    }

    @Override
    public MiPC makePC() {
        return new MiPC();
    }
}

class AppleFactory implements AbstractFactory1 {
    @Override
    public IPhone makePhone() {
        return new IPhone();
    }

    @Override
    public MAC makePC() {
        return new MAC();
    }
}