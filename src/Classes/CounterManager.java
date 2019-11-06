package Classes;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CounterManager implements Callable {
    public static final int WORK_AMOUNT = 1000; // Max amount of items a worker can operate on

    private ExecutorService manager; // Pool of threads to be managed
    private int amount; // Amount of workers being managed
    private final int[] ARRAY; // Array to be worked on
    private AtomicInteger result;
    private Semaphore sm;
    
    public CounterManager(final int[] arr, int amount){
        manager = Executors.newFixedThreadPool(amount);
        this.amount = amount;
        ARRAY = arr;
        result = new AtomicInteger(0);
        sm = new Semaphore(0);
    }

    @Override
    public Object call() throws ExecutionException, InterruptedException {
        int offset = 0, counter = 0;
        long finish, start;

        /*
        while(offset < ARRAY.length) {
            Counter c = new Counter(ARRAY, offset, result, this);
            manager.submit(c);
            //future = manager.submit(c);
            //System.out.println("Future: " + future.get());
            offset += WORK_AMOUNT;
            counter++;
        }*/
        LinkedList tasks = new LinkedList();
        while(offset < ARRAY.length){
            tasks.add(new Counter(ARRAY,offset,result,this));
            offset += WORK_AMOUNT;
        }
        start = System.currentTimeMillis();
        manager.invokeAll(tasks);

        sm.acquire(counter); // Espera a que todos los tasks sean terminados
        finish = System.currentTimeMillis(); // End timing


        manager.shutdown();
        LinkedList list = new LinkedList();
        list.add(result);
        list.add((finish - start));
        return list;
    }

    public void finishedTask(){
        sm.release(1);
    }
}
