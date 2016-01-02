
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow {

//	private JFrame frame;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainWindow window = new MainWindow();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 */
//	public MainWindow() {
//		initialize();
//	}
//
//	public static JPanel conntentA(JPanel conntent)
//	{
//		JButton button = new JButton("<<< previos page");
//		JButton button1 = new JButton("<this page>");
//		JButton button2 = new JButton("next page >>>");
//		conntent.add(button);
//		conntent.add(button1);
//		conntent.add(button2);
//		conntent.revalidate();
//		return conntent;
//	}
//	
//	
//	private static void createGUI()
//	{
//		int width = 640;
//		int height = 480;
//		JFrame.setDefaultLookAndFeelDecorated(false);
//		
//		JFrame frame = new JFrame("Hello");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(width, height);
//		frame.setResizable(false);
//		frame.setVisible(true);
//		frame.setLocationRelativeTo(null);
//		
//
//		
//		JButton button1 = new JButton("Ok");
//		
//		button1.setLocation(20, 100);
//		button1.setSize(100,50);
//		
//		final JPanel conntent = new JPanel();
//		
//		button1.addActionListener(new ActionListener() {			
//			public void actionPerformed(ActionEvent e) {
//				
//				conntent.removeAll();
//				frame.add(conntentA(conntent));
//				frame.repaint();
//			}
//		});
//		frame.add(button1);
//		frame.add(conntent);
//	}
//	
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void initialize() {
//		frame = new JFrame();
//		frame.setBounds(100, 100, 450, 300);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		createGUI();
//	}

}
