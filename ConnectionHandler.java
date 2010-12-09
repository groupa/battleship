package newBranch;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author Massih
 * 
 */

public class ConnectionHandler extends Thread {

	private Socket socket;
	private ObjectInputStream input;
	private ObjectOutputStream output;

	/**
	 * Initiate input and output object to prepare it for sending and receiving
	 * over the network
	 * 
	 * @param s
	 *            The established connection between server and client
	 * 
	 */

	public ConnectionHandler(Socket s) {
		try {
			socket = s;
			input = new ObjectInputStream(socket.getInputStream());
			output = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

		Thread connection = new Thread(this);
		connection.start();
	}

	/**
	 * send message over network stream
	 * 
	 * @param message	the message that should sent over network
	 */

	public void sendMessage(String message) {
		try {
			output.writeObject(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * get a message over input stream and send it to other clients by calling
	 * noticeAll method from Server class
	 * 
	 */

	public void run() {
		try {
			String message = (String) input.readObject();
			while (message != null && !message.equals("bye")) {
				// System.out.println(message);
				Server.noticeAll(message);
				message = (String) input.readObject();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
