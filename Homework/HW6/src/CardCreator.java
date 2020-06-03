import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Homework 6 Card Creator
 * 
 * This class defines the thread task that will
 * "come up with" and submit greeting card ideas
 * to the print queue.  We have added the code
 * necessary to read from the file, but it's up to
 * you to handle turning off the printer (keeping
 * track of how many threads are open) and adding
 * the read-in line from the inspiration file to
 * the queue.
 * 
 * @author YOURID
 *
 */
public class CardCreator implements Runnable {

	/**
	 * Print queue to add new card ideas
	 */
	private PrintQueue printQueue;

	/**
	 * Inspiration file name
	 */
	private String filename;

	private int threadCount;

	public CardCreator(PrintQueue d, String filename) {
		printQueue = d;
		this.filename = filename;
		threadCount = 0;
	}

	/**
	 * Run method that is the main method for the thread
	 */
	@Override
	public void run() {

		threadCount++;

		Scanner s = null;
		try {
			s = new Scanner(new FileReader(filename));
			while (s.hasNextLine()) {
				// TODO: Read the next line from the inspiration file
				// TODO: Enqueue the line into the print queue
				this.printQueue.enqueue(s.nextLine());
				try {
					this.wait(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			System.out.println("Could not read file");
		} finally {
			if (s != null)
				s.close();

			threadCount--;
			if(threadCount <= 1) {
				printQueue.turnOff();
			}

			// TODO: Turn off the print queue (if applicable)
			//       i.e., if you're the last card creator left
		}
	}

}