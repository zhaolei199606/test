import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        HashMap<String,String> map = new HashMap<>();
        map.put("name:","zhaolei");
        map.put("age:","21");
        map.put("tall:","170");
        Set<Map .Entry<String,String>> set = map.entrySet();
        Iterator<Map.Entry<String,String>> it = set.iterator();
        while(it.hasNext()){
            Map.Entry<String,String> mapEntry = it.next();
            System.out.println(mapEntry.getKey()+": "+mapEntry.getValue());
        }
        ReentrantLock lock = new ReentrantLock();

        }
    }

