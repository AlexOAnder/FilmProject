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
	private JPanel panel_1;
	private JButton btnSend;

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
					
					Naming.rebind("Hi", serv);
					String[] ss = Naming.list("127.0.0.1");
					// debug
					for (String item : ss)
					{
						System.out.println(item);
					}
					if (ss.length>0)
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
		frmServerside.setBounds(100, 100, 669, 463);
		frmServerside.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmServerside.getContentPane().setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 124, 138);
		frmServerside.getContentPane().add(panel_1);

		btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == btnSend)
					//JOptionPane.showMessageDialog(null, "Hello");
					System.out.println("fsdfsa");
			}
		});
		panel_1.add(btnSend);

		JPanel panel = new JPanel();
		panel.setBounds(174, 11, 445, 387);
		frmServerside.getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 425, 365);
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
