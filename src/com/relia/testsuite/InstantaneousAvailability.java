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
public class InstantaneousAvailability {

	@Test
	public void ParametersInstantAvailability() {
		assertEquals(1, AvailabilityEvaluator.getInstantAvailability(0.000336021505376344, 0.0416666666666667, 0), 0);
		assertEquals(0, AvailabilityEvaluator.getInstantAvailability(0.000336021505376344, 0.0416666666666667, -1), 0);
		assertEquals(0.9999072031, AvailabilityEvaluator.getInstantAvailability(0.000336021505376344, 0.0416666666666667, 1000), 0.00000000001);
	}
	
	@Test
	public void ComponentInstantAvailability() {
		Component t1 = new Component("t1",0.000336021505376344,0.0416666666666667,1355569200);
		
		assertEquals(1, AvailabilityEvaluator.getInstantAvailability(t1, t1.getDeploymentTime()), 0);
		assertEquals(0, AvailabilityEvaluator.getInstantAvailability(t1, t1.getDeploymentTime()-1), 0);
		assertEquals(0.9999072031, AvailabilityEvaluator.getInstantAvailability(t1, t1.getDeploymentTime()+1000), 0.00000000001);
	}

}
