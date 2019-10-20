package launcher;

import client.GameGUI;
import engine.EngineServer;
import server.MainServer;

public class Launcher {

	int numberOfEngines = 8;
	
	public static void main(String[] args) {
		new Launcher();
	}
	
	public Launcher() {
		try {
			for (int i = 0; i < numberOfEngines; i++) {
				EngineServer subServer = new EngineServer(i + 1);
				subServer.start();
			}
			
			try {
				Thread.sleep(3000);
				System.out.println("[STARTED] Engines");
			} catch (InterruptedException ex) {}

			MainServer mainServer = new MainServer(numberOfEngines);
			mainServer.start();
		
			try {
				Thread.sleep(3000);
				System.out.println("[STARTED] Main Server");
			} catch (InterruptedException ex) {}
			
			GameGUI gameUI = new GameGUI();
			gameUI.start();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
