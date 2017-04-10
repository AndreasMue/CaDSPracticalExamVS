package implementation.consumer;

import implementation.util.EventTypes;
import implementation.util.Message;

import java.net.InetAddress;

import org.cads.ev3.gui.ICaDSRobotGUIUpdater;
import org.cads.ev3.rmi.consumer.ICaDSRMIConsumer;
import org.cads.ev3.rmi.generated.cadSRMIInterface.IIDLCaDSEV3RMIMoveGripper;
import org.cads.ev3.rmi.generated.cadSRMIInterface.IIDLCaDSEV3RMIMoveHorizontal;
import org.cads.ev3.rmi.generated.cadSRMIInterface.IIDLCaDSEV3RMIMoveVertical;
import org.cads.ev3.rmi.generated.cadSRMIInterface.IIDLCaDSEV3RMIUltraSonic;

public class ConsumerBase 
	implements ICaDSRMIConsumer,
			   IIDLCaDSEV3RMIMoveGripper, 
			   IIDLCaDSEV3RMIMoveHorizontal, 
			   IIDLCaDSEV3RMIMoveVertical, 
			   IIDLCaDSEV3RMIUltraSonic {
	
	private GUIBase gui = null;
	private CLIBase cli = null;
	private CommunicationBase com = null;
	private static int transactionID = 0;
	
	public ConsumerBase(boolean useGUI, InetAddress nameserver) {
		if( useGUI ) {
			
			// Create new GUI
			gui = new GUIBase(this, this, this, this, this);
		} else {
			
			/* Handle Command Line Input */
			cli = new CLIBase(this);
		}
		
		com = new CommunicationBase(null);
	}
	
	@Override
	public int isUltraSonicOccupied() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCurrentVerticalPercent() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int moveVerticalToPercent(int arg0, int arg1) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCurrentHorizontalPercent() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int moveHorizontalToPercent(int arg0, int arg1) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int stop(int arg0) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int closeGripper(int arg0) throws Exception {
		Message msg = Message.newEventMessage(EventTypes.GRAB, arg0, false);
		com.sendMessage("", msg);
		return 0;
	}

	@Override
	public int isGripperClosed() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int openGripper(int arg0) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void register(ICaDSRobotGUIUpdater arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String arg0) {
		// TODO Auto-generated method stub
		
	}

}
