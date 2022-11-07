package ec.ups.edu.common;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String msg;
	private User emisor;
	private User receptor;
	
	

	public Message(String msg, Date date, User emisor, User receptor) {
		super();
		this.msg = msg;
		this.emisor = emisor;
		this.receptor = receptor;
	}
	
	
	public User getReceptor() {
		return receptor;
	}


	public void setReceptor(User receptor) {
		this.receptor = receptor;
	}


	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public User getEmisor() {
		return emisor;
	}
	public void setEmisor(User emisor) {
		this.emisor = emisor;
	}


	@Override
	public String toString() {
		return "Message [msg=" + msg + ", emisor=" + emisor.getName() + ", receptor=" + receptor.getName() + "]";
	}
	
	
	
	
	

}
