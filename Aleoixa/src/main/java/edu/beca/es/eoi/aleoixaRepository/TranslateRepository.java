package edu.beca.es.eoi.aleoixaRepository;

public interface TranslateRepository {
	String readBySpanishWord(String word);

	String readByEnglishWord(String word);
}
