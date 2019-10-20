package client;

import java.net.Socket;

public class ClientToServerConnection extends Thread {
	Socket connection;
	
	public ClientToServerConnection(Socket serverConnection) {
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
