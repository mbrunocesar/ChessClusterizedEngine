package server;

import java.net.Socket;

public class ClientToServerConnection extends Thread {
	Socket connection;
	
	public ClientToServerConnection(Socket serverConnection) {
		this.connection = serverConnection;
	}

}
