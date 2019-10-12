package server;

import java.net.Socket;

public class ServerConnection extends Thread {
	Socket connection;
	
	public ServerConnection(Socket serverConnection) {
		this.connection = serverConnection;
	}

}
