import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import dbPackage.DataBaseProvider;
import repositories.CustomerRepository;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import javax.swing.JScrollPane;

public class Form {

	private JFrame frmServerside;

	JTextArea consoleTextArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Form window = new Form();
					window.frmServerside.setVisible(true);
					DataBaseProvider.GetInstance();
					//new Thread (new SimpleServerSocket());
					
					System.setProperty("java.rmi.server.hostname","127.0.0.1");
					LocateRegistry.createRegistry(1099);
					IConnectService serv = new ConnectService();
					
					Naming.rebind("ConnectService", serv);
					String[] serversList = Naming.list("127.0.0.1");
					// debug
					for (String item : serversList)	{
						System.out.println(item);
					}
					if (serversList.length>0) // if we have registered out server - tell about that
						System.out.println("RMI Connected");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the application.
	 */
	public Form() {
		redirectSystemStreams();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmServerside = new JFrame();
		frmServerside.setTitle("ServerSide");
		frmServerside.setBounds(100, 100, 602, 463);
		frmServerside.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmServerside.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(21, 11, 551, 387);
		frmServerside.getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 527, 365);
		panel.add(scrollPane);

		consoleTextArea = new JTextArea();
		consoleTextArea.setEditable(false);
		consoleTextArea.setLineWrap(true);
		// consoleTextArea.setWrapStyleWord(true);
		scrollPane.setViewportView(consoleTextArea);
	}

	private void updateTextArea(final String text) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				consoleTextArea.append(text);
			}
		});
	}

	// change output from console to textarea on GUI
	private void redirectSystemStreams() {
		OutputStream out = new OutputStream() {
			@Override
			public void write(int b) throws IOException {
				updateTextArea(String.valueOf((char) b));
			}

			@Override
			public void write(byte[] b) throws IOException {
				write(b, 0, b.length);
			}

			@Override
			public void write(byte[] b, int off, int len) throws IOException {
				updateTextArea(new String(b, off, len));
			}

		};

		System.setOut(new PrintStream(out, true));
		System.setErr(new PrintStream(out, true));
	}
}
