

public class Mutex3 implements IMutex {

	private static boolean producerThreadWantsToEnter = false; 
	private static boolean consumerThreadWantsToEnter = false;
	
	@Override
	public void enterMutex() {
		
		System.out.println(Thread.currentThread().getName() + " entering");
		
		switch(Thread.currentThread().getName()) {
		case "Producer":
			producerThreadWantsToEnter = true;
			while(consumerThreadWantsToEnter) {}	
			break;
		case "Consumer":
			consumerThreadWantsToEnter = true;
			while(producerThreadWantsToEnter) {}
			break;
		}	
		System.out.println(Thread.currentThread().getName() + " entered" );
	}
	
	@Override
	public void exitMutex() {
		
		System.out.println(Thread.currentThread().getName() + " exiting");
		
		switch(Thread.currentThread().getName()) {
		case "Producer":
			producerThreadWantsToEnter = false;
			break;
		case "Consumer":
			consumerThreadWantsToEnter = false;
			break;
		}	
		
		System.out.println(Thread.currentThread().getName() + " exited, consumerThreadWantsToEnter = "+ consumerThreadWantsToEnter +", producerThreadWantsToEnter = "+ producerThreadWantsToEnter);
	}
	

}
