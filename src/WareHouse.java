import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class WareHouse {
    private final ArrayList<String> list = new ArrayList<>();
    private static final Logger logger = Logger.getLogger("log");
    private static final long MAX_NUMS = 20;

    private static final Lock lock = new ReentrantLock();
    private static final Condition notEmpty = lock.newCondition();
    private static final Condition notFull = lock.newCondition();

    public void put(String str) throws InterruptedException {
        lock.lock();
        while (list.size() >= MAX_NUMS) {
            System.out.println("队列已满等待消费者消费");
            notFull.await();
        }
        list.add(str);
        notEmpty.signal();
        lock.unlock();
    }

    public String get() throws InterruptedException {
        lock.lock();
        while (list.size() == 0) {
            System.out.println("队列为空,等待生产者消费。");
            notEmpty.await();
        }
        String res = list.remove(0);
        notFull.signal();
        lock.unlock();
        return res;
    }

    public int size() {
        return list.size();
    }
}
