package edu.beca.es.eoi.aleoixaRepositoryImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.aleoixaDataManager.DataManager;
import edu.beca.es.eoi.aleoixaRepository.TranslateRepository;

public class TranslateRepositoryJDCBImpl implements TranslateRepository {
	private Logger logger = Logger.getLogger(JokesRepositoryJDBCImpl.class);
	private static final boolean isTEST = false;

	@Override
	public String readBySpanishWord(String englishword) {

		// Declaracion de variables
		logger.info("Entramos en el metodo Read by spanishWord");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		String translatedWord = null;

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT spanish FROM translate");
		sql.append(" WHERE english = ?;");
		logger.debug("Peticion a BBDD: " + sql.toString());

		if (conn != null) {
			try {
				logger.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setString(1, englishword);

				try {
					logger.info("Se ejecuta la peticion");
					ResultSet rs = pst.executeQuery();
					while (rs.next()) {
						translatedWord = rs.getString("spanish");
					}
				} finally {
					logger.info("Se cierra la peticion a BBDD");
					pst.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				logger.info("Se llama al metodo closeConnection");
				dataManager.closeConnection(conn);
			}
		}
		return translatedWord;
	}

	@Override
	public String readByEnglishWord(String spanishword) {

		// Declaracion de variables
		logger.info("Entramos en el metodo Read by englishWord");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		String translatedWord = null;

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT english FROM translate");
		sql.append(" WHERE spanish = ?;");
		logger.debug("Peticion a BBDD: " + sql.toString());

		if (conn != null) {
			try {
				logger.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setString(1, spanishword);

				try {
					logger.info("Se ejecuta la peticion");
					ResultSet rs = pst.executeQuery();
					while (rs.next()) {
						translatedWord = rs.getString("english");
					}
				} finally {
					logger.info("Se cierra la peticion a BBDD");
					pst.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				logger.info("Se llama al metodo closeConnection");
				dataManager.closeConnection(conn);
			}
		}
		return translatedWord;
	}

}
