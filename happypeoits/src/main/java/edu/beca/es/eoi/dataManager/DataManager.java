package edu.beca.es.eoi.dataManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Getter
@Setter
@Log4j
public class DataManager {
	private Properties properties = new Properties();
	private String dbUrl;
	private String dbUsuario;
	private String dbPass;

	public Connection getConnection(boolean isTEST) {
		log.info("Entro en el metodo getConnection");
		log.info("llamo al metodo propertiesAplicate");
		propertiesAplicate();

		Connection conn = null;
		log.info("Aqui abro la conexion con un patron singletone");
		log.debug("Los parametros de conexion son: Url: " + getDbUrl() + " User: " + getDbUsuario() + " Password: "
				+ getDbPass());
		try {
			conn = DriverManager.getConnection(getDbUrl(), getDbUsuario(), getDbPass());
			if (isTEST) {
				conn.setAutoCommit(false);
			} else {
				conn.setAutoCommit(true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.debug("Could not connect to DB: " + e.getStackTrace());
		}
		return conn;
	}

	public void propertiesAplicate() {
		log.info("llamo al metodo readProperties");
		try {
			readProperties();
		} catch (IOException e) {
			log.debug("Could not found file .properties: " + e.getStackTrace());
		}
		setDbUrl(properties.getProperty("BBDD.url"));
		setDbUsuario(properties.getProperty("BBDD.user"));
		setDbPass(properties.getProperty("BBDD.pass"));
	}

	public void readProperties() throws IOException {
		log.info("Entro en el metodo readProperties de mi aplicacion:");
		log.debug("Ruta del archivo: " + "src/main/resources/happypeoits.properties");

		FileInputStream input = new FileInputStream(new File("src/main/resources/happypeoits.properties"));

		properties.load(input);
		log.info("Salgo del metodo readProperties de mi aplicacion:");

	}

	public void closeConnection(Connection conn) {
		log.info("Se cierra la conexion");
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

}