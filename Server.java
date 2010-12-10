package newBranch;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @author Massih
 * 
 */

public class Server {

	private static ArrayList<ConnectionHandler> connections;
	private ServerSocket server;
	private boolean dbg;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Server obj = new Server();
		obj.checkConnection();
	}

	/**
	 * Initiate a socket server connection and bind it to special port and
	 * create an arraylist of threads
	 */

	public Server() {
		dbg = true;
		try {
			server = new ServerSocket(7777);
			connections = new ArrayList<ConnectionHandler>();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * listen and wait for a connection and after establish a connection create
	 * a connectionhandler object that is a thread and it is responsible for
	 * send and receive message to this socket
	 */
	public void checkConnection() {

		try {
			while (true) {
				Socket s = server.accept();
				ConnectionHandler obj = new ConnectionHandler(s);
				connections.add(obj);
				if (dbg) {
					System.out.println("connection established and making a" +
									" new thread as type of ConnectionHandler and add it to array list" +
									"Server.java - checkconnection()");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <p>
	 * <b>Oracle-Java Tutorial :</b> When one thread is executing a synchronized
	 * method for an object, all other threads that invoke synchronized methods
	 * for the same object block (suspend execution) until the first thread is
	 * done with the object.
	 * </p>
	 * 
	 * send a message that received from one client to all the other clients and
	 * update them.
	 * 
	 * @param message
	 *            specific message that must send to other clients
	 */
	public synchronized static void noticeAll(String message) {
		/*
		 * retrieve each threads from arraylist and call sendMessage() to update each of them
		 */
		for (int i = 0; i < connections.size(); i++) {
			ConnectionHandler ref = connections.get(i);
			ref.sendMessage("Send TO all :" + message);
		}
	}

}
