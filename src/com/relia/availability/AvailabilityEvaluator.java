/**
 * 
 */
package com.relia.availability;

import com.relia.network.Component;

/**
 * This class contains methods for availability evaluation.
 * It evaluates Instantaneous, Interval and Steady-State availability.
 * 
 * @author Rafael Rezende
 * 
 */
final public class AvailabilityEvaluator {

	/**
	 * Evaluates the Instantaneous Availability for given failure and repair
	 * rates, and specific relative time. It considers the availability is
	 * maximum at t = 0.
	 * 
	 * @param failureRate
	 *            Failure rate of the component.
	 * @param repairRate
	 *            Repair rate of the component.
	 * @param t
	 *            Relative EPOCH time of the component.
	 * @return Instantaneous availability at instant t.
	 */
	public static double getInstantAvailability(double failureRate, double repairRate, int t) {
		// In case of negative time, availability is zero.
		if (t < 0) return 0;
		// Otherwise, evaluate accordingly. Convert seconds (EPOCH time) to hours
		return (repairRate / (failureRate + repairRate) + failureRate
				/ (failureRate + repairRate)
				* Math.pow(Math.E, -(failureRate + repairRate) * ((double)t)/3600));
	}
	
	/**
	 * Evaluates the Instantaneous Availability for given component, and
	 * specific absolute time. It considers the availability is maximum at
	 * Component.deploymentTime. Input time t is absolute, so that the
	 * availability is evaluate at instant t-deploymentTime.
	 * Example: If component was deployed at epoch time 13578000, and the 
	 * given absolute time 13578100, the availability will be evaluated 
	 * for the relative instant t=100.
	 * 
	 * @param comp Evaluated component.
	 * @param t Absolute EPOCH time.
	 * @retur Instantaneous availability at instant (t-Component.deploymentTime)
	 */
	public static double getInstantAvailability(Component comp, int t) {
		return getInstantAvailability(comp.getFailureRate(), comp.getRepairRate(), t-comp.getDeploymentTime());
	}
	
	/**
	 * Get steady-state availability from given failure and repair rates.
	 * Steady-state evaluation is time-independent.
	 * 
	 * @param failureRate Failure rate of the component.
	 * @param repairRate Repair Rate of the component.
	 * @return Steady-state availability.
	 */
	public static double getSteadyAvailability(double failureRate, double repairRate) {
		return failureRate/(failureRate+repairRate);
	}
	
	/**
	 * Get steady-state availability of a given component.
	 * 
	 * @param comp Evaluated component.
	 * @return Steady-state availability of the component.
	 */
	public static double getSteadyAvailability(Component comp) {
		return getSteadyAvailability(comp.getFailureRate(), comp.getRepairRate());
	}
	
	/**
	 * Get Interval Availability from given failure and repair rates.
	 * Interval Availability is the average of Instantaneous availability within a range.
	 * This range is provided from start time startT to final time finalT.
	 * 
	 * @param failureRate Failure rate of the component.
	 * @param repairRate Repair rate of the component.
	 * @param startT Start time of the interval range.
	 * @param finalT Final time of the interval range.
	 * @return Interval availability.
	 */
	public static double getIntervalAvailability(double failureRate, double repairRate, int startT, int finalT) {
		
		double cumulatedAvailability = 0;
		for (int i = startT; i <= finalT; i++) {
			cumulatedAvailability += getInstantAvailability(failureRate, repairRate, i);
		}
		return cumulatedAvailability/(finalT-startT+1);
	}
	
	/**
	 * Get Interval Availability of a given component.
	 * Interval Availability is the average of Instantaneous availability within a range.
	 * This range is provided from start time startT to final time finalT.
	 * 
	 * @param comp Evaluated component.
	 * @param startT Start time of the interval range.
	 * @param finalT Final time of the interval range.
	 * @return Interval availability of the component.
	 */
	public static double getIntervalAvailability(Component comp, int startT, int finalT) {
		return getIntervalAvailability(comp.getFailureRate(), comp.getRepairRate(), startT-comp.getDeploymentTime(), finalT-comp.getDeploymentTime());
	}
	
	public static double getParallelAvailability(double availA, double availB) {
		return 1-(1-availA)*(1-availB);
	}
	
	public static double getParallelAvailability(Component compA, int startTimeA, int finalTimeA, Component compB, int startTimeB, int finalTimeB) {
		return getParallelAvailability(
				getIntervalAvailability(compA, startTimeA, finalTimeA), 
				getIntervalAvailability(compB, startTimeB, finalTimeB));
	}
	
	public static double getSerialAvailability(double availA, double availB) {
		return availA * availB;
	}
	
	public static double getSerialAvailability(Component compA, int startTimeA, int finalTimeA, Component compB, int startTimeB, int finalTimeB) {
		return getSerialAvailability(
				getIntervalAvailability(compA, startTimeA, finalTimeA), 
				getIntervalAvailability(compB, startTimeB, finalTimeB));
	}

}
