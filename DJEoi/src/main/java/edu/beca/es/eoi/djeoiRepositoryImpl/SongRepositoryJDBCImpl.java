package edu.beca.es.eoi.djeoiRepositoryImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.djeoiDataController.DataManager;
import edu.beca.es.eoi.djeoiEntity.Song;
import edu.beca.es.eoi.djeoiMain.MainDj;
import edu.beca.es.eoi.djeoiRepository.SongRepository;

public class SongRepositoryJDBCImpl implements SongRepository {
	private static final Logger logger = Logger.getLogger(MainDj.class);
	private static final boolean isTEST = false;

	@Override
	public boolean save(Song e) {
		// Variables declaration
		logger.info("Entramos en el metodo savePerson del repository");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		boolean saveOK = false;

		// Petitions construction
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ");
		sql.append("songs (songName, songvalue) ");
		sql.append("VALUES (?, ?);");
		logger.debug("Peticion a BBDD: " + sql.toString());

		if (conn != null) {
			try {
				logger.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setString(1, e.getSongName());
				pst.setString(2, e.getSongValue());

				try {
					logger.info("Se ejecuta la peticion");
					int line = pst.executeUpdate();
					if (line != 0) {
						saveOK = true;
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
		return saveOK;
	}

	@Override
	public Map<String, String> readAllSongs() {

		// Variables declaration
		logger.info("Entramos en el metodo read Person del repository");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		Map<String, String> songs = new TreeMap<String, String>();

		// Petition construction
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT s.songName,s.songvalue");
		sql.append(" FROM songs s ");
		logger.debug("Peticion a BBDD: " + sql.toString());
		if (conn != null) {
			try {
				logger.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				try {
					logger.info("Se ejecuta la peticion");
					ResultSet rs = pst.executeQuery();
					while (rs.next()) {
						songs.put(rs.getString("s.songName"), rs.getString("s.songvalue"));
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

		return songs;
	}

	@Override
	public boolean delete(String songName) {
		// Variables declaration
		logger.info("Entramos en el metodo savePerson del repository");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		boolean deleteOK = false;

		// Petition construction
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM songs ");
		sql.append("WHERE songName = ?; ");
		logger.debug("Peticion a BBDD: " + sql.toString());

		if (conn != null) {
			try {
				logger.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setString(1, songName);

				try {
					logger.info("Se ejecuta la peticion");
					int line = pst.executeUpdate();
					if (line != 0) {
						deleteOK = true;
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
		return deleteOK;

	}

}
