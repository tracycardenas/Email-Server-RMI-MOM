package ec.ups.edu.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import ec.ups.edu.common.Message;
import ec.ups.edu.common.ServerInterface;
import ec.ups.edu.common.User;

public class Server implements ServerInterface {

	protected Server() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private Map<String, User> name_session = new HashMap<String, User>();
	private Map<User, List<User>> contactos = new HashMap<User, List<User>>();
	private Map<User, List<Message>> buffer = new HashMap<User, List<Message>>();
	private List<Message> listaMensajes = new ArrayList<Message>();

	@Override
	public User login(String username, String password) throws RemoteException {
		if(name_session.containsKey(username)) {
			User user = name_session.get(username);
			return user;
		}
		return null;
	}

	@Override
	public boolean registerUser(User user) throws RemoteException {
		System.out.println("hola register");
		name_session.put(user.getUsername(), user);
		
		List<User> contacts = contactos.get(user);
		if (contacts == null ) {
			contacts = new LinkedList<User>();
			contactos.put(user, contacts);
			return true;
		}
		contacts.add(user);
		return true;
	}

	@SuppressWarnings("null")
	@Override
	public List<Message> enviar(String msg, User user, String destinatario) throws RemoteException {
		
		if (!name_session.containsKey(destinatario)) {
			throw new RuntimeException("Destinatario inexistente");
		}
		
		List<Message> mensajes = buffer.get(name_session.get(destinatario));
		if (mensajes == null) {
			mensajes = new ArrayList<Message>();
			Message ms = new Message(msg, new Date(),user, name_session.get(destinatario));
			mensajes.add(ms);
			listaMensajes.add(ms);			
			buffer.put(name_session.get(destinatario), mensajes);
			
		} else {
			Message ms = new Message(msg, new Date(), user, name_session.get(destinatario));
			buffer.put(name_session.get(destinatario), mensajes);
			listaMensajes.add(ms);			
		}
		return listaMensajes;
		
		
	}


}
