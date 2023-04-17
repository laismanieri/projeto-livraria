package br.senai.sp.livro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senai.sp.livro.dao.LivroDAO;
import br.senai.sp.livro.model.Livro;

@RestController
@RequestMapping("/livro")
public class LivroController {

	@Autowired
	LivroDAO dao;

	@GetMapping
	public List<Livro> listarTodos() {
		return dao.listarTodos();
	}
	
	@GetMapping("/{idLivro}")
	public Livro PegarPorId(@PathVariable int idLivro) {
		return dao.PegarPorId(idLivro);
	}

	@PostMapping
	public Livro inserir(@RequestBody Livro a) {
		dao.Novo(a);
		return a;
	}

	
	@PostMapping("/livros")
	public ResponseEntity<String> criarListaLivros(@RequestBody List<Livro> livros) {
	    dao.criarLista(livros);
	    return ResponseEntity.ok("Livros criados com sucesso");
	}

	
	@PutMapping("/{idLivro}")
	public Livro alterar(@RequestBody Livro livro, @PathVariable int idLivro) {
		dao.Editar(livro, idLivro);
		return livro;
	}

	@DeleteMapping("/{idLivro}")
	public int delete( @PathVariable int idLivro) {
		dao.Deletar(idLivro);
		return idLivro;
	}
}

