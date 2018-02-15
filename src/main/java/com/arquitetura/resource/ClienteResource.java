package com.arquitetura.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arquitetura.DTO.MessageDTO;
import com.arquitetura.model.Cliente;
import com.arquitetura.service.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
@CrossOrigin
public class ClienteResource {

	@Autowired
	private ClienteService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<MessageDTO> listarTodos() {
		List<Cliente> lista = service.findAll();
		return new ResponseEntity<MessageDTO>(new MessageDTO("Cliente Encontrado", true,lista ), HttpStatus.OK);
		
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<MessageDTO> buscarPorId(@PathVariable("id") Integer id) {

		Cliente client = service.findById(id);

		if (client == null) {
			return new ResponseEntity<MessageDTO>(new MessageDTO("Esse Cliente não existe", false, null),
					HttpStatus.OK);

		} else {
			return new ResponseEntity<MessageDTO>(new MessageDTO("Cliente Encontrado", true, client), HttpStatus.OK);

		}

	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<MessageDTO> salvar(@RequestBody Cliente cliente) {

		try {
			Cliente client = this.service.save(cliente);
			return new ResponseEntity<MessageDTO>(new MessageDTO("Cliente salvo com sucesso", true, client),
					HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<MessageDTO>(new MessageDTO("Erro ao tentar salvar cliente", false, null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<MessageDTO> atualizar(@PathVariable("id") Integer id, @RequestBody Cliente cliente) {

		try {
			Cliente cli = this.service.findById(id);

			if (cli == null) {
				return new ResponseEntity<MessageDTO>(new MessageDTO("Esse Cliente não existe", false, null),
						HttpStatus.OK);
			} else {
				Cliente clienteAlterado = this.service.update(cliente);
				return new ResponseEntity<MessageDTO>(
						new MessageDTO("Cliente Atualizado com sucesso", true, clienteAlterado), HttpStatus.OK);
			}

		} catch (Exception e) {
			return new ResponseEntity<MessageDTO>(new MessageDTO("Erro ao tentar atualizar cliente", false, null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<MessageDTO> deletar(@PathVariable("id") Integer id) {

		try {
			Cliente cli = this.service.findById(id);

			if (cli == null) {
				return new ResponseEntity<MessageDTO>(new MessageDTO("Esse Cliente não existe", false, null),
						HttpStatus.OK);
			} else {
				this.service.delete(cli);
				return new ResponseEntity<MessageDTO>(
						new MessageDTO("Cliente deletado com sucesso", true), HttpStatus.OK);
			}

		} catch (Exception e) {
			return new ResponseEntity<MessageDTO>(new MessageDTO("Erro ao tentar deletar cliente", false, null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	
}