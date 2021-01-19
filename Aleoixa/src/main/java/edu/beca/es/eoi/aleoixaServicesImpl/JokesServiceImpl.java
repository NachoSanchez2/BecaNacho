package edu.beca.es.eoi.aleoixaServicesImpl;

import edu.beca.es.eoi.aleoixaRepository.JokesRepository;
import edu.beca.es.eoi.aleoixaRepositoryImpl.JokesRepositoryJDBCImpl;
import edu.beca.es.eoi.aleoixaServices.JokesService;

public class JokesServiceImpl implements JokesService {
	public static final JokesRepository REPOSITORY = new JokesRepositoryJDBCImpl();

	@Override
	public String readById(Integer id) {
		return REPOSITORY.readById(id);
	}

}
