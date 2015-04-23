package aplication.network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
public static void main(String[] args) {
	try {
		ServerSocket serverSocket = new ServerSocket(80);
		Socket socket;
		int counter = 1;
		while(true) {
			socket = serverSocket.accept();
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
	//		pw.println("<html>head");
			pw.println("<h1>Yo bro</h1>");
			pw.print("<p> You are " + counter + ordinal(counter) + "th visitor. </p>");
			counter++;
			pw.close();
			socket.close();
			
			
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

private static String ordinal(int counter) {
	// TODO Auto-generated method stub
	return null;
}
}
