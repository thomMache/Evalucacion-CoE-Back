package com.thommache.sprintboot.app.coe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thommache.sprintboot.app.coe.entity.Cliente;
import com.thommache.sprintboot.app.coe.service.ClientService;



@Controller
@RequestMapping("/client")
@CrossOrigin({"http://localhost:4200"})
public class ClientController {
	
	

	@Autowired
	private ClientService clientservice;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> getClientes(){
		return new ResponseEntity<>(clientservice.getClientes(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getClienteId(@PathVariable("id") Integer id){
		return new ResponseEntity<Cliente>(clientservice.getClientById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente){
		return new ResponseEntity<Cliente>(clientservice.createCliente(cliente),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable("id") Integer id, @RequestBody Cliente cliente){
		return new ResponseEntity<Cliente>(clientservice.updateCliente(id,cliente),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCliente(@PathVariable("id") Integer id){
		clientservice.deleteCliente(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
