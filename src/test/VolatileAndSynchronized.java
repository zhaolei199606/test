package test;

/**
 * 使用volatile+synchronized变量的方式
 */
public class VolatileAndSynchronized {
  private volatile int num;

  public static void main(String[] args) {
    VolatileAndSynchronized test = new VolatileAndSynchronized();

    Thread t1 = new Thread (test::print);
    Thread t2 = new Thread (test::print);
    t1.start();
    t2.start();
  }
  public synchronized void print(){
    for(;num<=100;){
      System.out.println(Thread.currentThread().getName()+" : "+ num);
      num++;
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

