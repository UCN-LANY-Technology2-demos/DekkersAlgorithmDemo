

public class Dekkers {
	public static void main(String[] args) {
		
		IBuffer buffer = new Buffer();
		IMutex mutex = new Mutex2();
		
		Producer prod = new Producer(buffer, mutex);
		Consumer cons = new Consumer(buffer, mutex);
		
		// Starting both threads		
		prod.start();
		cons.start();
	}
}
