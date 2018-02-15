package com.arquitetura.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.arquitetura.model.Cliente;
import com.arquitetura.repository.ClienteDAO;
import com.arquitetura.service.ClienteService;


@Repository
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteDAO repository;

	@Override
	public List<Cliente> findAll() {
		return (List<Cliente>) this.repository.findAll();
	}

	@Override
	public Cliente findById(Integer id) {
		return this.repository.findOne(id);
	}

	@Override
	public Cliente save(Cliente cliente) {
		return this.repository.save(cliente);
	}

	@Override
	public Cliente update(Cliente cliente) {
		return this.repository.saveAndFlush(cliente);
	}

	@Override
	public void delete(Cliente cli) {
		this.repository.delete(cli);
	}
	
	

}