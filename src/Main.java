import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        WareHouse wareHouse = new WareHouse();
        Producer producer = new Producer(wareHouse, "producer");
        Producer producer1 = new Producer(wareHouse, "producer1");
        Consumer consumer = new Consumer(wareHouse, "consumer");
        Consumer consumer1 = new Consumer(wareHouse, "consumer1");
        Consumer consumer2 = new Consumer(wareHouse, "consumer2");
        service.submit(producer);
        service.submit(producer1);
        service.submit(consumer);
        service.submit(consumer1);
        service.submit(consumer2);
    }
}
