package server;

import java.io.ObjectInputStream;
import java.net.Socket;

import messages.BoardPositionMessage;

public class ServerToClientConnection extends Thread {
	Socket clientConnection;
	Socket engineConnection;
	MainServer mainReference;
	
	public ServerToClientConnection(Socket serverConnection, MainServer reference) {
		this.clientConnection = serverConnection;
		this.mainReference = reference;
	}

	@Override
	public void start() {
		super.start();

		ObjectInputStream input;
		
		BoardPositionMessage msg = null;
		try {
			input = new ObjectInputStream(this.clientConnection.getInputStream());

			msg = (BoardPositionMessage) input.readObject();
			System.out.println("[Debug] Server received Client Board");
		} catch (Exception e) {
			System.out.println("[Debug] Empty");
		}
		
		
	}

	@Override
	public void run() {
		
	}

}
