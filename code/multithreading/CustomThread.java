package multithreading;

public class CustomThread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.print(" 1 ");
			try {
				Thread.sleep(500); // Adding 0.5 second delay between each count.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
