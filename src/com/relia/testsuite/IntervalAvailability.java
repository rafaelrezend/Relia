/**
 * 
 */
package com.relia.testsuite;

import static org.junit.Assert.*;

import org.junit.Test;

import com.relia.availability.AvailabilityEvaluator;
import com.relia.network.Component;

/**
 * @author Rafael Rezende
 *
 */
public class IntervalAvailability {

	@Test
	public void ComponentIntervalAvailability() {
		Component t1 = new Component("t1",0.000336021505376344,0.0416666666666667,1355569200);
		
		double intAvail = AvailabilityEvaluator.getInstantAvailability(t1, t1.getDeploymentTime()+1000);
		intAvail += AvailabilityEvaluator.getInstantAvailability(t1, t1.getDeploymentTime()+1001);
		intAvail += AvailabilityEvaluator.getInstantAvailability(t1, t1.getDeploymentTime()+1002);
		intAvail += AvailabilityEvaluator.getInstantAvailability(t1, t1.getDeploymentTime()+1003);
		intAvail /= 4;
		
		assertEquals(intAvail, AvailabilityEvaluator.getIntervalAvailability(t1, t1.getDeploymentTime()+1000, t1.getDeploymentTime()+1003), 0);
	}

}
