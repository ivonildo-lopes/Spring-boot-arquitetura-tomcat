package com.arquitetura.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arquitetura.model.Cliente;
import com.arquitetura.service.ClienteService;

@RestController
@RequestMapping(value="/cliente")
public class ClienteResource {

	@Autowired
	private ClienteService service;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ResponseEntity<List<Cliente>> listarTodos(){
		return new ResponseEntity<List<Cliente>>(service.findAll(),HttpStatus.OK);
	}
	

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Cliente> buscarPorId(@PathVariable("id") Integer id){
		return new ResponseEntity<Cliente>(service.findById(id),HttpStatus.OK);
	}
}
