# EjerciciosEventos

This package includes a number of exercies on events base programs using Java. Intented to be used in the course "Análisis y diseño de software". GTIST in the ETSI Telecomuniación, UPM. (www.etsit.upm.es)

1. EventoMina
This case proposes a solution to a mine contro case study. It is based on the book "Real-Time Systems and Programming Languages" by Alan Burns and Andy Wellings". It is adapted to the mentioned course.

2. CounterButton
It is a very simple example on how to develop a GUI using Swing, which is framework for defining the look and feel of the modern Java graphical user interface. The GUI only includes a label and a button for increment a counter. The laber updates the value of this counter

3. CS (Client/Server)
This case tries to illustrate a client/server system. The case is intended to be executed as internal Java programs, without external communications. The communication network is simulated as a class (Auxiliar/Internet) that provides methods for to send and receive messages. The package Client includes clases for emulation a client. There are two alternatives for using servers. 

"Server" is implemented with a single thread. It receives messages from clients, processes it and, finally, replies the result of this operation. This package includes the "TestCS" main. It creates a number of clients and a server. Then starts them for illustrating its behaviour

The "ServerConc" package creates handlers for processing each of the messages received. When the server gets a message, then it creates a handler thread and start it for processing the message. In this way, the server is ready to get the next message immediately.  
