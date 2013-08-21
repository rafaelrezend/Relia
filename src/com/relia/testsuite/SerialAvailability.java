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
public class SerialAvailability {

	@Test
	public void ParametersSerialAvailability() {
		double availA = 0.99991234;
		double availB = 0.9999;
		
		assertEquals((availA*availB), AvailabilityEvaluator.getSerialAvailability(availA, availB), 0);
	}
	
	@Test
	public void ComponentsSerialAvailability() {
		
		Component t1 = new Component("t1",0.000336021505376344,0.0416666666666667,1355569200);
		Component t2 = new Component("t2",0.000336021505376344,0.0416666666666667,1355569200);
		
		double availA = AvailabilityEvaluator.getInstantAvailability(t1, t1.getDeploymentTime()+1000);
		double availB = AvailabilityEvaluator.getInstantAvailability(t2, t2.getDeploymentTime()+2000);
		
		assertEquals((availA*availB), AvailabilityEvaluator.getSerialAvailability(t1, t1.getDeploymentTime()+1000, t1.getDeploymentTime()+1000, t2, t2.getDeploymentTime()+2000, t2.getDeploymentTime()+2000), 0);
	}

}
