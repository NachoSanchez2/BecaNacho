package edu.beca.es.eoi.aleoixaControllersTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.aleoixaControllers.TranslateController;

class TranslatedControllerTest {

	@Test
	void testTranslateWordToSpanish() {

		// PreparedTest
		String englishWord = "cat";
		String translatedWord = null;
		TranslateController controller = new TranslateController();

		// Implementation
		try {
			translatedWord = controller.translateWord(englishWord);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Asserts
		assertNotNull(translatedWord);
		assertEquals("gato", translatedWord);
	}

	@Test
	void testTranslateWordToEnglish() {

		// PreparedTest
		String englishWord = "perro";
		String translatedWord = null;
		TranslateController controller = new TranslateController();

		// Implementation
		try {
			translatedWord = controller.translateWord(englishWord);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Asserts
		assertNotNull(translatedWord);
		assertEquals("dogg", translatedWord);
	}

}
