package Observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @description: CrudeOilFutures:继承java.util.Observable实现观察目标，实现java.util.Observer接口成为观察者
 * @date: 2020/3/1 11:22
 * @author: Finallap
 * @version: 1.0
 */
public class CrudeOilFutures {
    public static void main(String[] args) {
        OliFutures oliFutures = new OliFutures();
        Bull bull = new Bull();
        Bear bear = new Bear();

        oliFutures.addObserver(bear);
        oliFutures.addObserver(bull);
        oliFutures.setPrice(10);
        oliFutures.setPrice(-8);
    }
}

//具体目标类：原油期货
class OliFutures extends Observable {
    private float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        super.setChanged();
        super.notifyObservers();
        this.price = price;
    }
}

//具体观察者类：多方
class Bull implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        Float price = ((Float) arg).floatValue();
        if (price > 0) {
            System.out.println("油价上涨" + price + "元，多方高兴了！");
        } else {
            System.out.println("油价下跌" + (-price) + "元，多方伤心了！");
        }
    }
}

//具体观察者类：多方
class Bear implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        Float price = ((Float) arg).floatValue();
        if (price > 0) {
            System.out.println("油价上涨" + price + "元，空方伤心了！");
        } else {
            System.out.println("油价下跌" + (-price) + "元，空方高兴了！");
        }
    }
}