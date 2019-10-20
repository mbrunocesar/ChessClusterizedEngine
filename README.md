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


