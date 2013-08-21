package com.relia.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ InstantaneousAvailability.class, IntervalAvailability.class,
		MergedPaths.class, NetworkGeneration.class, ParallelAvailability.class,
		SerialAvailability.class, SteadyStateAvailability.class })
public class AllTests {

}
