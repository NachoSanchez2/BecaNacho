package edu.beca.es.eoi.repositoryImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.beca.es.eoi.dataManager.DataManager;
import edu.beca.es.eoi.entity.Owner;
import edu.beca.es.eoi.repository.OwnerRepository;
import lombok.extern.log4j.Log4j;

@Log4j
public class OwnerRepositoryJDBCImpl implements OwnerRepository {
	// Constants
	private static final boolean isTEST = false;

	@Override
	public boolean saveOwner(Owner owner) {
		// Variables declaration
		log.info("Entramos en el metodo saveOwner del repository");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		boolean saveOK = false;

		// Construction mysql petition
		log.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ");
		sql.append("owner(ownername, tlf, idPet) ");
		sql.append("VALUES (?, ?, ?);");
		log.debug("Peticion a BBDD: " + sql.toString());

		if (conn != null) {
			try {
				log.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setString(1, owner.getName());
				pst.setString(2, owner.getPhone());
				pst.setInt(3, owner.getIdPet());

				try {
					log.info("Se ejecuta la peticion");
					int line = pst.executeUpdate();
					if (line != 0) {
						saveOK = true;
					}
				} finally {
					log.info("Se cierra la peticion a BBDD");
					pst.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				log.info("Se llama al metodo closeConnection");
				dataManager.closeConnection(conn);
			}
		}
		return saveOK;
	}

}
