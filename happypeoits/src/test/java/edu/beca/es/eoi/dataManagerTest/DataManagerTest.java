package edu.beca.es.eoi.dataManagerTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.dataManager.DataManager;

class DataManagerTest {

	@Test
	void getConnection() {
		boolean isTEST = true;
		Connection conn = null;
		DataManager dataManager = new DataManager();
		conn = dataManager.getConnection(isTEST);
		assertNotNull(conn);
		if (conn != null) {
			dataManager.closeConnection(conn);
		}
	}

	@Test
	void testPropertiesAplicate() {

		String dbUrl = null, dbUser = null, dbPass = null;

		DataManager dataManager = new DataManager();
		dataManager.propertiesAplicate();

		dbUrl = dataManager.getDbUrl();
		dbUser = dataManager.getDbUsuario();
		dbPass = dataManager.getDbPass();

		assertNotNull(dbUrl);
		assertNotNull(dbUser);
		assertNotNull(dbPass);

	}
}