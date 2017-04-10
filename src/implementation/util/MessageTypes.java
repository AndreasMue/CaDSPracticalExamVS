package implementation.util;

public enum MessageTypes {
	/* EVENT is everything that defines actions */
	EVENT,
	
	/* STATUS is the current actor/service state */
	STATUS,
	
	/* ACK standard */
	ACK,
	
	/* HANDLE base type with protocol, address and port */
	HANDLE;
	
	public static String toString(MessageTypes type) {
		if( type == EVENT ) return "EVENT";
		if( type == STATUS) return "STATUS";
		if( type == ACK)    return "ACK";
		if( type == HANDLE) return "HANDLE";
		return null;
	}
}
