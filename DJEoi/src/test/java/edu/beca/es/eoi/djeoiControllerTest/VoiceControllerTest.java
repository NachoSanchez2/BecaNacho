package edu.beca.es.eoi.djeoiControllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.djeoiController.VoiceController;

class VoiceControllerTest {

	@Test
	void testPrintInstruments() {
		int userOption = 5;
		VoiceController controller = new VoiceController();
		try {
			assertTrue(controller.selectInstrument(userOption));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testMakeRithm() {
		String value = "A";
		String rithmValue = "O  O O  O O O  O";
		VoiceController controller = new VoiceController();
		assertTrue(controller.makeRithm(value, rithmValue));
	}

	@Test
	void testMakeChords() {
		VoiceController controller = new VoiceController();
		String userComposition = " C A Q W E R T F G";
		String voice = controller.makeChords(userComposition);

		assertEquals("i[BOX_]C+A+Q+W+E+R+T+F+G", voice);
	}

	@Test
	void freeComposition() {
		VoiceController controller = new VoiceController();
		String voice = "C A Q W E R T F G";
		controller.freeComposition(voice);
	}

	@Test
	void translateKeyboardTest() {
		String userComposition = "Q W W E R  T Y U";
		VoiceController controller = new VoiceController();

		String translatedComposition = controller.translateKeyboard(userComposition);
		assertNotNull(translatedComposition);
		assertEquals("Cw Dw Dw Ew Fw  Gw Aw Bw", translatedComposition);
	}

}
