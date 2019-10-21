package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
		
		BoardPositionMessage message = null;
		try {
			input = new ObjectInputStream(this.clientConnection.getInputStream());

			message = (BoardPositionMessage) input.readObject();
			System.out.println("[Debug] Server received Client Board");
		
			
			ObjectOutputStream os = new ObjectOutputStream(engineConnection.getOutputStream());
			os.writeObject(message);
		} catch (Exception e) {
			System.out.println("[Debug] Empty");
		}

	}

	@Override
	public void run() {
		
	}

}
