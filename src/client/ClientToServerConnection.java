package client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import board.Board;
import messages.BoardPositionMessage;

public class ClientToServerConnection extends Thread {
	Socket connection;
	Board board;
	
	public ClientToServerConnection(Socket serverConnection, Board currentBoard) {
		this.connection = serverConnection;
		this.board = currentBoard;
	}

	@Override
	public void start() {
		super.start();
		
		try {
			Socket socketToMainServer = new Socket("localhost", 5000);
			this.connection = socketToMainServer;
			
			BoardPositionMessage message = new BoardPositionMessage(this.board, "e2-e4", true, 3);
			
			ObjectOutputStream os = new ObjectOutputStream(socketToMainServer.getOutputStream());
			os.writeObject(message);
			// engineSocket.close();
		} catch (Exception e) {
			System.err.println("[ERROR] Failed to connect: client - server");
		}
	}

	@Override
	public void run() {
		
	}

}
