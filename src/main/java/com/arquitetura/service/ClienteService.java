package com.arquitetura.service;

import java.util.List;

import com.arquitetura.model.Cliente;


public interface ClienteService {

	public List<Cliente> findAll();
	
	public Cliente findById(Integer id);
	
	
}
