package test.constant;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.shashi.constant.UserRole;

public class UserRoleTest {

	@Test
	public void testNotTheSame() {
		assertNotEquals(UserRole.ADMIN, UserRole.CUSTOMER);
	}
	
	@Test
	public void testName() {
		assertEquals(UserRole.ADMIN.name(), "ADMIN");
		assertEquals(UserRole.CUSTOMER.name(), "CUSTOMER");
	}
	
	@Test
	public void testInvalidName() {
		// Should throw illegalArgumentException if we give invalid role
		assertThrows(IllegalArgumentException.class, () ->{
			UserRole.valueOf("MANAGER");
		});
	}
	

}
