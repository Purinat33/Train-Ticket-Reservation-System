package test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import test.bean.*;

@Suite
@SelectClasses({ AdminBeanTest.class, BookingDetailsBeanTest.class, TrainExceptionBeanTest.class })
public class BeanTestSuite {
 // Keep empty, it will run all the classes
}
