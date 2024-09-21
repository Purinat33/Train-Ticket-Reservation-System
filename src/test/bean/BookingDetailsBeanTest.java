package test.bean;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.shashi.beans.BookingDetails;

public class BookingDetailsBeanTest {


	BookingDetails bd = new BookingDetails();
	
	@Test
	public void testGetterSetterDouble() {
		bd.setAmount(234.56);
		assertEquals(bd.getAmount(), 234.56);
	}
	
	@Test
	public void testGetterSetterInt() {
		bd.setSeats(35);
		assertEquals(bd.getSeats(), 35);
	}

}
