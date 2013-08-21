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
public class SteadyStateAvailability {

	@Test
	public void ParametersSteadyStateAvailability() {
		double failureRate = 0.000336021505376344;
		double repairRate = 0.0416666666666667;
		
		assertEquals((failureRate/(failureRate+repairRate)), AvailabilityEvaluator.getSteadyAvailability(failureRate, repairRate), 0);
	}
	
	@Test
	public void ComponentSteadyStateAvailability() {
		double failureRate = 0.000336021505376344;
		double repairRate = 0.0416666666666667;
		Component t1 = new Component("t1",failureRate,repairRate,1355569200);
		
		assertEquals((failureRate/(failureRate+repairRate)), AvailabilityEvaluator.getSteadyAvailability(t1), 0);
	}

}
