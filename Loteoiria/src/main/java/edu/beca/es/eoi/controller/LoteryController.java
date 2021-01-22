package edu.beca.es.eoi.controller;

import java.util.Map;

import edu.beca.es.eoi.Service.LoteryService;
import edu.beca.es.eoi.serviceImpl.LoteryServiceImpl;

public class LoteryController {
	public static final LoteryService SERVICE = new LoteryServiceImpl();

	public Map<Integer, Integer> simulateLotery() {

		Map<Integer, Integer> simulatedLotery = SERVICE.simulateLotery();
		return simulatedLotery;

	}
}
