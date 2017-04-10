package implementation.consumer;

import implementation.util.ConnectionStates;
import implementation.util.Message;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

public class CommunicationBase {
	
	public static final String ENTITYNAME = "[ComBase]";
	
	private InetAddress nameserver = null;
	private boolean isConnected = false;
	private ConnectionStates state = ConnectionStates.INIT;
	private Map<String, RobotComHandle> robotMap = null;
	
	public CommunicationBase(InetAddress nameserver) {
		this.nameserver = nameserver;
		
		robotMap = new HashMap<String, RobotComHandle>();
		
		newNameserver(nameserver);
	}
	
	private boolean connectToNameserver() {
		System.out.println(ENTITYNAME + ": Connecting to " + nameserver.getHostAddress() + " ...");
		return false;
	}

	public void newNameserver(InetAddress nameserver) {
		this.nameserver = nameserver;
		
		if( connectToNameserver() ) {
			
			/* Successfully connected to the Nameserver */
			state = ConnectionStates.CONNECTED;
			isConnected = true;
			System.out.println(ENTITYNAME + ": Successful connected to " + nameserver.getHostAddress() + " .");
		} else {
			
			/* Error while connecting to the Nameserver */
			System.err.println(ENTITYNAME + ": Error while connecting to " + nameserver.getHostAddress() + " !");
			return;
		}
	}
	
	public boolean getNewRobotHandle(String name) {
		if( isConnected && !robotMap.containsKey(name) ) {
			
			/* Request Handle */
			//@TODO request information about available robots from nameserver
			robotMap.put(name, new RobotComHandle(name, null, -1, this));
			return true;
		} else {
			
			/* Not connected to nameserver */
			System.err.println(ENTITYNAME + ": Currently not connected to a nameserver ");
			return false;
		}
		
	}
	
	public void sendMessage(String to, Message msg) {
		RobotComHandle handle = robotMap.get(to);
		
		if( handle != null ) {
			
			/* Robot Communication Handle exists */
			handle.sendJSON(msg.getMessageJSON());
			System.out.println(ENTITYNAME + ": New message to " + to + " >" + msg.getMessageJSON().toJSONString() + "<");
		} else {
			
			/* Robot Communication Handle doesn't exist */
			System.err.println(ENTITYNAME + ": Error: RobotHandle doesn't exist for " + to + " !");
		}
	}
	
	public void receivedMessage(String from, JSONObject msg) {
		System.out.println(ENTITYNAME + ": New message from " + from + " >" + msg.toJSONString() + "<");
	}
	
	
	
	private class RobotComHandle {
		
		private String name = null;
		private InetAddress address = null;
		private int port = -1;
		private CommunicationBase comBase = null;
		private ConnectionStates state = ConnectionStates.INIT;
		
		public RobotComHandle(String name, InetAddress address, int port, CommunicationBase comBase) {
			this.address = address;
			this.port = port;
			this.comBase = comBase;
		}
		
		public boolean sendJSON(JSONObject msg) {
			return true;
		}
		
		public String getName() {
			return name;
		}
		
		public InetAddress getAddress() {
			return address;
		}
		
		public int getPort() {
			return port;
		}
	}
}
