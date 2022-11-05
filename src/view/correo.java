package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class correo {

	private JFrame frame;
	private JTextField txtTitulo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					correo window = new correo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public correo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 192));
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 255, 255));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel PnFolders = new JPanel();
		PnFolders.setBackground(new Color(0, 0, 160));
		PnFolders.setBounds(0, 0, 194, 583);
		panel.add(PnFolders);
		PnFolders.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FOLDERS");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(10, 23, 174, 53);
		PnFolders.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Inbox");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(10, 86, 184, 44);
		PnFolders.add(btnNewButton);
		
		JButton btnSend = new JButton("Send");
		btnSend.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnSend.setBounds(10, 140, 184, 44);
		PnFolders.add(btnSend);
		
		JPanel PnListaCorreo = new JPanel();
		PnListaCorreo.setBounds(193, 0, 225, 583);
		panel.add(PnListaCorreo);
		PnListaCorreo.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 205, 563);
		PnListaCorreo.add(scrollPane);
		
		JList list = new JList();
		list.setBackground(new Color(192, 192, 192));
		scrollPane.setViewportView(list);
		
		JPanel PnMensaje = new JPanel();
		PnMensaje.setBounds(418, 0, 519, 583);
		panel.add(PnMensaje);
		PnMensaje.setLayout(null);
		
		txtTitulo = new JTextField();
		txtTitulo.setEnabled(false);
		txtTitulo.setEditable(false);
		txtTitulo.setBackground(new Color(192, 192, 192));
		txtTitulo.setBounds(10, 10, 499, 57);
		PnMensaje.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 91, 499, 482);
		PnMensaje.add(scrollPane_1);
		
		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		frame.setBounds(100, 100, 951, 620);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
