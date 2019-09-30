package test;

public class SynchronizedAndRun implements Runnable{
    private int num=0;
    //private boolean flag=
    public synchronized void run(){
        while (num<=100){
            System.out.println(Thread.currentThread().getName()+" : "+num);
            num++;
            notify();//唤醒想申请同一把锁的线程
            try {
                Thread.sleep(100);
                wait(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String []args){
        SynchronizedAndRun run=new SynchronizedAndRun();
        Thread t1= new Thread(run);
        Thread t2 = new Thread(run);
        t1.start();
        t2.start();
    }
}
