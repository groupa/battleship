package newBranch;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

/**
 * @author Massih
 * 
 */

public class Client {

	private static boolean dbg;

	public Client() {
		dbg = true;
	}

	public static void main(String[] args) {
		try {
//			get server IP from user
			InetAddress host = InetAddress.getByName(JOptionPane
					.showInputDialog("Enter Server IP :"));
//			Initialize the client socket and bind it to server IP
			Socket clientSocket = new Socket(host, 7777);
//			make this thread to get incoming message
			ClientListen listen = new ClientListen(clientSocket);
			ObjectOutputStream outpuStream = new ObjectOutputStream(
					clientSocket.getOutputStream());
//			get first 
			String content = JOptionPane.showInputDialog("input text");
			while (content != null && !content.equalsIgnoreCase("exit")) {
				outpuStream.writeObject(content);
				if(dbg){
					System.out.println("send message from Client.java - main method" + content);
				}
				content = JOptionPane.showInputDialog("input text");
			}
			clientSocket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

class ClientListen implements Runnable {
	private Socket client;
	private boolean dbg;
	/**
	 * get the specific socket and make a thread to get all messages that sent
	 * to this socket
	 * 
	 * @param client
	 *            the specific socket that we want to read all messages that
	 *            sent to this socket
	 */
	public ClientListen(Socket client) {
		this.client = client;
		Thread t = new Thread(this);
		t.start();
	}

	/**
	 * listen to the input stream and get all messages that sent to this stream
	 */
	public void run() {
		try {
			ObjectInputStream input = new ObjectInputStream(
					client.getInputStream());
			String incomingMessage = (String) input.readObject();//read first object from stream 
			while (incomingMessage != null) {//loop for getting all messages
//				JOptionPane.showMessageDialog(null, incomingMessage);
				incomingMessage = (String) input.readObject();
				if(dbg){
					System.out.println("recieve message in ClientListen.java - run" + incomingMessage);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
