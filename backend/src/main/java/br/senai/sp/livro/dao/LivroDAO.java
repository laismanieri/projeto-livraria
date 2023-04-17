package br.senai.sp.livro.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.senai.sp.livro.model.Livro;

@Repository
public class LivroDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Livro> listarTodos() {
		String sql = "SELECT ANODEPUBLICACAO, PRECO, NOME, AUTOR, GENERO, EDITORA, QTDESTOQUE, DESCRICAO, IMAGEM, QTDPAGINA, OFERTA, DESTAQUE, PRECOOFERTA  "
				+ "FROM LIVRO";
		List<Livro> lista = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Livro.class));
		return lista;
	}

	public Livro PegarPorId(int idLivro) {

		String sql = "SELECT ANODEPUBLICACAO, PRECO, NOME, AUTOR, GENERO, EDITORA, QTDESTOQUE, DESCRICAO, IMAGEM, QTDPAGINA, OFERTA, DESTAQUE, PRECOOFERTA  "
				+ "FROM LIVRO "
				+ "WHERE IDLIVRO = ?";
		Object[] params = { idLivro };
		Livro a = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Livro.class), params);
		return a;

	}
	
	
	public List<Livro> listarOferta() {
		String sql = "SELECT ANODEPUBLICACAO, PRECO, NOME, AUTOR, GENERO, EDITORA, QTDESTOQUE, DESCRICAO, IMAGEM, QTDPAGINA, OFERTA, DESTAQUE, PRECOOFERTA  "
				+ "FROM LIVRO"
				+ "WHERE OFERTA = 1";
		List<Livro> lista = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Livro.class));
		return lista;
	}
	
	public List<Livro> listarDestaque() {
		String sql = "SELECT ANODEPUBLICACAO, PRECO, NOME, AUTOR, GENERO, EDITORA, QTDESTOQUE, DESCRICAO, IMAGEM, QTDPAGINA, OFERTA, DESTAQUE, PRECOOFERTA  "
				+ "FROM LIVRO"
				+ "WHERE destaque = 1";
		List<Livro> lista = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Livro.class));
		return lista;
	}	
	
	public Livro[] buscarPorValor(String valor) {
	    String sql = "SELECT ANODEPUBLICACAO, NOME, AUTOR, GENERO, EDITORA "
	            + "FROM LIVRO "
	            + "WHERE ANODEPUBLICACAO like ? "
	            + "OR NOME like ? "
	            + "OR AUTOR like ? "
	            + "OR GENERO like ? "
	            + "OR EDITORA like ?";

	    List<Livro> livros = jdbcTemplate.query(sql, ps -> {
	        ps.setString(1, "%" + valor + "%");
	        ps.setString(2, "%" + valor + "%");
	        ps.setString(3, "%" + valor + "%");
	        ps.setString(4, "%" + valor + "%");
	        ps.setString(5, "%" + valor + "%");
	    }, BeanPropertyRowMapper.newInstance(Livro.class));

	    return livros.toArray(new Livro[0]);
	}


	public int Novo(Livro a) {

		String sql = "INSERT INTO LIVRO (ANODEPUBLICACAO, PRECO, NOME, AUTOR, GENERO, EDITORA, QTDESTOQUE, DESCRICAO, IMAGEM, QTDPAGINA, OFERTA, DESTAQUE, PRECOOFERTA ) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int result = jdbcTemplate.update(sql, a.getAnoDePublicacao(), a.getPreco(), a.getNome(), a.getAutor(), 
				a.getGenero(), a.getEditora(), a.getQtdEstoque(), a.getDescricao(), a.getImagem(), a.getQtdPagina(), a.isOferta(), a.isDestaque(), a.getPrecoOferta());

		return result;		
	}
	
	public void criarLista(List<Livro> livros) {
	    for (Livro livro : livros) {
	        Novo(livro);
	    }
	}


	public int Editar(Livro a, int idLivro) {
		String sql = "UPDATE LIVRO SET ANODEPUBLICACAO=?, PRECO=?, NOME=?, AUTOR=?, GENERO=?, EDITORA=?, QTDESTOQUE=?, DESCRICAO=?, IMAGEM=?, QTDPAGINA=?, OFERTA=?, DESTAQUE=?, PRECOOFERTA=?  "
				+ "WHERE IDLIVRO =?";
		Object[] params = { a.getAnoDePublicacao(), a.getPreco(), a.getNome(), a.getAutor(), a.getGenero(),
				a.getEditora(), a.getQtdEstoque(), a.getDescricao(), a.getImagem(), a.getQtdPagina(), a.isOferta(), a.isDestaque(), a.getPrecoOferta(), idLivro };
		int result = jdbcTemplate.update(sql, params);
		return result;
	}

	public int Deletar(int idLivro) {
		String sql = "DELETE FROM LIVRO "
				+ "WHERE IDLIVRO =?";
		Object[] params = { idLivro };
		int result = jdbcTemplate.update(sql, params);
		return result;
	}
}
