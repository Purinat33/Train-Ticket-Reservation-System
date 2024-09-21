package test.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.shashi.beans.AdminBean;

public class AdminBeanTest {
	
	/*
	 * 	private static final long serialVersionUID = 1L;
	private String fName;
	private String lName;
	private String pWord;
	private String addR;
	private String mailId;
	private long phNo;
	 */
	AdminBean ab = new AdminBean();

	
	@Test
	public void testDefaultConstructorIsNotNull() {
		Assert.assertNotNull(ab);
	}
	
	@Test
	public void testGetterSetterString() {
		ab.setLName("Ken");
		Assert.assertEquals(ab.getLName(), "Ken");
	}
	
	@Test
	public void testGetterSetterLong() {
		ab.setPhNo(1239485);
		Assert.assertEquals(ab.getPhNo(), 1239485);
	}
	
	@Test
	public void testGetterNullString() {
		Assert.assertNull(ab.getAddr());
	}
	
	
	@Test
	public void testGetterNullLong() {
		AdminBean c = new AdminBean();
		Assert.assertEquals(c.getPhNo(), 0);
	}
	
	
	/*
	 * Object Creation: An instance of AdminBean is created and initialized with some values.

		Serialization:
		
		    A ByteArrayOutputStream is used to capture the serialized byte stream.
		    An ObjectOutputStream is created to write the ab object to the output stream.
		
		Deserialization:
		
		    A ByteArrayInputStream is created from the serialized data.
		    An ObjectInputStream reads the data back into a new AdminBean object (deserialized_adminbean).
		
		Assertions: The test checks that the name and phno of the ab match those of the deserialized_adminbean, confirming that the serialization and deserialization process works correctly.
	 * 
	 */
	@Test
	public void testSerialization() {
		ab.setAddr("Bangkok");
		ab.setFName("Minecraft");
		ab.setLName("China");
		ab.setMailId("michael@gmail.com");
		ab.setPhNo(12345);
		ab.setPWord("98765");
		
		// Garry Peter Trident
        // Serialize the object
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        try {
			ObjectOutputStream out = new ObjectOutputStream(byteOut);
			out.writeObject(ab);
	        out.flush();
	        byte[] serializedData = byteOut.toByteArray();
	        
	     // Deserialize the object
	        ByteArrayInputStream byteIn = new ByteArrayInputStream(serializedData);
	        ObjectInputStream in = new ObjectInputStream(byteIn);
	        AdminBean deserialized_admin = (AdminBean) in.readObject();

	        // Assert that the original and deserialized objects are equal
	        assertEquals(ab.getFName(), deserialized_admin.getFName());
	        assertEquals(ab.getPhNo(), deserialized_admin.getPhNo());
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
	}

}
