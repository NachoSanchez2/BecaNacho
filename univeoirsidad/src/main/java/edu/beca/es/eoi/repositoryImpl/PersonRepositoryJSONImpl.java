package edu.beca.es.eoi.repositoryImpl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import edu.beca.es.eoi.entity.Pas;
import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.entity.Professor;
import edu.beca.es.eoi.entity.Student;

public class PersonRepositoryJSONImpl {

	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	private static int id = 0;
	private static List<Person> persons = new ArrayList<Person>();
	private static List<Student> students = new ArrayList<Student>();
	private static List<Professor> professors = new ArrayList<Professor>();
	private static List<Pas> pas = new ArrayList<Pas>();

	public boolean savePerson(Person e) {
		// ID Auto_increment
		id++;
		e.setId(id);

		// Declaration
		String line = null;
		boolean saveOK = false;
		persons.add(e);

		// Implementation
		try {
			// Print JSON archive
			FileWriter fw = new FileWriter("PersonsJSON.txt", false);
			fw.write(GSON.toJson(persons));
			fw.flush();
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		if (e.getTipoPersona() == 1) {
			// Print JSON archive
			((Student) e).setIdUser(e.getId());
			students.add(((Student) e));
			try {
				FileWriter fw = new FileWriter("StudentsJSON.txt", false);
				fw.write(GSON.toJson(students));
				fw.flush();
				fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} else if (e.getTipoPersona() == 2) {
			// Print JSON archive
			((Professor) e).setIdUser(e.getId());
			professors.add(((Professor) e));
			try {
				FileWriter fw = new FileWriter("ProfessorsJSON.txt", false);
				fw.write(GSON.toJson(professors));
				fw.flush();
				fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} else if (e.getTipoPersona() == 3) {
			((Pas) e).setIdUser(e.getId());
			pas.add(((Pas) e));
			try {
				FileWriter fw = new FileWriter("PasJSON.txt", false);
				fw.write(GSON.toJson(pas));
				fw.flush();
				fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		// Verification
		try {
			FileReader fr = new FileReader("PersonsJSON.txt");
			BufferedReader br = new BufferedReader(fr);
			do {
				line = br.readLine();
				if (line != null) {
					saveOK = true;
				}
			} while (line != null);
			br.close();
			fr.close();
		} catch (FileNotFoundException em) {
			em.printStackTrace();
		} catch (IOException el) {
			el.printStackTrace();
		}

		return saveOK;
	}

	public List<Person> readAll() {
		List<Person> personsAux = new ArrayList<Person>();
		String line = null;
		String json = "";

		try {
			FileReader fr = new FileReader("PersonsJSON.txt");
			BufferedReader br = new BufferedReader(fr);
			do {
				line = br.readLine();
				if (line != null) {
					json += line + "\n";
				}
			} while (line != null);
			br.close();
			fr.close();
		} catch (FileNotFoundException em) {
			em.printStackTrace();
		} catch (IOException el) {
			el.printStackTrace();
		}
		personsAux = GSON.fromJson(json, new TypeToken<List<Person>>() {
		}.getType());
		return personsAux;
	}

	public Person readByUsername(String username) {
		// Declaration
		List<Person> personsAux = new ArrayList<Person>();
		String line = null;
		String json = "";
		Person person = null;

		// Implementation
		try {
			FileReader fr = new FileReader("PersonsJSON.txt");
			BufferedReader br = new BufferedReader(fr);
			do {
				line = br.readLine();
				if (line != null) {
					json += line + "\n";
				}
			} while (line != null);
			br.close();
			fr.close();
		} catch (FileNotFoundException em) {
			em.printStackTrace();
		} catch (IOException el) {
			el.printStackTrace();
		}
		// Return
		personsAux = GSON.fromJson(json, new TypeToken<List<Person>>() {
		}.getType());
		for (Person personAUX : personsAux) {
			if (personAUX.getUsername().equalsIgnoreCase(username)) {
				person = personAUX;
			}
		}
		return person;
	}

	public Person readByDNI(String dni) {
		// Declaration
		List<Person> personsAux = new ArrayList<Person>();
		String line = null;
		String json = "";
		Person person = null;

		// Implementation
		try {
			FileReader fr = new FileReader("PersonsJSON.txt");
			BufferedReader br = new BufferedReader(fr);
			do {
				line = br.readLine();
				if (line != null) {
					json += line + "\n";
				}
			} while (line != null);
			br.close();
			fr.close();
		} catch (FileNotFoundException em) {
			em.printStackTrace();
		} catch (IOException el) {
			el.printStackTrace();
		}

		// Return
		personsAux = GSON.fromJson(json, new TypeToken<List<Person>>() {
		}.getType());
		for (Person personAUX : personsAux) {
			if (personAUX.getDni().equalsIgnoreCase(dni)) {
				person = personAUX;
			}
		}
		return person;
	}

	public boolean uploadByUsername(Person newPerson, String username) {
		// Declaration
		String line = null;
		String personsJson = "";
		Person person = null;

		// Recover all information
		try {
			FileReader fr = new FileReader("PersonsJSON.txt");
			BufferedReader br = new BufferedReader(fr);
			do {
				line = br.readLine();
				if (line != null) {
					personsJson = personsJson + line + "\n";
				}
			} while (line != null);
			br.close();
			fr.close();
		} catch (FileNotFoundException em) {
			em.printStackTrace();
		} catch (IOException el) {
			el.printStackTrace();
		}
		if (newPerson.getTipoPersona() == 1) {
			// Declarated JSON
			List<Student> studentAUX = GSON.fromJson(personsJson, new TypeToken<List<Student>>() {
			}.getType());

			// Make modification if username exist and agree
			for (Person personAUX : studentAUX) {
				persons.add(personAUX);
				if (personAUX.getUsername().equalsIgnoreCase(username)) {
					// Save values of personAUX on person;
					person = personAUX;

					// Delete old values
					persons.remove(personAUX);

					if (person != null) {
						person.setName(newPerson.getName());
						person.setSurname(newPerson.getSurname());
						person.setMail(newPerson.getMail());
						person.setPassword(newPerson.getPassword());
						// Cast personAUX to Student and set new Faculty with Cast newPerson
						((Student) person).setFaculty(((Student) newPerson).getFaculty());

						// Add new person to List
						persons.add(person);
						students.add((Student) person);
					}
				}
			}
			// Print JSON archive
			try {
				FileWriter fw = new FileWriter("StudentsJSON.txt", false);
				fw.write(GSON.toJson(students));
				fw.flush();
				fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} else if (newPerson.getTipoPersona() == 2) {
			// Declarated JSON
			List<Professor> professorsAUX = GSON.fromJson(personsJson, new TypeToken<List<Professor>>() {
			}.getType());

			// Make modification if username exist and agree
			for (Person personAUX : professorsAUX) {
				persons.add(personAUX);
				if (personAUX.getUsername().equalsIgnoreCase(username)) {
					// Save values of personAUX on person;
					person = personAUX;

					// Delete old values
					persons.remove(personAUX);

					if (person != null) {
						person.setName(newPerson.getName());
						person.setSurname(newPerson.getSurname());
						person.setMail(newPerson.getMail());
						person.setPassword(newPerson.getPassword());
						// Cast personAUX to Student and set new Faculty with Cast newPerson
						((Professor) person).setOffice(((Professor) newPerson).getOffice());

						// Add new person to List
						persons.add(person);
						professors.add((Professor) person);
					}
				}
			}
			// Print JSON archive
			try {
				FileWriter fw = new FileWriter("ProfessorsJSON.txt", false);
				fw.write(GSON.toJson(professors));
				fw.flush();
				fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} else if (newPerson.getTipoPersona() == 3) {
			// Declarated JSON
			List<Pas> pasAUX = GSON.fromJson(personsJson, new TypeToken<List<Pas>>() {
			}.getType());

			// Make modification if username exist and agree
			for (Person personAUX : pasAUX) {
				persons.add(personAUX);
				if (personAUX.getUsername().equalsIgnoreCase(username)) {
					// Save values of personAUX on person;
					person = personAUX;

					// Delete old values
					persons.remove(personAUX);

					if (person != null) {
						person.setName(newPerson.getName());
						person.setSurname(newPerson.getSurname());
						person.setMail(newPerson.getMail());
						person.setPassword(newPerson.getPassword());
						// Cast personAUX to Student and set new Faculty with Cast newPerson
						((Pas) person).setUnit(((Pas) newPerson).getUnit());

						// Add new person to List
						persons.add(person);
						pas.add((Pas) person);
					}
				}
			}
			// Print JSON archive
			try {
				FileWriter fw = new FileWriter("PasJSON.txt", false);
				fw.write(GSON.toJson(pas));
				fw.flush();
				fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		try {
			// Print JSON archive
			FileWriter fw = new FileWriter("PersonsJSON.txt", false);
			fw.write(GSON.toJson(persons));
			fw.flush();
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		if (person != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean uploadByDNI(Person newPerson, String dni) {
		// Declaration
		String line = null;
		String personsJson = "";
		Person person = null;

		// Recover all information
		try {
			FileReader fr = new FileReader("PersonsJSON.txt");
			BufferedReader br = new BufferedReader(fr);
			do {
				line = br.readLine();
				if (line != null) {
					personsJson = personsJson + line + "\n";
				}
			} while (line != null);
			br.close();
			fr.close();
		} catch (FileNotFoundException em) {
			em.printStackTrace();
		} catch (IOException el) {
			el.printStackTrace();
		}
		if (newPerson.getTipoPersona() == 1) {
			// Declarated JSON
			List<Student> studentAUX = GSON.fromJson(personsJson, new TypeToken<List<Student>>() {
			}.getType());

			// Make modification if username exist and agree
			for (Person personAUX : studentAUX) {
				persons.add(personAUX);
				if (personAUX.getDni().equalsIgnoreCase(dni)) {
					// Save values of personAUX on person;
					person = personAUX;

					// Delete old values
					persons.remove(personAUX);

					if (person != null) {
						person.setName(newPerson.getName());
						person.setSurname(newPerson.getSurname());
						person.setMail(newPerson.getMail());
						person.setPassword(newPerson.getPassword());
						// Cast personAUX to Student and set new Faculty with Cast newPerson
						((Student) person).setFaculty(((Student) newPerson).getFaculty());

						// Add new person to List
						persons.add(person);
						students.add((Student) person);
					}
				}
			}
			// Print JSON archive
			try {
				FileWriter fw = new FileWriter("StudentsJSON.txt", false);
				fw.write(GSON.toJson(students));
				fw.flush();
				fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} else if (newPerson.getTipoPersona() == 2) {
			// Declarated JSON
			List<Professor> professorsAUX = GSON.fromJson(personsJson, new TypeToken<List<Professor>>() {
			}.getType());

			// Make modification if username exist and agree
			for (Person personAUX : professorsAUX) {
				persons.add(personAUX);
				if (personAUX.getDni().equalsIgnoreCase(dni)) {
					// Save values of personAUX on person;
					person = personAUX;

					// Delete old values
					persons.remove(personAUX);

					if (person != null) {
						person.setName(newPerson.getName());
						person.setSurname(newPerson.getSurname());
						person.setMail(newPerson.getMail());
						person.setPassword(newPerson.getPassword());
						// Cast personAUX to Student and set new Faculty with Cast newPerson
						((Professor) person).setOffice(((Professor) newPerson).getOffice());

						// Add new person to List
						persons.add(person);
						professors.add((Professor) person);
					}
				}
			}
			// Print JSON archive
			try {
				FileWriter fw = new FileWriter("ProfessorsJSON.txt", false);
				fw.write(GSON.toJson(professors));
				fw.flush();
				fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} else if (newPerson.getTipoPersona() == 3) {
			// Declarated JSON
			List<Pas> pasAUX = GSON.fromJson(personsJson, new TypeToken<List<Pas>>() {
			}.getType());

			// Make modification if username exist and agree
			for (Person personAUX : pasAUX) {
				persons.add(personAUX);
				if (personAUX.getDni().equalsIgnoreCase(dni)) {
					// Save values of personAUX on person;
					person = personAUX;

					// Delete old values
					persons.remove(personAUX);

					if (person != null) {
						person.setName(newPerson.getName());
						person.setSurname(newPerson.getSurname());
						person.setMail(newPerson.getMail());
						person.setPassword(newPerson.getPassword());
						// Cast personAUX to Student and set new Faculty with Cast newPerson
						((Pas) person).setUnit(((Pas) newPerson).getUnit());

						// Add new person to List
						persons.add(person);
						pas.add((Pas) person);
					}
				}
			}
			// Print JSON archive
			try {
				FileWriter fw = new FileWriter("PasJSON.txt", false);
				fw.write(GSON.toJson(pas));
				fw.flush();
				fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		try {
			// Print JSON archive
			FileWriter fw = new FileWriter("PersonsJSON.txt", false);
			fw.write(GSON.toJson(persons));
			fw.flush();
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		if (person != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteByUsername(String username) {
		// Declaration
		String line = null;
		String personsJson = "";
		boolean deleteOK = false;

		// Recover all information
		try {
			FileReader fr = new FileReader("PersonsJSON.txt");
			BufferedReader br = new BufferedReader(fr);
			do {
				line = br.readLine();
				if (line != null) {
					personsJson = personsJson + line + "\n";
				}
			} while (line != null);
			br.close();
			fr.close();
		} catch (FileNotFoundException em) {
			em.printStackTrace();
		} catch (IOException el) {
			el.printStackTrace();
		}

		// Recover for students

		try {
			FileReader fr = new FileReader("StudentsJSON.txt");
			BufferedReader br = new BufferedReader(fr);
			do {
				line = br.readLine();
				if (line != null) {
					personsJson = personsJson + line + "\n";
				}
			} while (line != null);
			br.close();
			fr.close();
		} catch (FileNotFoundException em) {
			em.printStackTrace();
		} catch (IOException el) {
			el.printStackTrace();
		}

		// Recover from professors
		try {
			FileReader fr = new FileReader("ProfessorsJSON.txt");
			BufferedReader br = new BufferedReader(fr);
			do {
				line = br.readLine();
				if (line != null) {
					personsJson = personsJson + line + "\n";
				}
			} while (line != null);
			br.close();
			fr.close();
		} catch (FileNotFoundException em) {
			em.printStackTrace();
		} catch (IOException el) {
			el.printStackTrace();
		}

		// Recover from pas
		try {
			FileReader fr = new FileReader("PasJSON.txt");
			BufferedReader br = new BufferedReader(fr);
			do {
				line = br.readLine();
				if (line != null) {
					personsJson = personsJson + line + "\n";
				}
			} while (line != null);
			br.close();
			fr.close();
		} catch (FileNotFoundException em) {
			em.printStackTrace();
		} catch (IOException el) {
			el.printStackTrace();
		}

		// Implementation for persons
		List<Person> personsAUX = GSON.fromJson(personsJson, new TypeToken<List<Person>>() {
		}.getType());

		for (Person personAUX : personsAUX) {
			persons.add(personAUX);
		}
		for (Person personAUX : persons) {
			if (personAUX.getUsername().equalsIgnoreCase(username)) {
				persons.remove(personAUX);
			}
		}

		// Implementation for students
		List<Student> studentsAUX = GSON.fromJson(personsJson, new TypeToken<List<Student>>() {
		}.getType());

		for (Person personAUX : studentsAUX) {
			students.add((Student) personAUX);
		}
		for (Person personAUX : students) {
			if (personAUX.getUsername().equalsIgnoreCase(username)) {
				students.remove(personAUX);
			}
		}
		// Implements for professors
		List<Professor> professorsAUX = GSON.fromJson(personsJson, new TypeToken<List<Professor>>() {
		}.getType());

		for (Person personAUX : professorsAUX) {
			professors.add((Professor) personAUX);
		}
		for (Person personAUX : professors) {
			if (personAUX.getUsername().equalsIgnoreCase(username)) {
				professors.remove(personAUX);
			}
		}

		// Implements for pas
		List<Pas> pasAUX = GSON.fromJson(personsJson, new TypeToken<List<Pas>>() {
		}.getType());

		for (Person personAUX : pasAUX) {
			pas.add((Pas) personAUX);
		}
		for (Person personAUX : pas) {
			if (personAUX.getUsername().equalsIgnoreCase(username)) {
				pas.remove(personAUX);
			}
		}

		// RETURN

		try {
			// Print JSON archive
			FileWriter fw = new FileWriter("PersonsJSON.txt", false);
			fw.write(GSON.toJson(persons));
			fw.flush();
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		try {
			// Print JSON archive
			FileWriter fw = new FileWriter("StudentsJSON.txt", false);
			fw.write(GSON.toJson(students));
			fw.flush();
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		// Print JSON archive
		try {
			FileWriter fw = new FileWriter("ProfessorsJSON.txt", false);
			fw.write(GSON.toJson(professors));
			fw.flush();
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		// Print JSON archive
		try {
			FileWriter fw = new FileWriter("PasJSON.txt", false);
			fw.write(GSON.toJson(pas));
			fw.flush();
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		// VALIDATION
		try {
			FileReader fr = new FileReader("PersonsJSON.txt");
			BufferedReader br = new BufferedReader(fr);
			do {
				line = br.readLine();
				if (line != null) {
					personsJson = personsJson + line + "\n";
				}
			} while (line != null);
			br.close();
			fr.close();
		} catch (FileNotFoundException em) {
			em.printStackTrace();
		} catch (IOException el) {
			el.printStackTrace();
		}

		List<Person> validationPersons = GSON.fromJson(personsJson, new TypeToken<List<Person>>() {
		}.getType());

		for (Person personAUX : validationPersons) {
			persons.add(personAUX);
		}
		for (Person personAUX : persons) {
			deleteOK = persons.contains(personAUX);
		}

		return deleteOK;
	}

	public boolean deleteByDNI(String sf) {
		// TODO Auto-generated method stub
		return false;
	}

}
