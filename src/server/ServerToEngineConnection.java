package server;

import java.net.Socket;

public class ServerToEngineConnection extends Thread {
	Socket connection;
	
	public ServerToEngineConnection(Socket serverConnection) {
		this.connection = serverConnection;
	}

	@Override
	public void start() {
		super.start();
		
		
	}

	@Override
	public void run() {
		
	}

}
