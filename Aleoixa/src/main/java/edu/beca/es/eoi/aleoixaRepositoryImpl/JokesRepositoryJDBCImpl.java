package edu.beca.es.eoi.aleoixaRepositoryImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.aleoixaDataManager.DataManager;
import edu.beca.es.eoi.aleoixaRepository.JokesRepository;

public class JokesRepositoryJDBCImpl implements JokesRepository {

	private Logger logger = Logger.getLogger(JokesRepositoryJDBCImpl.class);
	private static final boolean isTEST = false;

	@Override
	public String readById(Integer id) {
		// Declaracion de variables
		logger.info("Entramos en el metodo Save");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		String joke = null;

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT j.joke FROM jokes j");
		sql.append(" WHERE j.id = ?;");
		logger.debug("Peticion a BBDD: " + sql.toString());

		if (conn != null) {
			try {
				logger.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setInt(1, id);

				try {
					logger.info("Se ejecuta la peticion");
					ResultSet rs = pst.executeQuery();
					while (rs.next()) {
						joke = rs.getString("j.joke");
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
		return joke;
	}

}
