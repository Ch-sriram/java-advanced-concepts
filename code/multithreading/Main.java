package multithreading;

import java.util.concurrent.TimeUnit;

public class Main {
  public static void main(String[] args) {
    var currentThread = Thread.currentThread();
    System.out.println(currentThread.getClass().getName());
    
    // Thread class implements Runnable interface (functional interface), contains only `run()` method.
    
    System.out.println(currentThread);
//    // toString() of Thread class:
//    public String toString() {
//        ThreadGroup group = getThreadGroup();
//        if (group != null) {
//            return "Thread[" + getName() + "," + getPriority() + "," +
//                           group.getName() + "]";
//        } else {
//            return "Thread[" + getName() + "," + getPriority() + "," +
//                            "" + "]";
//        }
//    }
    printThreadState(currentThread);
    
    
    // We can also set the fields of a Thread inside the thread class as follows:
    currentThread.setName("MainGuy");
    // We can set priority from 1 to 10 for threads, but there are constants available by Thread class.
    currentThread.setPriority(Thread.MAX_PRIORITY); // same as: currentThread.setPriority(10);
    printThreadState(currentThread);
    
    // Thread class has 3 predefined priorities as constants:
    // Thread.MIN_PRIORITY = 1 (low)
    // Thread.NORM_PRIORITY = 5 (default)
    // Thread.MAX_PRIORITY = 10 (high)

    // Higher priority threads have a better change of being scheduled, by a thread scheduler over the lower priority threads.
    // However, behavior can vary across different operating systems and JVM implementations, for thread scheduling.
    // Thread Priority is more of a suggestion to the thread management system.
    
    // Creating a Thread Instance:
    // 1. Extend the Thread Class, and create an instance of this new subclass.
    // 2. Create a new instance of Thread, and pass it any instance that implements the Runnable interface. This includes passing a lambda expression.
    // 3. Use an Executor, to create one or more threads for you.
    
    CustomThread customThread = new CustomThread();
//    customThread.run(); // Runs the code synchronously
    customThread.start(); // To run concurrently, use start(). The start() method is a synchronized block of code.
    // Internally, Thread.start() makes a call to start0(), which is a native method, meaning, it's code is written using C++, or some DLL.
    
    // Runnable is a functional interface.
    // It's functional method, or its Single Access Method (SAM), is the `run()` method.
    // Anywhere you see a Runnable type, it's a target for a lambda expression.
    // You can any class implement the Runnable interface to run asynchronously.
    Runnable myRunnable = () -> { // this lambda expression is the implementation for `run()` method
    	for (int i = 0; i < 8; ++i) {
    		System.out.print(" 2 ");
    		try {
    			TimeUnit.MILLISECONDS.sleep(250);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    	}
    };

    // Creating the Thread from a Runnable implementation
    Thread myRunnableThread = new Thread(myRunnable);
    myRunnableThread.start();

    
    // This thread's execution.
    for (int i = 0; i < 3; ++i) {
    	System.out.print(" 0 ");
    	try {
    		TimeUnit.SECONDS.sleep(1);
    		// TimeUnit is an enum, on which there's a sleep implementation.
    	} catch (InterruptedException e) {
    		e.printStackTrace();
    	}
    }
    
    // Output:
    // 1  0  2  2  1  2  2  0  1  2  2  1  2  2  0  1
    // 1  0  2  2  1  2  2  0  1  2  2  1  2  2  0  1
    // 1  0  2  2  1  2  2  0  1  2  2  1  2  2  0  1
   }
  
  /**
   * Gets the details of a Thread.
   *
   * @param thread The actual thread.
   */
  public static void printThreadState(Thread thread) {
	System.out.println("------------------------");
	System.out.println("Thread ID: " + thread.getId());
	System.out.println("Thread Name: " + thread.getName());
	System.out.println("Thread Priority: " + thread.getPriority());
	System.out.println("Thread State: " + thread.getState());
	System.out.println("Thread Group: " + thread.getThreadGroup());
	System.out.println("Thread Is Alive: " + thread.isAlive());
	System.out.println("------------------------");
  }
}
