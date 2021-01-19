package edu.beca.es.eoi.aleoixaServicesImpl;

import edu.beca.es.eoi.aleoixaRepository.TranslateRepository;
import edu.beca.es.eoi.aleoixaRepositoryImpl.TranslateRepositoryJDCBImpl;
import edu.beca.es.eoi.aleoixaServices.TranslateService;

public class TranslateServiceImpl implements TranslateService {

	public static final TranslateRepository REPOSITORY = new TranslateRepositoryJDCBImpl();

	@Override
	public String readBySpanishWord(String englishWord) {
		return REPOSITORY.readBySpanishWord(englishWord);
	}

	@Override
	public String readByEnglishWord(String spanishWord) {
		return REPOSITORY.readByEnglishWord(spanishWord);
	}

}
