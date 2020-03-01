package Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: ObserverPattern:观察者模式
 * @date: 2020/3/1 10:20
 * @author: Finallap
 * @version: 1.0
 */
public class ObserverPattern {
    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        ConcreteObserver concreteObserver = new ConcreteObserver();
        ConcreteObserver2 concreteObserver2 = new ConcreteObserver2();

        concreteSubject.add(concreteObserver);
        concreteSubject.add(concreteObserver2);

        concreteSubject.notifyObservers();
    }
}

//抽象被观察订阅的目标
abstract class Subject {
    protected List<Observer> observers = new ArrayList<Observer>();

    //增加观察者方法
    public void add(Observer observer) {
        observers.add(observer);
    }

    //移除观察者
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    //通知观察者方法
    public abstract void notifyObservers();
}

class ConcreteSubject extends Subject {
    @Override
    public void notifyObservers() {
        System.out.println("具体目标发生改变...");
        System.out.println("--------------");

        for (Observer observer : observers) {
            observer.response();
        }
    }
}

//观察者的抽象
interface Observer {
    void response();
}

//实现具体的观察者
class ConcreteObserver implements Observer {
    @Override
    public void response() {
        System.out.println("具体观察者1作出反应！");
    }
}

class ConcreteObserver2 implements Observer {
    @Override
    public void response() {
        System.out.println("具体观察者2作出反应！");
    }
}