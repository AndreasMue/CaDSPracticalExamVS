package cads.test.junit.legoEV3;

import static org.junit.Assert.*;

import org.cads.ev3.middleware.CaDSEV3RobotStudentImplementation;
import org.cads.ev3.middleware.CaDSEV3RobotType;
import org.cads.ev3.middleware.hal.ICaDSEV3RobotFeedBackListener;
import org.cads.ev3.middleware.hal.ICaDSEV3RobotStatusListener;
import org.json.simple.JSONObject;
import org.junit.Test;

import lejos.utility.Delay;


public class TestProviderLeftRight {
	private static CaDSEV3RobotStudentImplementation caller = null;
	
	private class TestListener implements Runnable, ICaDSEV3RobotStatusListener, ICaDSEV3RobotFeedBackListener {

		@Override
		public synchronized void giveFeedbackByJSonTo(JSONObject feedback) {
			System.out.println(feedback);
		}

		@Override
		public synchronized void onStatusMessage(JSONObject status) {
			System.out.println(status);

		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
			    caller = CaDSEV3RobotStudentImplementation.createInstance(CaDSEV3RobotType.REAL, this, this);
				boolean on = true;
				while(!Thread.currentThread().isInterrupted()){

					if(on){
						caller.stop_h();	// stops any movement
						caller.moveLeft();
					}else{
						caller.stop_h();	// stops any movement
						caller.moveRight();
					}
					on = !on;
					Delay.msDelay(5100);
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(-1);
			}
			System.exit(0);
		}
	}

	@Test
	public void test() {
		try {
			TestListener l = new TestListener();
			(new Thread(l)).start();
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

}
