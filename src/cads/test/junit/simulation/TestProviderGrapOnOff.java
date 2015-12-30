package cads.test.junit.simulation;

import static org.junit.Assert.*;

import org.cads.ev3.middeware.CaDSBase;
import org.cads.ev3.middeware.CaDSEV3StudentImplementation;
import org.cads.ev3.middeware.ICaDSGripperFeedBack;
import org.cads.ev3.middeware.ICaDsEV3StatusListener;
import org.json.simple.JSONObject;
import org.junit.Test;

import lejos.utility.Delay;


public class TestProviderGrapOnOff {
	private static CaDSEV3StudentImplementation caller = null;
	private class TestListener implements Runnable, ICaDsEV3StatusListener, ICaDSGripperFeedBack {

		@Override
		public synchronized void giveFeedbackByJSonTo(JSONObject arg0) {
			System.out.println(arg0);
		}

		@Override
		public synchronized void onStatusMessage(JSONObject arg0) {
			System.out.println(arg0);
			
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {	
				caller = new CaDSEV3StudentImplementation(new CaDSBase(),this,this);
				boolean on = true;
				while(!Thread.currentThread().isInterrupted()){
					Delay.msDelay(500);
					if(on)
						caller.doGrap(); // grap
					else
						caller.doRelease(); // release
					on = !on;	
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
			CaDSBase.start(CaDSBase.SIMULATION,l);
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

}