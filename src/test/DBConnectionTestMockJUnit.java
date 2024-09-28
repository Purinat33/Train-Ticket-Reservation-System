package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.shashi.utility.DBUtil;

// Because we should use mock database to not blow everything up in production

class DBConnectionTestMockJUnit {

	private static Connection connection;
	
	@BeforeAll
	public static void setup() throws IOException, SQLException {
	    // Simulate the production schema in H2 for testing
	    ResourceBundle rb = ResourceBundle.getBundle("test-application");
	    connection = DBUtil.getConnection();
	    
	    // Initialize the in-memory database schema
	    Statement stmt = connection.createStatement();
	    String schemaSql = new String(Files.readAllBytes(Paths.get("src/test/resources/schema.sql")));
	    stmt.execute(schemaSql);
	}


}
