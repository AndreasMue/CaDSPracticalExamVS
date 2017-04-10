package implementation.util;

import org.json.simple.JSONObject;

public class Message {
	
	public static final String ENTITYNAME = "[Message]";
	
	private MessageTypes type = null;
	private EventTypes eventType = null;
	private int id;
	private Object val = null;
	
	public Message(MessageTypes type, EventTypes eventType, int id, boolean value) {
		this.type = type;
		this.eventType = eventType;
		this.id = id;
	}
	
	public Message(MessageTypes type, EventTypes eventType, int id, float value) {
		this.type = type;
		this.eventType = eventType;
		this.id = id;
	}
	
	public Message(MessageTypes type, String protocol, String address, String port) {
		this.type = type;
	}
	
	public static Message newEventMessage(EventTypes eventType, int id, Object val) {
		if( eventType == EventTypes.GRAB ) {
			
			/* EventType is GRAB */
			return new Message(MessageTypes.EVENT, eventType, id, (boolean)val);
		} else if( eventType == EventTypes.HORIZONTAL ||
				   eventType == EventTypes.VERTICAL ) {
			
			/* EventType is HORIZONTAL or VETICAL */
			return new Message(MessageTypes.EVENT, eventType, id, (float)val);
		} else {
			
			/* Unknown EventType */
			System.err.println( ENTITYNAME +  ": Unknown EventType: " + eventType);
			return null;
		}
	}
	
	public static Message newStatusMessage(EventTypes eventType, int id, Object val) {
		if( eventType == EventTypes.GRAB ) {
			
			/* EventType is GRAB */
			return new Message(MessageTypes.STATUS, eventType, id, (boolean)val);
		} else if( eventType == EventTypes.HORIZONTAL ||
				   eventType == EventTypes.VERTICAL ) {
			
			/* EventType is HORIZONTAL or VETICAL */
			return new Message(MessageTypes.STATUS, eventType, id, (float)val);
		} else {
			
			/* Unknown EventType */
			System.err.println( ENTITYNAME +  ": Unknown EventType: " + eventType);
			return null;
		}
	}
	
	public static Message newAckMessage(EventTypes eventType, int id, Object val) {
		if( eventType == EventTypes.GRAB ) {
			
			/* EventType is GRAB */
			return new Message(MessageTypes.ACK, eventType, id, (boolean)val);
		} else if( eventType == EventTypes.HORIZONTAL ||
				   eventType == EventTypes.VERTICAL ) {
			
			/* EventType is HORIZONTAL or VETICAL */
			return new Message(MessageTypes.ACK, eventType, id, (float)val);
		} else {
			
			/* Unknown EventType */
			System.err.println( ENTITYNAME +  ": Unknown EventType: " + eventType);
			return null;
		}
	}
	
	public Message createACK() {
		if( type == MessageTypes.EVENT ) {
			
			/* Create ACK Message */
			return newAckMessage(eventType, id, val);
		} else {
			
			/* No suitable MessageType for ACK */
			System.err.println(ENTITYNAME + ": Only EVENT is allowed for ACK: " + MessageTypes.toString(type));
			return null;
		}
	}
	
	public JSONObject getMessageJSON() {
		return new JSONObject();
	}
}
