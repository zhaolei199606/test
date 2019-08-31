
//用两个线程交替打印奇数和偶数

/**
 * 用同步方法的方式，分为两个任务，注意 对象名::方法名的使用
 */
/*public class Test{
  public static void main(String [] args){
    Test test = new Test();
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
}*/


/**
 * 使用volatile+synchronized变量的方式
 */
public class Test {
  private volatile int num;

  public static void main(String[] args) {
    Test test = new Test();

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


