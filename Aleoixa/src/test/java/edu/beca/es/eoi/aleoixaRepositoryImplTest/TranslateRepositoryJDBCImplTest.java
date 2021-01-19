package edu.beca.es.eoi.aleoixaRepositoryImplTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.aleoixaRepository.TranslateRepository;
import edu.beca.es.eoi.aleoixaRepositoryImpl.TranslateRepositoryJDCBImpl;

class TranslateRepositoryJDBCImplTest {

	@Test
	void testReadBySpanishWord() {
		// PreparedTest
		String spanishWord = "cat";
		TranslateRepository repository = new TranslateRepositoryJDCBImpl();

		// Implementation
		String translatedWord = repository.readBySpanishWord(spanishWord);

		// Asserts
		assertNotNull(translatedWord);
		assertEquals("gato", translatedWord);
	}

	@Test
	void testReadByEnglishWord() {
		// PreparedTest
		String englishWord = "gato";
		TranslateRepository repository = new TranslateRepositoryJDCBImpl();

		// Implementation
		String translatedWord = repository.readByEnglishWord(englishWord);

		// Asserts
		assertNotNull(translatedWord);
		assertEquals("cat", translatedWord);
	}

}
