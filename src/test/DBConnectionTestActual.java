package test;

import static org.junit.jupiter.api.Assertions.*;

import com.shashi.beans.TrainException;
import com.shashi.utility.DBUtil;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class DBConnectionTestActual {
	
	// Somehow even if you can run/connect to the database in actual "Run On Server", the test will still gives out "SQLException: No suitable Driver Found for jdbc:oracle:thin:@//localhost:1521/orcl"
	// So you need to download JDBC JAR at https://download.oracle.com/otn-pub/otn_software/jdbc/235/ojdbc11.jar
	// And add it as "External JAR" in Build Path
	
	// cr: https://stackoverflow.com/questions/12103369/sqlexception-no-suitable-driver-found-for-jdbcoraclethin-localhost1521-or
	private static Connection connection;
	
	@BeforeAll
	public static void setup() throws TrainException{
		connection = DBUtil.getConnection();
	}
	
	@Test
	public void testConnected() {
		assertNotNull(connection);
	}
	
	@Test
	public void testGetAdmin() throws SQLException {
		// Test that there is at least one row in the ADMIN table
		String query = "SELECT COUNT(*) AS rowcount FROM ADMIN";
		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			int count_returned_rows = rs.getInt("rowcount");
			assertTrue(count_returned_rows > 0); // Admin table is not empty
		}
		else {
			fail("Failed to fetch Database content");
		}
	}
	
	@Test
	public void testInsertInvalidData() throws SQLException{
		// ADMIN
		/*
		CREATE TABLE "RESERVATION"."ADMIN"
		(	
		"MAILID" VARCHAR2(40) PRIMARY KEY, 
		"PWORD" VARCHAR2(20) NOT NULL, 
		"FNAME" VARCHAR2(20) NOT NULL, 
		"LNAME" VARCHAR2(20), 
		"ADDR" VARCHAR2(100), 
		"PHNO" NUMBER(12) NOT NULL
		);
		 */
		
		String query = "INSERT INTO ADMIN (MAILID, PWORD, FNAME, LNAME, ADDR, PHNO) VALUES (?, ?, ?, ?, ?, ?)";
		try(PreparedStatement ps = connection.prepareStatement(query)){
			ps.setString(1, "owner@owner.com");
			ps.setString(2, "12345");
			ps.setString(3, null);
			ps.setLong(4, 999999999999L);
			
			//Should throw
			assertThrows(SQLException.class, ps::executeUpdate);
		}
	}
	
	@AfterAll
	public static void testClosingConnection() {
		assertNotNull(connection);
		try {
			if(!connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
