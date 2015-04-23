package aplication.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientTest {
	public static void main(String[] args) {

		try {

			Socket socket = new Socket("192.168.1.114", 12345);
			
			

			SocketListener listener = new SocketListener(
					socket.getInputStream());
			new Thread(listener).start();

			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			Scanner sc = new Scanner(System.in);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				pw.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static class SocketListener implements Runnable {
		private final Scanner scanner;

		public SocketListener(InputStream is) {

			this.scanner = new Scanner(is);

		}

		public void run() {
			while (scanner.hasNextLine()) {
				System.err.println(scanner.nextLine());
			}
		}
	}
}
