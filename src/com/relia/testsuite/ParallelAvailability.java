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
public class ParallelAvailability {

	@Test
	public void ParametersParallelAvailability() {
		
		double availA = 0.99991234;
		double availB = 0.9999;
		
		assertEquals((1-(1-availA)*(1-availB)), AvailabilityEvaluator.getParallelAvailability(availA, availB), 0);
	}
	
	@Test
	public void ComponentsParallelAvailability() {
		
		Component t1 = new Component("t1",0.000336021505376344,0.0416666666666667,1355569200);
		Component t2 = new Component("t2",0.000336021505376344,0.0416666666666667,1355569200);
		
		double availA = AvailabilityEvaluator.getInstantAvailability(t1, t1.getDeploymentTime()+1000);
		double availB = AvailabilityEvaluator.getInstantAvailability(t2, t2.getDeploymentTime()+2000);
		
		assertEquals((1-(1-availA)*(1-availB)), AvailabilityEvaluator.getParallelAvailability(t1, t1.getDeploymentTime()+1000, t1.getDeploymentTime()+1000, t2, t2.getDeploymentTime()+2000, t2.getDeploymentTime()+2000), 0);
	}
}
