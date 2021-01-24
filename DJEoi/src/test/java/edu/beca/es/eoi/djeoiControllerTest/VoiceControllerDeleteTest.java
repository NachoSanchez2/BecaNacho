package edu.beca.es.eoi.djeoiControllerTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.djeoiController.VoiceController;

class VoiceControllerDeleteTest {

	@Test
	void deleteVoice() {
		String voice1 = "V1";
		String voice2 = "V2";
		String voice9 = "V9";
		VoiceController controller = new VoiceController();
		controller.deleteVoice(voice1);
		controller.deleteVoice(voice2);
		controller.deleteVoice(voice9);
		assertNull(VoiceController.voices.get(voice1));
		assertNull(VoiceController.voices.get(voice2));
		assertNull(VoiceController.voices.get(voice9));
	}

}
