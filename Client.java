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
	public static void main(String[] args) {
		try {
			InetAddress host = InetAddress.getByName(JOptionPane
					.showInputDialog("Enter Server IP :"));
			Socket clientSocket = new Socket(host, 7777);
			ClientListen listen = new ClientListen(clientSocket);
			ObjectOutputStream outpuStream = new ObjectOutputStream(
					clientSocket.getOutputStream());
			String content = JOptionPane.showInputDialog("input text");
			while (content != null && !content.equalsIgnoreCase("exit")) {
				outpuStream.writeObject(content);
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
	private Socket S;

	public ClientListen(Socket client) {
		S = client;
		Thread t = new Thread(this);
		t.start();
	}

	public void run() {
		try {
			ObjectInputStream input = new ObjectInputStream(S.getInputStream());
			String incomingMessage = (String) input.readObject();
			System.out.println("--" + incomingMessage);
			while (!incomingMessage.equals("f")) {
				JOptionPane.showMessageDialog(null, incomingMessage);
				incomingMessage = (String) input.readObject();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
