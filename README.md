# EjerciciosEventos

This package includes a number of exercies on events base programs using Java. It is intended to be used in the course "Análisis y diseño de software". GTIST in the ETSI Telecomuniación, UPM. (www.etsit.upm.es)

1. EventoMina

This case proposes a solution to a mine control case study. It is based on the book "Real-Time Systems and Programming Languages" by Alan Burns and Andy Wellings". It is adapted to the mentioned course.

2. CounterButton

It is a very simple example on how to develop a GUI using Swing, which is framework for defining the look and feel of the modern Java graphical user interface. The GUI only includes a label and a button for increment a counter. The label updates the value of this counter

3. CS (Client/Server)

This case tries to illustrate a client/server system. The case is intended to be executed as internal Java programs, without external communications. The communication network is simulated as a class (Auxiliar/Internet) that provides methods for to send and receive messages. The package Client includes classes for emulation a client. There are two alternatives for using servers. 

"Server" is implemented with a single thread. It receives messages from clients, processes it and, finally, replies the result of this operation. This package includes the "TestCS" main. It creates a number of clients and a server. Then, it starts them for illustrating its behaviour

The "ServerConc" package creates handlers for processing each of the messages received. When the server gets a message, then it creates a handler thread and start it for processing the message. In this way, the server is ready for getting the next message immediately. A similar main as before is also provided.

4. CS_TCP (Client/Server TCP)

This case study provides a number of alternatives for a client/server paradigm. The code includes clients and server programs that are communicated by sockets based on TCP/IP. As before, there are several servers. As similar before, there is a sequential server. There are two options of servers that they accept a connection and creates a dispatcher for getting messages from the connection with a client. In the case of the TCPServerConcurrency server, the dispatcher creates a new handler thread for managing each of the messages from the connection. The handler processes the message and send the result to the client. Finally, the dispatcher in the TCPServerPool package relies on a pool of threads. When the dispatcher is started, it creates a set of threads for handling messages. When the dispatcher gets a message, it forwards this to a handler. The monitor  SyncPool helps for synchronizing the dispatcher with the handlers. The file CS_TCP-ServerConcPool.png shows an UML diagram of the classes in this case. 

The TCPClient class defines the IP and port of the server. Initially, the IP addresses is 127.0.0.1 for running the case locally. This address can be updated depending on the location of the server. For running these cases it is needed to create a TCPServer program and a set of TCPClients.

