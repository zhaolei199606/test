package test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 实现一个容器，有两个成员 add() getsize()
 * 创建两个线程，一个负责向容器中添加元素  ，一个用于容器的监控，当容器的元素有5个时报警
 */

public class TaoBaoCaseInterview {
        private volatile List<Integer> list = new ArrayList<>();

        public   void add(Integer elem){
            list.add(elem);
        }
        public int getSize(){
            return list.size();
        }

    public  static void main(String []args){
        TaoBaoCaseInterview c = new TaoBaoCaseInterview();
        CountDownLatch countDownLatch = new CountDownLatch(5);
        Thread t1 = new Thread( new Runnable(){//该线程实现监控
            public void run(){
                if(c.getSize() !=5){
                    try {
                        countDownLatch.await();//让当前调用本方法的线程阻塞
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("容器中的元素为5个");
            }
        });

        Thread t2 = new Thread (new Runnable(){//该线程负责添加元素
            public void run(){
                for(int i=0;i<10000;i++){
                    c.add(i);
                    System.out.println("添加元素 ："+i);
                    countDownLatch.countDown();
                    if(c.getSize()==5){
                        try {
                            Thread.sleep(2);//让本线程暂停，由于线程数量有限，所以在等待的时间内肯定
                            // 可以执行到监控线程，但是线程较多时这种方法就会出问题
                            //实际实现将监视和添加两个任务写成两个方法
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        });

        t1.start();//必须让监控线程先启动
        t2.start();
    }
}
