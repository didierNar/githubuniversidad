import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		
		Persistence.createEntityManagerFactory("jpa_pu").createEntityManager();

	}

}
