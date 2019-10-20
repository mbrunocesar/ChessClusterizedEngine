package engine;

import java.io.ObjectInputStream;
import java.net.Socket;

import messages.ServerToEngineMessage;

public class EngineToServerConnection extends Thread {
	Socket connection;
	Engine engine;
	
	EngineToServerConnection(Socket serverConnection){
		this.connection = serverConnection;
	}

	@Override
	public void start() {
		super.start();
		
		ObjectInputStream input;
		
		ServerToEngineMessage msg = null;
		try {
			input = new ObjectInputStream(this.connection.getInputStream());

			msg = (ServerToEngineMessage) input.readObject();
			System.out.println(msg);
		} catch (Exception e) {
			System.out.println("[Debug] Empty");
		}

		System.out.println(this.engine);
		if (msg != null) {
			this.engine = new Engine(msg);
			this.engine.start();
		}
	}

	@Override
	public void run() {
		while (engine == null || engine.finished == false) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				System.err.println("[ERROR] Thread Killed");
			}

			System.out.println("Running...");
		}

		System.out.println("Finished!");
	}
}
