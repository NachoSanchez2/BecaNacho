package edu.beca.es.eoi.controller;

import edu.beca.es.eoi.service.OwnerService;
import edu.beca.es.eoi.serviceImpl.OwnerServiceImpl;
import lombok.extern.log4j.Log4j;

@Log4j
public class OwnerController {

	private static final OwnerService SERVICE = new OwnerServiceImpl();

	public boolean saveOwner(String name, String phone, int idPet) throws Exception {
		log.info("Entra en el metodo saveOwner conectando con el servidor");
		boolean saveOK = SERVICE.saveOwner(name, phone, idPet);
		if (saveOK) {
			return saveOK;
		} else {
			throw new Exception("Ha habido un error al intentar guardar al dueño");
		}
	}
}
