package engine;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;

import java.util.LinkedList;

public class EngineServer extends Thread {
	int instanceNumber;
	boolean sigKill = false;
	
	public EngineServer(int id) {
		this.instanceNumber = id;
	}
	
	public void run() {
		// Create a Server Socket for the Engine
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(3000 + instanceNumber);
			System.out.println("[DEBUG] Engine Server " + instanceNumber + " Listening...");
	
			LinkedList<Socket> engineConnections = new LinkedList<Socket>();
			
			// Prepare Engine Thread through Engine Connection
			EngineToServerConnection engine;
			
			// Run Main Engine connector
			while (!sigKill) {
				Socket serverConnection = serverSocket.accept();
				engineConnections.add(serverConnection);
	
				engine = new EngineToServerConnection(serverConnection);
				engine.start();
			}
	
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
