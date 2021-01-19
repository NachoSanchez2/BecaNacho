package edu.beca.es.eoi.aleoixaControllers;

import edu.beca.es.eoi.aleoixaServices.TranslateService;
import edu.beca.es.eoi.aleoixaServicesImpl.TranslateServiceImpl;

public class TranslateController {
	private static final TranslateService TRANSLATESERVICE = new TranslateServiceImpl();

	public String translateWord(String word) throws Exception {
		String translatedWord = null;

		String englishWord = TRANSLATESERVICE.readByEnglishWord(word);
		String spanishWord = TRANSLATESERVICE.readBySpanishWord(word);

		if (englishWord != null) {
			translatedWord = englishWord;
		} else if (spanishWord != null) {
			translatedWord = spanishWord;
		} else {
			throw new Exception("La palabra introducida no se encuentra disponible");
		}
		return translatedWord;
	}

}
