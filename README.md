# Code Gym Tasks

## Table of Contents
* [Restaurant manager](#restaurant-manager)
* [Chat application](#chat-application)
* [Archiver](#archiver)
* [Html editor](#html-editor)
* [Refactoring java](#refactoring-java)
* [2048 game](#2048-game)

## Restaurant manager
Program to automate what happens in a restaurant.
1) each table has a tablet that can be used to place orders;
2) while an order is being prepared, the tablet shows ads;
3) at the end of the business day, various statistics can be reviewed:<br>
a) cook utilization;<br>
b) total revenue from orders;<br>
c) total revenue from ad impressions.

## Chat application
Chat system: A set of programs that you can use
to exchange text messages. The system consist one server and
multiple clients, one for each chat participant.
The client and server communicate through a socket connection.
One side write data to the socket, while the other read.
The Connection class wrap the java.net.Socket class,
which serialize and deserialize Message objects to/from the socket.
The methods of this class sare callable from different threads.
The server support multiple simultaneous connections with different clients.
This is done using the following algorithm:
- The server creates a server socket connection.
- In a loop, the server waits for some client to connect to the socket.
- It creates a new Handler thread on which messages will be exchanged with the client.
- It waits for another connection.


## Archiver
Archiver that is able to:
a) zip and unzip files.
b) extract an archive.
c) add a new file to an existing archive.
d) remove a file from an archive.
e) view the contents of an archive.

## Html editor
Program for automatic processing of text into html code
we format the text in a way characteristic for editors like Word,
and after clicking the appropriate button we get it in the form of a code.

## Refactoring java
First encounter with code refactoring.

## 2048 game
1. Controller - monitor keystrokes during the game.
2. Model - contain the game logic and store the game board.
3. View - provide a view of the current state of the game.
4. Main - contain only the main method, serving as the entry point for application.