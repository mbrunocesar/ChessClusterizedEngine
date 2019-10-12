package launcher;

import engine.EngineServer;
import server.MainServer;

public class Launcher {

	public static void main(String[] args) {
		new Launcher();
	}
	
	public Launcher() {
		try {
			EngineServer subServer1 = new EngineServer(1);
			subServer1.start();
			EngineServer subServer2 = new EngineServer(2);
			subServer2.start();
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException ex) {
				System.err.println("[ERROR] Thread Killed");
			}
			
			MainServer mainServer = new MainServer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
