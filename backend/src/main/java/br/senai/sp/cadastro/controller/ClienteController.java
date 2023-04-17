package br.senai.sp.cadastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senai.sp.cadastro.dao.ClienteDao;
import br.senai.sp.cadastro.model.Cliente;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteDao dao;
	
	@GetMapping
	public List<Cliente> buscaTodos() {
		return dao.listarTodos();	
	}
	
	@GetMapping("/{idCliente}")
	public Cliente buscaPorId(@PathVariable int idCliente) {
		return dao.pegarPorId(idCliente);
	}
	
	@PostMapping
	public Cliente inserir(@RequestBody Cliente cliente) {
		dao.novo(cliente);
		return cliente;
	}
	
	@PutMapping("/{idCliente}")
	public Cliente alterar(@RequestBody Cliente cliente, @PathVariable int idCliente) {
		dao.editar(cliente, idCliente);
				
		return cliente;
	}

	@DeleteMapping("/{idCliente}")
	public int excluir(@PathVariable int idCliente) {
		
		dao.deletar(idCliente);
		
		return idCliente;
	}
	
}

