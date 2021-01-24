package edu.beca.es.eoi.djeoiServiceImpl;

import org.jfugue.pattern.Pattern;

import edu.beca.es.eoi.djeoiEntity.Voice;
import edu.beca.es.eoi.djeoiService.VoiceService;

public class VoiceServiceImpl implements VoiceService {

	@Override
	public Voice makeVoice(String voiceName, String voiceValue) {
		Pattern value = new Pattern(voiceValue);
		Voice voice = new Voice(value, voiceName);
		return voice;
	}

}
