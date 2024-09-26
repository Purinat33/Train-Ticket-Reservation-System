package test.bean;

import com.shashi.beans.TrainException;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TrainExceptionBeanTest {

	// Test Exception Throwing
	@Test
	public void testGetErrorMessageFromResponseCode() {
		TrainException te = new TrainException(com.shashi.constant.ResponseCode.SUCCESS);
		assertEquals(te.getErrorMessage(), "OK");
	}
	
	@Test
	public void testGetErrorCodeFromMessage() {
		TrainException te = new TrainException("Unable to Connect to DB, Please Check your db credentials in application.properties");
		assertEquals(te.getErrorCode(), "BAD_REQUEST"); // every error code is BAD_REQUEST when translating to error code via string
	}
	
	@Test
	public void testGetStatusCodeFromErrorCode() {
		TrainException te = new TrainException(com.shashi.constant.ResponseCode.METHOD_NOT_ALLOWED);
		assertEquals(te.getStatusCode(), 405);
		assertEquals(te.getErrorMessage(), "Requested HTTP method is not supported by this URL");
	}
	
	 @Test
	    public void testGetStatusCodeFromResponseCode() {
	        TrainException te = new TrainException(com.shashi.constant.ResponseCode.METHOD_NOT_ALLOWED); // Use proper ResponseCode
	        assertEquals(te.getStatusCode(), 405); // Testing with correct status code
	        assertEquals(te.getErrorMessage(), "Requested HTTP method is not supported by this URL"); // Verifying the message
	    }
	
	

}
