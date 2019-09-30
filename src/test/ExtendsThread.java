package test;

/**
 * 子类方法可以调用父类同步方法，并且不会造成死锁吗？
 *
 * 注意：子类可以调用父类同步方法，并且不会造成死锁
 * 因为子类的同步方法与父类的同步方法是不同的锁，并且被这两个锁锁定的代码块不会
 * 相互调用。
 * 父类方法是不能调用子类的，否则会发生init()方法异常
 *
 */
public class ExtendsThread {
    public static void main(String []args){
        Zi zi = new Zi();
        zi.print1();
    }
}

class Fu{
    Zi zi = new Zi();
    public synchronized void print1(){
        System.out.println("这是父类方法");
        zi.print2();
    }


}

class Zi extends Fu{
    public synchronized void print2(){
        System.out.println("这是子类方法");
        super.print1();
    }
}
