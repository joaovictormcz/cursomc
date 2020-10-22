package com.nogueira.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nogueira.cursomc.domain.Cliente;
import com.nogueira.cursomc.repositories.ClienteRepository;
import com.nogueira.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	/*
	public Cliente find(Integer id) {		
	Optional<Cliente> obj = repo.findById(id);
		return obj.orElse(null);
	}
	*/
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

}
