package test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import test.constant.*;


@Suite
@SelectClasses({ResponseCodeTest.class, UserRoleTest.class})
public class ConstantTestSuite {

}
