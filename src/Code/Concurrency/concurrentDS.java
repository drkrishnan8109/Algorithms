package Code.Concurrency;
import java.util.concurrent.ConcurrentHashMap;

public static void main(String args[]) {
	ConcurrentHashMap concurrentHmap = new ConcurrentHashMap<Integer,String>();

	//If 101 not present, nothing happens.
	//If 101 present with null value, removes the key.
	concurrentHmap.computeIfPresent("101", (key, value) -> value + 10);

	//true indicates fairness - FIFO for threads accessing the blcokingqueue
	BlockingQueue<String> queue = new ArrayBlockingQueue<>(100,true);

	//put() blocks if the queue is full, and take() blocks if the queue is empty.
	queue.put("blockingput"); 
	String consumedValue = queue.take();

	//Instead of blocking methods, use non blocking methods with timeouts
	//If the insertion into queue doesnt happen within 2 seconds, then do something
	//offer is non-blocking
	if(!queue.offer("value", 2, TimeUnit.SECONDS)) {
	}

	try {
		queue.put("somevalue");
	}catch(InterruptedException e) { //InterruptedException is important to handle 
		Thread.currentThread.interrupt(); //Preserve interrupt status
	}


	//Async processing
	CompleatableFutures<AsyncResultSet> future =
		session.executeAsync("SELECT * from myTable imit 10");
	future.whenComplete((resultSet, throwable) -> {
		if(throwable == null) {
			//Process valid data
		}
		else {
			//Handle error
		}
	});

}