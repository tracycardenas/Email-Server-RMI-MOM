package ec.ups.edu.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ec.ups.edu.common.Message;
import ec.ups.edu.common.ServerInterface;
import ec.ups.edu.common.User;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;
import java.awt.event.ActionEvent;

public class EmailVista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame frame;
	private JTextField txtDestinatario;
	private  ServerInterface serverEmail;
	private List<Message> mensajes;
	private int cont =0;
	private JTextArea txtMensaje;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmailVista window = new EmailVista(null, null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public EmailVista(User user, ServerInterface server) throws Exception {
		serverEmail = server;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,  863, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtUser = new JLabel("New label");
		txtUser.setHorizontalAlignment(SwingConstants.CENTER);
		txtUser.setFont(new Font("Dialog", Font.BOLD, 28));
		txtUser.setBounds(184, 12, 345, 39);
		contentPane.add(txtUser);
		txtUser.setText(user.getName());
		
		JButton btnEnviados = new JButton("ENVIADOS");
		btnEnviados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					txtMensaje.setText("");
					for (int i = 0; i < mensajes.size(); i++) {
						if(mensajes.get(i).getEmisor().getName().equalsIgnoreCase(user.getName())) {
							System.out.println("message->" +mensajes.get(i));
							txtMensaje.append(mensajes.get(i)+"\n");
						}
					}
				
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEnviados.setBounds(41, 132, 131, 27);
		contentPane.add(btnEnviados);
		
		JButton btnRecibidos = new JButton("RECIBIDOS");
		btnRecibidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					txtMensaje.setText("");
					
					for (int i = 0; i < mensajes.size(); i++) {
						if(mensajes.get(i).getReceptor().getName().equalsIgnoreCase(user.getName())) {
							System.out.println("message->" +mensajes.get(i));
							txtMensaje.append(mensajes.get(i)+"\n");
						}
						
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRecibidos.setBounds(41, 76, 131, 27);
		contentPane.add(btnRecibidos);
		
		JLabel lblNewLabel = new JLabel("Mensajes");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(61, 24, 60, 17);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(117, 80, 123));
		separator.setBounds(184, 76, -11, 331);
		contentPane.add(separator);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnSalir.setBounds(41, 380, 105, 27);
		contentPane.add(btnSalir);
		
		JLabel lblDestinatario = new JLabel("Destinatario");
		lblDestinatario.setBounds(246, 81, 94, 17);
		contentPane.add(lblDestinatario);
		
		txtDestinatario = new JTextField();
		txtDestinatario.setBounds(357, 82, 420, 21);
		contentPane.add(txtDestinatario);
		txtDestinatario.setColumns(10);
		
		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					mensajes= serverEmail.enviar(txtMensaje.getText(), user, txtDestinatario.getText());
					cont ++;
					txtMensaje.setText("");
				} catch (RemoteException e1) {
					System.out.println("exception en el metodo remoto");
					e1.printStackTrace();
				} 
			}
		});
		btnEnviar.setBounds(445, 392, 105, 27);
		contentPane.add(btnEnviar);
		
		
		txtMensaje = new JTextArea();
		txtMensaje.setBounds(246, 115, 531, 232);
		contentPane.add(txtMensaje);
	}
}
