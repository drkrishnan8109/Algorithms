package Code.RandomAlgos;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class RateLimiter{

    /*
    * 1. user requests - Based on userId, store count - ConcurrentHashMap
    * 2. Concurrent users
    * 3. Expire after a minute (TODO)
    * 4. Fixed threshold config
    * */

    private ConcurrentHashMap<Integer, Integer> userCountMap;
    Integer threshold;

    private RateLimiter(Integer threshold) {
        userCountMap = new ConcurrentHashMap<>();
        this.threshold = threshold;
    }

    // Dont use this, merge and getOrDefault is preferred for threadSafety
    // public boolean incrementUserCount(Integer userId) {
    //     if(!userCountMap.containsKey(userId)) {
    //         userCountMap.put(userId,1);
    //         return true;
    //     }
    //     else if (allow(userId)) {
    //         userCountMap.put(userId,userCountMap.get(userId)+ 1);
    //         return true;
    //     }
    //     return false;
    // }

    public boolean incrementUserCount(Integer userId) {
        //This keeps incrementing the count irrepesctive of threshold, thats is ok since 
        //the result returned to caller verifies the threshold. For eg, when count is 100, it increments to 101, returns false.
        //then when count is 101, it increments to 102, but returns false etc...;
        int newCount = userCountMap.merge(userId, 1, (oldValue, newValue) -> oldValue + 1);
        return newCount <= threshold;
    }

    //A test that checks one thread keeps incrementing the values in a loop, 
    //and several such threads can be run parrelly by the caller
    public static void increment(int userId, int threshold, RateLimiter rateLimiter){
        int currCount=0;
        boolean success = true;
        while(currCount<threshold && success) {
            success = rateLimiter.incrementUserCount(userId);
            currCount++;
           try {
            System.out.println("Thread Id + " + Thread.currentThread());
            Thread.sleep(1000);
        }catch(InterruptedException e) {
            //handle properly
        }

        }
        System.out.println("Requests for user " + userId + " exceeds threshold " + threshold + "at: " + System.currentTimeMillis());
    }

    public static void main(String args[]) throws Exception {
        RateLimiter rateLimiter = new RateLimiter(10);

        int count1 = 2000, count2 = 5000, count3 = 4000;
        int userId1 = 11, userId2 =33, userId3 = 54;

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CountDownLatch latch = new CountDownLatch(3);
       
        try {
            //ExecutorService needs Runnable or Callable tasks.
            //Runnale return nothing, Callable returns a value.
            //Lambda using () in submit function, automatically creates Runnable Task.
            //If the task returns value(i.e when task is Callable), We can use Futures to get the value.
            executorService.submit(() -> {increment(userId1,count1, rateLimiter); latch.countDown();});
            executorService.submit(() -> {increment(userId2,count2, rateLimiter); latch.countDown();});
            executorService.submit(() -> {increment(userId3,count3, rateLimiter); latch.countDown();});
    
            latch.await();
            System.out.print("All tasks are finished");
            }
            catch(Exception e) {
                System.out.print("ExceInterruptedException at latch waiting");
                throw e;
            }

            executorService.shutdown();
        
    }

    public void callableImplementationTest() {
        RateLimiter rateLimiter = new RateLimiter(10);
        ExecutorService executorService = Executors.newCachedThreadPool();

        int userId1 = 11, userId2 =33, userId3 = 54;
          
        try {
            //ExecutorService needs Runnable or Callable tasks.
            //Runnale return nothing, Callable returns a value.
            //Lambda using () in submit function, automatically creates Runnable Task.
            //If the task returns value(i.e when task is Callable), We can use Futures to get the value.
            Future<Boolean> future1 = executorService.submit(() -> incrementUserCount(userId1));
            Future<Boolean> future2 = executorService.submit(() -> incrementUserCount(userId2));
            Future<Boolean> future3 = executorService.submit(() -> incrementUserCount(userId3));
            

            ArrayList<Future<Boolean>> futures = new ArrayList<>();

            System.out.print("All tasks are finished");
            }
            catch(Exception e) {
                System.out.print("ExceInterruptedException at latch waiting");
                throw e;
            }

            executorService.shutdown();
        
    }
    }
}