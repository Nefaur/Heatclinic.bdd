package com.heatclinic.junitrunner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import com.heatclinic.junittests.InvalidLoginJUnit;
import com.heatclinic.junittests.SearchTestJUnit;
import com.heatclinic.junittests.ValidCheckoutJUnit;
import com.heatclinic.junittests.ValidLoginJUnit;

@RunWith(Suite.class)

@Suite.SuiteClasses({ 
//					ValidLoginJUnit.class,
//					InvalidLoginJUnit.class,
//					SearchTestJUnit.class,
					ValidCheckoutJUnit.class
					})

public class JunitTestRunner {
}
