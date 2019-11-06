package Classes;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter implements Callable {

    private final int[] ARRAY; // Array to be worked on
    private final int offset; // Starting position in the array
    private AtomicInteger resultInt;
    private CounterManager counterManager;

    public Counter(int[] arr, int offset, AtomicInteger resultA, CounterManager daddy) {
        ARRAY = arr;
        this.offset = offset;
        resultInt = resultA;
        counterManager = daddy;
    }

    @Override
    public Object call() {
        int pos = offset;
        int counter = 0, partialResult = 0;
        while(pos < ARRAY.length && counter < CounterManager.WORK_AMOUNT){
            partialResult += ARRAY[pos];
            pos++;
            counter++;
        }
        /*
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("Task done after working " + counter + " items from position : " + offset + "! Result: " + partialResult + ".");
        resultInt.addAndGet(partialResult);
        counterManager.finishedTask();
        return null;
    }

}
