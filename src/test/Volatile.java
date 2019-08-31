package test;

/**
 * 用volatile的方式
 * 应该采用 资源----任务-----线程 并且这种情况传给任务的资源只能是一个，即要采用引用传递
 *
 */
public class Volatile {
  static volatile int num = 0;
  static volatile boolean flag = false;

  public static void main(String[] args) {

    Thread t1 = new Thread(() -> {
      for (; 100 > num; ) {
        if (!flag && (num == 0 || ++num % 2 == 0)) {

          try {
            Thread.sleep(100);// 防止打印速度过快导致混乱
          } catch (InterruptedException e) {
            //NO
          }
          System.out.println(Thread.currentThread().getName()+": "+num);
          flag = true;
        }
      }
    }
    );

    Thread t2 = new Thread(() -> {
      for (; 100 > num; ) {
        if (flag && (++num % 2 != 0)) {

          try {
            Thread.sleep(100);// 防止打印速度过快导致混乱
          } catch (InterruptedException e) {
            //NO
          }
          System.out.println(Thread.currentThread().getName()+": "+num);
          flag = false;
        }
      }
    }
    );

    t1.start();
    t2.start();

  }
}
