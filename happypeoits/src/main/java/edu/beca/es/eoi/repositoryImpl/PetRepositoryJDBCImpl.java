package edu.beca.es.eoi.repositoryImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.beca.es.eoi.dataManager.DataManager;
import edu.beca.es.eoi.entity.Bird;
import edu.beca.es.eoi.entity.Cat;
import edu.beca.es.eoi.entity.Dog;
import edu.beca.es.eoi.entity.Other;
import edu.beca.es.eoi.entity.Owner;
import edu.beca.es.eoi.entity.Pet;
import edu.beca.es.eoi.repository.PetRepository;
import lombok.extern.log4j.Log4j;

@Log4j
public class PetRepositoryJDBCImpl implements PetRepository {

	// Constants
	private static final boolean isTEST = false;

	@Override
	public Integer savePet(Pet e) {

		// Variables declaration
		log.info("Entramos en el metodo savePerson del repository");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		Integer idPet = 0;

		// Construction mysql petition
		log.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ");
		sql.append("pet(name, location, description, typePet, photo) ");
		sql.append("VALUES (?, ?, ?, ?, ?);");
		log.debug("Peticion a BBDD: " + sql.toString());

		if (conn != null) {
			try {
				log.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
				pst.setString(1, e.getName());
				pst.setString(2, e.getLocation());
				pst.setString(3, e.getDescription());
				pst.setInt(4, e.getTypepet());
				pst.setString(5, e.getPhoto());

				try {
					log.info("Se ejecuta la peticion");
					int line = pst.executeUpdate();
					if (line != 0) {
						ResultSet rs = pst.getGeneratedKeys();
						if (rs.next()) {
							idPet = rs.getInt(1);
						}
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
		return idPet;
	}

	@Override
	public boolean saveDog(Dog e) {
		// Variables declaration
		log.info("Entramos en el metodo saveDog del repository");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		boolean saveOK = false;

		// Construction mysql petition
		log.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ");
		sql.append("dog(age, idPet) ");
		sql.append("VALUES (?, ?);");
		log.debug("Peticion a BBDD: " + sql.toString());

		if (conn != null) {
			try {
				log.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setInt(1, e.getAge());
				pst.setInt(2, e.getIdPet());

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

	@Override
	public boolean saveCat(Cat e) {
		// Variables declaration
		log.info("Entramos en el metodo saveCat del repository");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		boolean saveOK = false;

		// Construction mysql petition
		log.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ");
		sql.append("cat(age, idPet) ");
		sql.append("VALUES (?, ?);");
		log.debug("Peticion a BBDD: " + sql.toString());

		if (conn != null) {
			try {
				log.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setInt(1, e.getAge());
				pst.setInt(2, e.getIdPet());

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

	@Override
	public boolean saveBird(Bird e) {
		// Variables declaration
		log.info("Entramos en el metodo saveBird del repository");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		boolean saveOK = false;

		// Construction mysql petition
		log.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ");
		sql.append("bird(colour, idPet) ");
		sql.append("VALUES (?, ?);");
		log.debug("Peticion a BBDD: " + sql.toString());

		if (conn != null) {
			try {
				log.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setString(1, e.getColour());
				pst.setInt(2, e.getIdPet());

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

	@Override
	public boolean saveOther(Other e) {
		// Variables declaration
		log.info("Entramos en el metodo saveOther del repository");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		boolean saveOK = false;

		// Construction mysql petition
		log.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ");
		sql.append("other(animalType, idPet) ");
		sql.append("VALUES (?, ?);");
		log.debug("Peticion a BBDD: " + sql.toString());

		if (conn != null) {
			try {
				log.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setString(1, e.getType());
				pst.setInt(2, e.getIdPet());

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

	@Override
	public Pet readById(Integer id) {
		// Declaracion de variables
		log.info("Entramos en el metodo readById del repository");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		Pet pet = null;
		Dog dog = null;
		Cat cat = null;
		Bird bird = null;
		Other other = null;
		Owner owner = null;

		// Construccion de la peticion
		log.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("CALL readByID(?);");
		log.debug("Peticion a BBDD: " + sql.toString());
		if (conn != null) {
			try {
				log.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setInt(1, id);
				try {
					log.info("Se ejecuta la peticion");
					ResultSet rs = pst.executeQuery();
					while (rs.next()) {
						// Segun el tipo de persona nos devolvera un estudiante, un profesor o un
						// personal de administracion

						if (rs.getInt("typepet") == 1) {
							owner = new Owner(rs.getString("ownername"), rs.getString("tlf"), id);
							dog = new Dog(rs.getInt("age"), id);
							pet = new Pet(rs.getString("name"), rs.getString("location"), rs.getString("description"),
									rs.getInt("typepet"), rs.getString("photo"), owner, dog);
						} else if (rs.getInt("typepet") == 2) {
							owner = new Owner(rs.getString("ownername"), rs.getString("tlf"), id);
							cat = new Cat(rs.getInt("age"), id);
							pet = new Pet(rs.getString("name"), rs.getString("location"), rs.getString("description"),
									rs.getInt("typepet"), rs.getString("photo"), owner, cat);
						} else if (rs.getInt("typepet") == 3) {
							owner = new Owner(rs.getString("ownername"), rs.getString("tlf"), id);
							bird = new Bird(rs.getString("colour"), id);
							pet = new Pet(rs.getString("name"), rs.getString("location"), rs.getString("description"),
									rs.getInt("typepet"), rs.getString("photo"), owner, bird);
						} else {
							owner = new Owner(rs.getString("ownername"), rs.getString("tlf"), id);
							other = new Other(rs.getString("animalType"), id);
							pet = new Pet(rs.getString("name"), rs.getString("location"), rs.getString("description"),
									rs.getInt("typepet"), rs.getString("photo"), owner, other);
						}
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

		return pet;
	}

	@Override
	public int readByName(String name) {
		// Variables declaration
		log.info("Entramos en el metodo savePerson del repository");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		Integer idPet = 0;

		// Construction mysql petition
		log.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id ");
		sql.append("FROM pet WHERE name = ?");
		log.debug("Peticion a BBDD: " + sql.toString());
		if (conn != null) {
			try {
				log.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setString(1, name);

				try {
					log.info("Se ejecuta la peticion");
					ResultSet rs = pst.executeQuery();

					while (rs.next()) {
						idPet = rs.getInt("id");
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

		return idPet;
	}

	@Override
	public boolean uploadPet(int idPet, String newname, String newlocation, String newdescription, String newOwnerName,
			String newtlf, String newphoto, int newage, String newColour, String newType) {
		// Declaracion de variables
		log.info("Entramos en el metodo readById del repository");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		boolean uploadOK = false;

		// Construccion de la peticion
		log.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("CALL uploadbyid(?,?,?,?,?,?,?,?,?,?);");
		log.debug("Peticion a BBDD: " + sql.toString());

		if (conn != null) {
			try {
				log.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setInt(1, idPet);
				pst.setString(2, newname);
				pst.setString(3, newlocation);
				pst.setString(4, newdescription);
				pst.setString(5, newOwnerName);
				pst.setString(6, newtlf);
				pst.setString(7, newphoto);
				pst.setInt(8, newage);
				pst.setString(9, newColour);
				pst.setString(10, newType);

				try {
					log.info("Se ejecuta la peticion");
					int line = pst.executeUpdate();
					if (line != 0) {
						uploadOK = true;
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
		return uploadOK;
	}

	@Override
	public boolean deletePet(Integer id) {
		// Declaracion de variables
		log.info("Entramos en el metodo readById del repository");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		boolean deleteOK = false;

		// Construccion de la peticion
		log.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM pet WHERE id = ?;");
		log.debug("Peticion a BBDD: " + sql.toString());
		if (conn != null) {
			try {
				log.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setInt(1, id);

				try {
					log.info("Se ejecuta la peticion");
					int line = pst.executeUpdate();
					if (line != 0) {
						deleteOK = true;
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
		return deleteOK;
	}

}
