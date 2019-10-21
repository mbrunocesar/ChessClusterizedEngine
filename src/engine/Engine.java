package engine;

import messages.BoardPositionMessage;;

public class Engine extends Thread {
	BoardPositionMessage msg;
	
	boolean finished;
	
	Engine(BoardPositionMessage msg){
		this.msg = msg;
		finished = false;
		System.out.println("Started");
	}

	@Override
	public void run() {
		int processingCicles = 10;
		for (int i = 0; i < processingCicles; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				System.err.println("[ERROR] Thread Killed");
			}

			System.out.println("Processing...");
		}
		finished = true;
	}
	
	public void pseudoSuggestMove() {
		
	}
}
