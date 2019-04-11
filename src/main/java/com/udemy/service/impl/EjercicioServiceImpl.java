package com.udemy.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.service.EjercicioService;

@Service("ejercicioService")
public class EjercicioServiceImpl implements EjercicioService{

	private static final Log LOG = LogFactory.getLog(EjercicioServiceImpl.class);
	
	@Override
	public String obtenerMensaje() {
		String mensaje = "MENSAJE DESDE EJERCICIO SERVICE";
		LOG.info(mensaje);
		return mensaje;
	}

}
