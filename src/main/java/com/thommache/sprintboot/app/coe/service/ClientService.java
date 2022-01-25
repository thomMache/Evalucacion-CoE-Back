package com.thommache.sprintboot.app.coe.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.thommache.sprintboot.app.coe.entity.Cliente;
import com.thommache.sprintboot.app.coe.repository.ClientRepository;






@Service
public class ClientService {
	
	private static final Logger log = LoggerFactory.getLogger(ClientService.class);
	
	@Autowired
	private ClientRepository clientRepository;

	public List<Cliente> getClientes() {
		
		return clientRepository.findAll();
	}
	
	
	@CacheEvict("producto")
	public void deleteCliente(Integer id) {
		Cliente cliente = getClientById(id);
		clientRepository.delete(cliente);
	} 
	
	
	@Cacheable("cliente")
	public Cliente getClientById(Integer id) {
		log.info("Getting client by is {}" , id);
		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		System.err.println("idddddddd "+ id);
		 return clientRepository.findById(id).orElseThrow(() -> 
		 new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("id %s not found", id)));
	}

	
	public Cliente createCliente(Cliente cliente) {
		return clientRepository.save(cliente);
	}

	public Cliente updateCliente(Integer id, Cliente cliente) {
		Optional<Cliente> result = clientRepository.findById(id);
		if (result.isPresent()) {
			return clientRepository.save(cliente);
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Cliente id %d doesn`t exists", id));
		}
	}
	
}
