package ec.ups.edu.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import ec.ups.edu.common.ServerInterface;
import ec.ups.edu.common.User;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginVi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame frame;
	private JTextField txtCorreo;
	private JTextField txtPassword;
	private static ServerInterface server;
	private JTextField usernameRegister;
	private JTextField passwordRegister;
	private JTextField nameRegister;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginVi window = new LoginVi();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public LoginVi() throws Exception {
		initialize();
		connectServer();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 863, 485);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("E M A I L");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(218, 24, 449, 54);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Correo :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(70, 191, 86, 21);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Contrase\u00F1a :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(25, 245, 130, 21);
		panel.add(lblNewLabel_1_1);
		
		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCorreo.setBounds(154, 191, 226, 30);
		panel.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPassword.setColumns(10);
		txtPassword.setBounds(154, 245, 226, 30);
		panel.add(txtPassword);
		
		JButton btnNewButton = new JButton("Iniciar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					login();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(183, 300, 165, 21);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1_2 = new JLabel("Correo :");
		lblNewLabel_1_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(513, 215, 86, 21);
		panel.add(lblNewLabel_1_2);
		
		usernameRegister = new JTextField();
		usernameRegister.setFont(new Font("Dialog", Font.PLAIN, 14));
		usernameRegister.setColumns(10);
		usernameRegister.setBounds(597, 215, 226, 30);
		panel.add(usernameRegister);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Contraseña :");
		lblNewLabel_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(468, 257, 130, 21);
		panel.add(lblNewLabel_1_1_1);
		
		passwordRegister = new JTextField();
		passwordRegister.setFont(new Font("Dialog", Font.PLAIN, 14));
		passwordRegister.setColumns(10);
		passwordRegister.setBounds(597, 257, 226, 30);
		panel.add(passwordRegister);
		
		JButton register = new JButton("Registrar");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					register();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		register.setFont(new Font("Dialog", Font.PLAIN, 16));
		register.setBounds(626, 312, 165, 21);
		panel.add(register);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblLogin.setBounds(23, 101, 449, 54);
		panel.add(lblLogin);
		
		JLabel lblRegister = new JLabel("REGISTER");
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblRegister.setBounds(451, 101, 449, 54);
		panel.add(lblRegister);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Nombre :");
		lblNewLabel_1_2_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_1_2_1.setBounds(500, 167, 99, 21);
		panel.add(lblNewLabel_1_2_1);
		
		nameRegister = new JTextField();
		nameRegister.setFont(new Font("Dialog", Font.PLAIN, 14));
		nameRegister.setColumns(10);
		nameRegister.setBounds(597, 161, 226, 30);
		panel.add(nameRegister);
		
	}

	private void connectServer() throws Exception {
		try {
            server = (ServerInterface) Naming.lookup("rmi://localhost:4321/remote");
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
	}
	
	private void login() throws Exception {

		try {
			User ingreso = server.login(txtCorreo.getText(), txtPassword.getText());
			if (ingreso !=null) {
				EmailVista frame = new EmailVista(ingreso, server);
				JOptionPane.showMessageDialog(null, "BIENVENIDO");
				frame.setVisible(true);
				this.setVisible(false);
				txtCorreo.setText("");
				txtPassword.setText("");
			} else {
				JOptionPane.showMessageDialog(null, "Credenciales Incorrectas");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void register() throws Exception {
		User user = new User(nameRegister.getText(), usernameRegister.getText(), passwordRegister.getText());
		
		try {
			boolean registro = server.registerUser(user);
			
			if (registro == true ) {
				JOptionPane.showMessageDialog(null, "Usuario Registrado");
				nameRegister.setText("");
				usernameRegister.setText("");
				passwordRegister.setText("");
			} else {
				JOptionPane.showMessageDialog(null, "Ingrese los datos correctamente");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
