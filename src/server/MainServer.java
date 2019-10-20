package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.LinkedList;


public class MainServer extends Thread {
	
	boolean sigKill = false;

	ServerSocket serverSocket;

	LinkedList<Socket> engineConnections;


	public MainServer(int numberOfEngines) throws IOException, ClassNotFoundException {
		// Create a Server Socket for the Engine
		serverSocket = new ServerSocket(5000);
		System.out.println("[DEBUG] Main Server Listening...");

		engineConnections = new LinkedList<Socket>();

		for (int i = 0; i < numberOfEngines; i++) {
			Socket engineSocket = new Socket("localhost", 5001 + i);
			engineConnections.add(engineSocket);
		}

		// ObjectOutputStream os = new ObjectOutputStream(engineSocket.getOutputStream());
		// os.writeObject(initialBoardMessage);
		// engineSocket.close();
	}

	@Override
	public void run() {
		try {
			// Run Main Engine connector
			while (!sigKill) {
				Socket clientConnection;
				clientConnection = serverSocket.accept();
				
				ServerToClientConnection serverConnection = new ServerToClientConnection(clientConnection, this);
				serverConnection.start();
			}

			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Socket getRandomEngineConnection() {
		int numberOfEngines = engineConnections.size();
		int random = (int) Math.floor(Math.random() * numberOfEngines);
		return engineConnections.get(random);
	}

}
