package test;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现一个固定大小(下面指定为5)的阻塞同步容器，并且模拟多个生产者和多个消费者
 * 即当容器满时往里添加元素的线程就会被阻塞 当无元素时，向容器中取元素的线程就会被阻塞
 *
 */
public class ConsumerAndProvider {
    public static void main(String [] args){
        Mcollction c = new Mcollction();
        for(int i=0;i<10;i++){//模拟10个线程
            new Thread(new Runnable(){
                public void run(){
                    System.out.println("取出元素 ："+c.get());
                }
            }).start();//消费者
            new Thread(new Runnable(){
                public void run(){
                    c.put((int)Math.round(Math.random()*10));
                }
            }).start();
        }
    }
}

class Mcollction{
    private  List<Integer> list = new ArrayList<>(5);
    public synchronized void put(Integer elem){
        while(list.size()==5){//注意这个地方必须用while,不用while的话当线程被唤醒后它就不再判断是否满了
            //存在一个线程被唤醒到添加元素的这个时间段中容器又被填满的情况
            try {
                
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("添加元素 ："+elem);
        list.add(elem);
        notifyAll();//必须使用notifyAll()否则可能会造成死锁,但是使用notifyAll将唤醒所有线程
    }
    public synchronized Integer get(){
        while(list.size()==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
        return list.get(0);//取出第一个元素(错误)
    }                       //必须取出最开始一个元素，因为可能去元素的时候，容器中只有一个元素

}
