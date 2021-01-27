package edu.beca.es.eoi.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.beca.es.eoi.enums.TypePets;
import edu.beca.es.eoi.service.BirdService;
import edu.beca.es.eoi.service.CatService;
import edu.beca.es.eoi.service.DogService;
import edu.beca.es.eoi.service.OtherService;
import edu.beca.es.eoi.service.PetService;
import edu.beca.es.eoi.serviceImpl.BirdServiceImpl;
import edu.beca.es.eoi.serviceImpl.CatServiceImpl;
import edu.beca.es.eoi.serviceImpl.DogServiceImpl;
import edu.beca.es.eoi.serviceImpl.OtherServiceImpl;
import edu.beca.es.eoi.serviceImpl.PetServiceImpl;
import lombok.extern.log4j.Log4j;

@Log4j
public class PetServlet extends HttpServlet {
	// Configuration servlet constants
	private static final long serialVersionUID = 1L;
	ServletContext sc;
	RequestDispatcher rd;

	// Services constants
	private static final PetService PETSERVICE = new PetServiceImpl();
	private static final DogService DOGSERVICE = new DogServiceImpl();
	private static final CatService CATSERVICE = new CatServiceImpl();
	private static final BirdService BIRDSERVICE = new BirdServiceImpl();
	private static final OtherService OTHERSERVICE = new OtherServiceImpl();

	// Servlet constructor
	public PetServlet() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {

	}

	public int savePet(HttpServletRequest request, HttpServletResponse response)
			throws Exception, ServletException, IOException {

		log.info("Entra en el metodo savePet del Servlet");
		// Variables declaration and getAbout JSP
		int typePet = 0;
		String name = request.getParameter("name").toUpperCase();
		String location = request.getParameter("location");
		String description = request.getParameter("description");
		String photo = request.getParameter("photo");
		String listOption = request.getParameter("list");

		if (TypePets.DOG.getTypePet().equalsIgnoreCase(listOption)) {
			typePet = TypePets.DOG.getIntValue();
		} else if (TypePets.CAT.getTypePet().equalsIgnoreCase(listOption)) {
			typePet = TypePets.CAT.getIntValue();
		} else if (TypePets.BIRD.getTypePet().equalsIgnoreCase(listOption)) {
			typePet = TypePets.BIRD.getIntValue();
		} else {
			typePet = TypePets.OTHER.getIntValue();
		}

		int id = PETSERVICE.savePet(name, location, description, typePet, photo);
		if (id > 1) {
			return id;
		} else {
			throw new Exception("Ha habido un problema al dar de alta la mascota, por favor, vuelva a intentarlo");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
