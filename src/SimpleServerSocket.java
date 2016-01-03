import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class SimpleServerSocket implements Runnable{
	ArrayList clientOutputStreams;

	public static void main(String[] args) {
		
	}

	public class ClientHandler implements Runnable {
		BufferedReader reader;
		Socket sock;

		public ClientHandler(Socket clientSocket) {

			try {
				sock = clientSocket;
				InputStreamReader isReader;
				isReader = new InputStreamReader(sock.getInputStream());
				reader = new BufferedReader(isReader);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}

		@Override
		public void run() {
			String message;
			try {
				while ((message = reader.readLine()) != null) {
					System.out.println("read -> " + message);
					;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
	}

	public void initSocket() {
		System.out.println("Initialize socket listening (5001)");
		clientOutputStreams = new ArrayList();
		try {
			ServerSocket serverSock = new ServerSocket(5002);

			while (true) {
				Socket clientSocket = serverSock.accept();
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
				clientOutputStreams.add(writer);

				Thread t = new Thread(new ClientHandler(clientSocket));
				t.start();
				System.out.println("We go a connect");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void run() {
		new SimpleServerSocket().initSocket();
	}
}