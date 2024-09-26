package test.constant;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Optional;


import com.shashi.constant.ResponseCode;

public class ResponseCodeTest {

	@Test
	public void testGetStatusCodeByValue() {
		assertEquals(ResponseCode.SUCCESS.getCode(), 200);
		assertEquals(ResponseCode.FAILURE.getCode(), 422);
		assertEquals(ResponseCode.NO_CONTENT.getCode(), 204);
		assertEquals(ResponseCode.PAGE_NOT_FOUND.getCode(), 404);
		assertEquals(ResponseCode.ACCESS_DENIED.getCode(), 403);
		assertEquals(ResponseCode.BAD_REQUEST.getCode(), 400);
		assertEquals(ResponseCode.UNAUTHORIZED.getCode(), 401);
		assertEquals(ResponseCode.SESSION_EXPIRED.getCode(), 401);
		assertEquals(ResponseCode.INTERNAL_SERVER_ERROR.getCode(), 500);
		assertEquals(ResponseCode.DATABASE_CONNECTION_FAILURE.getCode(), 406);
		assertEquals(ResponseCode.METHOD_NOT_ALLOWED.getCode(), 405);
	}
	
	@Test
	public void testGetMessageByValue() {
		assertEquals(ResponseCode.SUCCESS.getMessage(), "OK");
		assertEquals(ResponseCode.FAILURE.getMessage(), "Unprocessible Entity, Failed to Process");
		assertEquals(ResponseCode.NO_CONTENT.getMessage(), "No Items Found");
		assertEquals(ResponseCode.PAGE_NOT_FOUND.getMessage(), "The Page You are Searching For is Not available");
		assertEquals(ResponseCode.ACCESS_DENIED.getMessage(), "Please Login First to continue");
		assertEquals(ResponseCode.BAD_REQUEST.getMessage(), "Bad Request, Please Try Again");
		assertEquals(ResponseCode.UNAUTHORIZED.getMessage(), "Invalid Credentials, Try Again");
		assertEquals(ResponseCode.SESSION_EXPIRED.getMessage(), "Session Expired, Login Again to Continue");
		assertEquals(ResponseCode.INTERNAL_SERVER_ERROR.getMessage(), "Internal Server Error, Try Again!!");
		assertEquals(ResponseCode.DATABASE_CONNECTION_FAILURE.getMessage(), "Unable to Connect to DB, Please Check your db credentials in application.properties");
		assertEquals(ResponseCode.METHOD_NOT_ALLOWED.getMessage(), "Requested HTTP method is not supported by this URL");
	}
	
	@Test
	public void testReverseLookup() {
		Optional<ResponseCode> successResponse = ResponseCode.getMessageByStatusCode(200);
        assertTrue(successResponse.isPresent());
        assertEquals(ResponseCode.SUCCESS, successResponse.get());
        
        Optional<ResponseCode> pageNotFoundResponse = ResponseCode.getMessageByStatusCode(404);
        assertTrue(pageNotFoundResponse.isPresent());
        assertEquals(ResponseCode.PAGE_NOT_FOUND, pageNotFoundResponse.get());

        Optional<ResponseCode> badRequestResponse = ResponseCode.getMessageByStatusCode(400);
        assertTrue(badRequestResponse.isPresent());
        assertEquals(ResponseCode.BAD_REQUEST, badRequestResponse.get());

        // Test non-existing status code (should return empty Optional)
        Optional<ResponseCode> nonExistentResponse = ResponseCode.getMessageByStatusCode(999);
        assertFalse(nonExistentResponse.isPresent());
	}
	
	@Test
	public void testInvalidStatus() {
		Optional<ResponseCode> nonExistentResponse = ResponseCode.getMessageByStatusCode(350);
        assertFalse(nonExistentResponse.isPresent());
	}
	
	

}
