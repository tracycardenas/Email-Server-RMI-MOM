package ec.ups.edu.common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;



public interface ServerInterface extends Remote {
	public User login(String username, String password) throws RemoteException;
	public boolean registerUser(User user) throws RemoteException;
	public List<Message> enviar(String msg, User user, String destinatario) throws RemoteException;
	
}
