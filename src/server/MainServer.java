package server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.LinkedList;

import board.Pieces;
import messages.ServerToEngineMessage;

public class MainServer extends Thread {
	
	boolean sigKill = false;

	ServerSocket serverSocket;

	LinkedList<Socket> clientConnections;
	LinkedList<Socket> engineConnections;


	public MainServer() throws IOException, ClassNotFoundException {
		// Create a Server Socket for the Engine
		serverSocket = new ServerSocket(5000);
		System.out.println("[DEBUG] Main Server Listening...");

		clientConnections = new LinkedList<Socket>();
		engineConnections = new LinkedList<Socket>();
		
		Pieces[][] initialBoard = {
				{
					Pieces.WhiteRock, Pieces.WhiteKnight, Pieces.WhiteBishop, Pieces.WhiteQueen,
					Pieces.WhiteKing, Pieces.WhiteBishop, Pieces.WhiteKnight, Pieces.WhiteRock
				},
				{
					Pieces.WhitePawn, Pieces.WhitePawn, Pieces.WhitePawn, Pieces.WhitePawn,
					Pieces.WhitePawn, Pieces.WhitePawn, Pieces.WhitePawn, Pieces.WhitePawn
				},
				{
					Pieces.Empty, Pieces.Empty, Pieces.Empty, Pieces.Empty,
					Pieces.Empty, Pieces.Empty, Pieces.Empty, Pieces.Empty
				},
				{
					Pieces.Empty, Pieces.Empty, Pieces.Empty, Pieces.Empty,
					Pieces.Empty, Pieces.Empty, Pieces.Empty, Pieces.Empty
				},
				{
					Pieces.Empty, Pieces.Empty, Pieces.Empty, Pieces.Empty,
					Pieces.Empty, Pieces.Empty, Pieces.Empty, Pieces.Empty
				},
				{
					Pieces.Empty, Pieces.Empty, Pieces.Empty, Pieces.Empty,
					Pieces.Empty, Pieces.Empty, Pieces.Empty, Pieces.Empty
				},
				{
					Pieces.BlackPawn, Pieces.BlackPawn, Pieces.BlackPawn, Pieces.BlackPawn,
					Pieces.BlackPawn, Pieces.BlackPawn, Pieces.BlackPawn, Pieces.BlackPawn
				},
				{
					Pieces.BlackRock, Pieces.BlackKnight, Pieces.BlackBishop, Pieces.BlackQueen,
					Pieces.BlackKing, Pieces.BlackBishop, Pieces.BlackKnight, Pieces.BlackRock
				}
			};
		ServerToEngineMessage initialBoardMessage = new ServerToEngineMessage(initialBoard, null, true, 3);

		
		Socket engineSocket = new Socket("localhost", 3001);
        ObjectOutputStream os = new ObjectOutputStream(engineSocket.getOutputStream());
		os.writeObject(initialBoardMessage);

		// Run Main Engine connector
		while (!sigKill) {
			Socket serverConnection = serverSocket.accept();
			clientConnections.add(serverConnection);

			
		}

		engineSocket.close();
	}

	@Override
	public void run() {
		try {
			// Run Main Engine connector
			while (!sigKill) {
				Socket clientConnection;
				clientConnection = serverSocket.accept();
				clientConnections.add(clientConnection);
				
				ServerConnection serverConnection = new ServerConnection(clientConnection);
				serverConnection.start();
			}

			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
