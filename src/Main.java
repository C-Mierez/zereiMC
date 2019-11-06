import Classes.CounterManager;
import Utiles.*;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Variables
        final int ARRAY_SIZE; // Size of the array to be computed
        final int THREAD_AMOUNT; // Amount of threads to be created
        final int[] ARRAY; // Array to be worked on by the threads
        Future<Integer> endResult;
        Scanner scanner; // Scanner
        ExecutorService singleManager;
        CounterManager cm; // In charge of creating the worker threads
        long start, finish; // For measuring time
        Object res;

        // Real deal
        scanner = new Scanner(System.in);

        // Ask for data
        System.out.print("Input the amount of Items to compute: ");
        ARRAY_SIZE = scanner.nextInt();
        System.out.print("Input the amount of Threads to create: ");
        THREAD_AMOUNT = scanner.nextInt();

        // More real deal
        ARRAY = createArray(ARRAY_SIZE); // Create array full of integers

        cm = new CounterManager(ARRAY, THREAD_AMOUNT); // Create the worker thread manager (which creates worker threads)
        // This is unnecessary but I wanted to try using the Future class
        /*
        singleManager = Executors.newSingleThreadExecutor(); // Create executor for the manager ^


        endResult = singleManager.submit(cm); // Execute the manager in the executor
        res = endResult.get();
        singleManager.shutdown();
        */
        res = cm.call();

        System.out.println("The result from adding all elements is: " + ((LinkedList)res).getFirst() + ". Time spent: " + ((LinkedList)res).getLast() + "ms."); // Show results

    }

    private static int[] createArray(final int ARRAY_SIZE){
        int[] arr = new int[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE; i++){
            arr[i] = Aleatorio.intAleatorio(1,10); // Integers between 1 and 10
        }
        return arr;
    }

}
