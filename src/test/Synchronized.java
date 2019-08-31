package test;

//用同步方法的方式，分为两个任务，注意 对象名::方法名的使用

/**
 * 用 资源----任务-----线程的方式就可以不用 对象名::方法名
 */
public class Synchronized{
  public static void main(String [] args){
    Synchronized test = new Synchronized();
    Thread t1 =new Thread (test::print1);
    Thread t2 =new Thread (test::print2);

    t1.start();
    t2.start();
  }
  public synchronized void print1(){//打印偶数
    int i=0;
    while(i<=100){
      System.out.println(Thread.currentThread().getName()+" : "+ i);
      i+=2;
      this.notify();//唤醒线程，但没有立即释放锁
      try {
        this.wait();//释放锁
        Thread.sleep(100);//占用cpu,让打印间隔明显
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

  }
  public synchronized void print2(){//打印奇数
    int i=1;
    while(i<=100){
      System.out.println(Thread.currentThread().getName()+" : "+ i);
      i+=2;
      this.notify();//唤醒线程，但没有立即释放锁
      try {
        this.wait();//释放锁
        Thread.sleep(100);//占用cpu,让打印间隔明显
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
