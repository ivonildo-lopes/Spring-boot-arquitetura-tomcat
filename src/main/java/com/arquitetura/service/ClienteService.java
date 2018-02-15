package com.arquitetura.service;

import java.util.List;

import com.arquitetura.model.Cliente;


public interface ClienteService {

	public List<Cliente> findAll();
	
	public Cliente findById(Integer id);
	
	public Cliente save(Cliente cliente);

	public Cliente update(Cliente cliente);

	public void delete(Cliente cli);
	
	
}