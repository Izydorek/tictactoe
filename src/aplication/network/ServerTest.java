package aplication.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerTest {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(12345);
			Socket socket = serverSocket.accept();

			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os, true);
			Scanner sc = new Scanner(is);

			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				System.out.println("INCOMING: " + line);
				if (line.equals("exit")) {
					pw.println("BYE BYE");
					break;

				}
				pw.println("ECHO: " + line);
			}

			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
