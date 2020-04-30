
package it.polito.tdp.poweroutages.DAO;

import java.sql.Connection;

public class TestPowerOutagesDAO {

	public static void main(String[] args) {
		
		try {
			Connection connection = ConnectDB.getConnection();
			connection.close();
			System.out.println("Connection Test PASSED");
			
			PowerOutageDAO dao = new PowerOutageDAO() ;
		
			System.out.println(dao.getNercList()) ;
			System.out.println(dao.getPowerOutageforNerc(dao.getNercList().get(3)));

		} catch (Exception e) {
			System.err.println("Test FAILED");
		}

	}

}
