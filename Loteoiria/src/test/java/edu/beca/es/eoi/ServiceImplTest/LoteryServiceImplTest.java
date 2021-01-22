package edu.beca.es.eoi.ServiceImplTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.Service.LoteryService;
import edu.beca.es.eoi.serviceImpl.LoteryServiceImpl;

class LoteryServiceImplTest {

	@Test
	void testSimulateLotery() {
		LoteryService service = new LoteryServiceImpl();
		Map<Integer, Integer> simulatedLotery = service.simulateLotery();
		boolean loterySimulated = false;
		if (!simulatedLotery.isEmpty()) {
			loterySimulated = true;
		}
		assertTrue(loterySimulated);

	}

}
