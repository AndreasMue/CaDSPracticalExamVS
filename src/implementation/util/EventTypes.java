package implementation.util;

public enum EventTypes {
	/* GRAB for grabbing */
	GRAB,
	
	/* HORIZONTAL for movement on x axis */
	HORIZONTAL,
	
	/* VERTICAL for movement on y axis */
	VERTICAL;
	
	public static String toString(EventTypes type) {
		if( type == GRAB ) 		return "GRAB";
		if( type == HORIZONTAL) return "HPRIZONTAL";
		if( type == VERTICAL)   return "VERTICAL";
		return null;
	}
}