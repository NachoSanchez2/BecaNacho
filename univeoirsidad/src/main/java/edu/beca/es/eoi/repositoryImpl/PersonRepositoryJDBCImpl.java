package edu.beca.es.eoi.repositoryImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.dataManager.DataManager;
import edu.beca.es.eoi.entity.Pas;
import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.entity.Professor;
import edu.beca.es.eoi.entity.Student;
import edu.beca.es.eoi.repository.PersonRepository;

public class PersonRepositoryJDBCImpl implements PersonRepository {

	private static final Logger logger = Logger.getLogger(PersonRepositoryJDBCImpl.class);
	public static final boolean isTEST = false;

	@Override
	public boolean save(Person e) {
		// Declaracion de variables
		logger.info("Entramos en el metodo savePerson del repository");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		boolean saveOK = false;

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ");
		sql.append("useruniversity (name, dni, surname, mail, username, password, tipoPersona) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?);");
		logger.debug("Peticion a BBDD: " + sql.toString());

		if (conn != null) {
			try {
				logger.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setString(1, e.getName());
				pst.setString(2, e.getDni());
				pst.setString(3, e.getSurname());
				pst.setString(4, e.getMail());
				pst.setString(5, e.getUsername());
				pst.setString(6, e.getPassword());
				pst.setInt(7, e.getTipoPersona());

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
	public boolean saveStudent(int idUser, Person e) {
		// Declaracion de variables
		logger.info("Entramos en el metodo saveStudent del repository");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		boolean saveOK = false;

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ");
		sql.append("studentuniversity (faculty, idUser) ");
		sql.append("VALUES (?,?);");
		logger.debug("Peticion a BBDD: " + sql.toString());
		if (conn != null) {
			try {
				logger.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setString(1, ((Student) e).getFaculty());
				pst.setInt(2, e.getId());

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
	public boolean saveProfessor(int idUser, Person e) {
		// Declaracion de variables
		logger.info("Entramos en el metodo saveProfessor del repository");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		boolean saveOK = false;

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ");
		sql.append("professoruniversity (office, idUser) ");
		sql.append("VALUES (?,?);");
		logger.debug("Peticion a BBDD: " + sql.toString());
		if (conn != null) {
			try {
				logger.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setString(1, ((Professor) e).getOffice());
				pst.setInt(2, e.getId());

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
	public boolean savePas(int idUser, Person e) {
		// Declaracion de variables
		logger.info("Entramos en el metodo savePas del repository");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		boolean saveOK = false;

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ");
		sql.append("pasuniversity (unit, idUser) ");
		sql.append("VALUES (?,?);");
		logger.debug("Peticion a BBDD: " + sql.toString());
		if (conn != null) {
			try {
				logger.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setString(1, ((Pas) e).getUnit());
				pst.setInt(2, e.getId());

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
	public Person read(String username, String dni) {
		// Declaracion de variables
		logger.info("Entramos en el metodo read Person del repository");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		Person userUniversity = null;

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u.id,u.name, u.dni, u.surname, u.mail, u.username, u.password, u.tipoPersona");
		sql.append(" FROM useruniversity u ");
		sql.append(" WHERE u.username = ?");
		sql.append(" OR u.dni = ?");
		logger.debug("Peticion a BBDD: " + sql.toString());
		if (conn != null) {
			try {
				logger.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setString(1, username);
				pst.setString(2, dni);
				try {
					logger.info("Se ejecuta la peticion");
					ResultSet rs = pst.executeQuery();
					while (rs.next()) {
						// Segun el tipo de persona nos devolvera un estudiante, un profesor o un
						// personal de administracion
						userUniversity = new Person(rs.getInt("id"), rs.getString("name"), rs.getString("dni"),
								rs.getString("surname"), rs.getString("mail"), username, rs.getString("password"),
								rs.getInt("u.tipoPersona"));
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

		return userUniversity;

	}

	@Override
	public Person readByUsername(int tipoPersona, String username) {
		// Declaracion de variables
		logger.info("Entramos en el metodo readByUsername del repository");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		Person userUniversity = null;

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("CALL readbyUsername(?,?);");
		logger.debug("Peticion a BBDD: " + sql.toString());
		if (conn != null) {
			try {
				logger.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setInt(1, tipoPersona);
				pst.setString(2, username);
				try {
					logger.info("Se ejecuta la peticion");
					ResultSet rs = pst.executeQuery();
					while (rs.next()) {
						// Segun el tipo de persona nos devolvera un estudiante, un profesor o un
						// personal de administracion

						if (tipoPersona == 1) {
							userUniversity = new Student(rs.getInt("id"), rs.getString("name"), rs.getString("dni"),
									rs.getString("surname"), rs.getString("mail"), username, rs.getString("password"),
									tipoPersona, rs.getString("faculty"), rs.getInt("idUser"));
						} else if (tipoPersona == 2) {
							userUniversity = new Professor(rs.getInt("id"), rs.getString("name"), rs.getString("dni"),
									rs.getString("surname"), rs.getString("mail"), rs.getString("username"),
									rs.getString("password"), tipoPersona, rs.getString("office"), rs.getInt("idUser"));
						} else if (tipoPersona == 3) {

							userUniversity = new Pas(rs.getInt("id"), rs.getString("name"), rs.getString("dni"),
									rs.getString("surname"), rs.getString("mail"), rs.getString("username"),
									rs.getString("password"), tipoPersona, rs.getString("unit"), rs.getInt("idUser"));
						}
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

		return userUniversity;
	}

	@Override
	public Person readByDNI(int tipoPersona, String dni) {
		// Declaracion de variables
		logger.info("Entramos en el metodo readByDni del repository");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		Person userUniversity = null;

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("CALL readbyDNI(?,?);");
		logger.debug("Peticion a BBDD: " + sql.toString());
		if (conn != null) {
			try {
				logger.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setInt(1, tipoPersona);
				pst.setString(2, dni);
				try {
					logger.info("Se ejecuta la peticion");
					ResultSet rs = pst.executeQuery();
					while (rs.next()) {
						// Segun el tipo de persona nos devolvera un estudiante, un profesor o un
						// personal de administracion
						if (tipoPersona == 1) {
							userUniversity = new Student(rs.getInt("id"), rs.getString("name"), dni,
									rs.getString("surname"), rs.getString("mail"), rs.getString("username"),
									rs.getString("password"), tipoPersona, rs.getString("faculty"),
									rs.getInt("idUser"));
						} else if (tipoPersona == 2) {
							userUniversity = new Professor(rs.getInt("id"), rs.getString("name"), rs.getString("dni"),
									rs.getString("surname"), rs.getString("mail"), rs.getString("username"),
									rs.getString("password"), tipoPersona, rs.getString("office"), rs.getInt("idUser"));
						} else if (tipoPersona == 3) {

							userUniversity = new Pas(rs.getInt("id"), rs.getString("name"), rs.getString("dni"),
									rs.getString("surname"), rs.getString("mail"), rs.getString("username"),
									rs.getString("password"), tipoPersona, rs.getString("unit"), rs.getInt("idUser"));
						}
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

		return userUniversity;
	}

	@Override
	public Person uploadByUsername(int tipoPersona, Person newPerson, String username) {
		// Declaracion de variables
		logger.info("Entramos en el metodo uploadByUsername del repository");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("CALL updatebyUsername(?,?,?,?,?,?,?,?,?)");
		logger.debug("Peticion a BBDD: " + sql.toString());
		if (conn != null) {
			try {
				logger.info("Se prepara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setInt(1, tipoPersona);
				pst.setString(2, username);
				pst.setString(3, newPerson.getName());
				pst.setString(4, newPerson.getSurname());
				pst.setString(5, newPerson.getMail());
				pst.setString(6, newPerson.getPassword());

				if (tipoPersona == 1) {
					pst.setString(7, ((Student) newPerson).getFaculty());
				} else {
					pst.setString(7, null);
				}

				if (tipoPersona == 2) {
					pst.setString(8, ((Professor) newPerson).getOffice());
				} else {
					pst.setString(8, null);
				}
				if (tipoPersona == 3) {
					pst.setString(9, ((Pas) newPerson).getUnit());
				} else {
					pst.setString(9, null);
				}
				try {
					logger.info("Se ejecuta la peticion");
					pst.executeUpdate();

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
		return newPerson;
	}

	@Override
	public Person uploadByDNI(int tipoPersona, Person newPerson, String dni) {
		// Declaracion de variables
		logger.info("Entramos en el metodo uploadByDni del repository");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("CALL updatebyDNI(?,?,?,?,?,?,?,?,?)");
		logger.debug("Peticion a BBDD: " + sql.toString());
		if (conn != null) {
			try {
				logger.info("Se prepara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setInt(1, tipoPersona);
				pst.setString(2, dni);
				pst.setString(3, newPerson.getName());
				pst.setString(4, newPerson.getSurname());
				pst.setString(5, newPerson.getMail());
				pst.setString(6, newPerson.getPassword());

				if (tipoPersona == 1) {
					pst.setString(7, ((Student) newPerson).getFaculty());
				} else {
					pst.setString(7, null);
				}

				if (tipoPersona == 2) {
					pst.setString(8, ((Professor) newPerson).getOffice());
				} else {
					pst.setString(8, null);
				}
				if (tipoPersona == 3) {
					pst.setString(9, ((Pas) newPerson).getUnit());
				} else {
					pst.setString(9, null);
				}
				try {
					logger.info("Se ejecuta la peticion");
					pst.executeUpdate();

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
		return newPerson;
	}

	@Override
	public boolean deleteByUsername(String username) {
		// Declaracion de variables
		logger.info("Entramos en el metodo deleteByUsername del repository");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		boolean deleteOK = false;

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM ");
		sql.append("useruniversity WHERE username = ?");
		logger.debug("Peticion a BBDD: " + sql.toString());
		if (conn != null) {
			try {
				logger.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setString(1, username);

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

	@Override
	public boolean deleteByDNI(String dni) {
		// Declaracion de variables
		logger.info("Entramos en el metodo deleteByDNI del repository");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		boolean deleteOK = false;

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM ");
		sql.append("useruniversity WHERE dni = ?");
		logger.debug("Peticion a BBDD: " + sql.toString());
		if (conn != null) {
			try {
				logger.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setString(1, dni);

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
