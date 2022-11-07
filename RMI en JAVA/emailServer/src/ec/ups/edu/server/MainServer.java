package ec.ups.edu.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;


import ec.ups.edu.common.ServerInterface;

public class MainServer {

	public static void main(String[] args) throws Exception {
//		
		Server server = new Server();
		ServerInterface remote = (ServerInterface) UnicastRemoteObject.exportObject(server, 5000);

		 try {
	            LocateRegistry.createRegistry(4321);
	            Naming.rebind("rmi://localhost:4321/remote",remote);
	            System.out.println("Server Started ...");
	        } catch (MalformedURLException | RemoteException ex) {
	            System.out.println("Error: " + ex.getMessage());
	        }
		
		
		

	}

}
