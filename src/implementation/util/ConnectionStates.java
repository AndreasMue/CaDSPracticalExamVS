package implementation.util;

public enum ConnectionStates {
	/* INIT before any connection */
	INIT,
	
	/* PENDING after initial connection attempt */
	PENDING,
	
	/* CONNECTED after successful connection */
	CONNECTED,
	
	/* DISCONNECTED after connection loss */
	DISCONNECTED,
	
	/* ERROR for any error during procedure */
	ERROR;
	
	public static String toString(ConnectionStates state) {
		if( state == INIT ) return "INIT";
		if( state == PENDING ) return "PENDING";
		if( state == CONNECTED ) return "CONNECTED";
		if( state == DISCONNECTED ) return "DISCONNECTED";
		if( state == ERROR ) return "ERROR";
		return null;
	}
}