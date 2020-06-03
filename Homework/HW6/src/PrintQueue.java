import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Homework 6 PrintQueue
 * 
 * Implement the class below as specified in the
 * homework 6 document.
 * 
 * @author db2nb
 *
 */

// Don't forget to include the appropriate import statements

public class PrintQueue {

	private LinkedList<String> toPrint;     // the printer's list of documents
	private Lock documentChangeLock;  // a ReentrantLock lock
	private Condition hasPrintTask;   // a condition object
	private boolean isOn;             // boolean variable describing if the 
	// queue is on (accepting jobs)

	//TODO:  Handle locking and conditions around the
	//       enqueueing and dequeuing of documents
	//       in this PrintQueue's document list (toPrint)
	//       Note: See the BetterBestBank example in Bank.zip
	//       or in zip folder 'Thread Example 6 - Bank Deadlock' 
	//       on Collab.
	//       Bank.zip:  http://tinyurl.com/cs2110bank

	/**
	 * Constructor
	 */
	public PrintQueue() {
		toPrint = new LinkedList<String>(); // create the list of documents
		isOn = true; // turn on the print queue
	}

	/**
	 * method to return whethere the Printer Queue is on or off, essentially true or false
	 * @return isOn, true if the Printer Queues is on, false if it is off
	 */
	public boolean isOn() {
		return isOn;
	}

	/**
	 * tells the condition for the threads to wait and to shut off 
	 */
	public void turnOff() {
		hasPrintTask.awaitUninterruptibly();
		isOn = false;
	}

	/**
	 * enqueue takes a string and adds it to the queue
	 * TODO: Write more comments
	 */
	public void enqueue(String s) {
		// This seems dangerous
		documentChangeLock.lock();
		try {
			toPrint.add(s); // add to the list of documents
			hasPrintTask.signalAll();
		}finally {
			//unlocks this method no matter what happens inside
			documentChangeLock.unlock();
		}
	}

	/**
	 * dequeue
	 * TODO: Write more comments
	 */
	public String dequeue() {
		// This seems dangerous
		documentChangeLock.lock();
		try {
			return toPrint.remove(); // return the first document
		} finally {
			if (toPrint.isEmpty()) {
				//if the print queue is empty, it will tell the threads to sleep
				hasPrintTask.awaitUninterruptibly();
			}
			documentChangeLock.unlock();
		}
	}
}