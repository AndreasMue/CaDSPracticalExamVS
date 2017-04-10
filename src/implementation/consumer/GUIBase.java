package implementation.consumer;

import org.cads.ev3.gui.swing.CaDSRobotGUISwing;
import org.cads.ev3.rmi.consumer.ICaDSRMIConsumer;
import org.cads.ev3.rmi.generated.cadSRMIInterface.IIDLCaDSEV3RMIMoveGripper;
import org.cads.ev3.rmi.generated.cadSRMIInterface.IIDLCaDSEV3RMIMoveHorizontal;
import org.cads.ev3.rmi.generated.cadSRMIInterface.IIDLCaDSEV3RMIMoveVertical;
import org.cads.ev3.rmi.generated.cadSRMIInterface.IIDLCaDSEV3RMIUltraSonic;

public class GUIBase extends CaDSRobotGUISwing {

	public static final int REFRESHRATE = 250;
	
	public GUIBase(ICaDSRMIConsumer consumer, 
				   IIDLCaDSEV3RMIMoveGripper gripperHandle,
				   IIDLCaDSEV3RMIMoveVertical verticalHandle, 
				   IIDLCaDSEV3RMIMoveHorizontal horizontalHandle,
			   	   IIDLCaDSEV3RMIUltraSonic us) {
		
		super(consumer, gripperHandle, verticalHandle, horizontalHandle, us);
		startGUIRefresh(REFRESHRATE);
	}

}
