package server;

import java.net.Socket;

public class ServerToClientConnection extends Thread {
	Socket connection;
	MainServer mainReference;
	
	public ServerToClientConnection(Socket serverConnection, MainServer reference) {
		this.connection = serverConnection;
		this.mainReference = reference;
	}

	@Override
	public void start() {
		super.start();
		
		
	}

	@Override
	public void run() {
		
	}

}
