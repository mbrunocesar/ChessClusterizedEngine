Distributed Engine:

-------------------
--- Client Side ---
-------------------

User Interface:
- GUI
- Thread

Server Communication:
- Thread
- TCP Socket (id 1)


-------------------
--- Server Side ---
-------------------

Main Server:
- Thread
- Server Socket (id 1)

Server Connection:
- Thread
- TCP Socket - with Client(id 1)

Engine Connection:
- Thread
- TCP Socket - with Engine(id 2)


-------------------
--- Engine Side ---
-------------------

Engine Server:
- Thread
- Server Socket (id 2)

Engine Connection:
- Thread
- TCP Socket - with Server(id 2)

Engine Core:
- Thread
- Core


----------------------------------

Desired Flow:


Do while there's a game

	Client sends his (Maybe Initial) Board to server

	Server Keeps his connection active

	Server get a pool of engine instances to process the position

	for each engine
		Engine get the position

		Engines process

		Engines sends back to Server the result

	Server gets all the results

	Server chooses the best continuation

	Server sends back to Client the best result



