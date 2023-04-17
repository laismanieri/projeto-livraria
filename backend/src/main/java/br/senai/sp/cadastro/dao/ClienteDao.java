package br.senai.sp.cadastro.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.senai.sp.cadastro.model.Cliente;

@Repository
public class ClienteDao {
	
    @Autowired
    JdbcTemplate  jdbcTemplate;

	public List<Cliente> listarTodos() {
	    String sql = "SELECT idCliente, nome, cpf, email, telefone, dataNascimento, sexo";
	     
	    List<Cliente> lista = jdbcTemplate.query(sql,
	                BeanPropertyRowMapper.newInstance(Cliente.class));

		return lista;
	}
	
	
	public Cliente pegarPorId(int idCliente) {
		
	    String sql = "SELECT idCliente, nome, cpf, email, telefone, dataNascimento, sexo, profissao FROM cliente WHERE idCliente=?";
	    
		Object[] params = {idCliente};
	    
		Cliente produto = jdbcTemplate.queryForObject(sql,
	        BeanPropertyRowMapper.newInstance(Cliente.class), params);
	    
		return produto;
	}
	
	public Integer novo(Cliente cliente) {
		
        String sql = "INSERT INTO cliente (nome, cpf, email, telefone, dataNascimento, sexo) "
        		+ "VALUES (?, ?, ?, ?, ?, ?)";
        int result = jdbcTemplate.update(sql, 
        		cliente.getNome(),
        		cliente.getCpf(),
        		cliente.getEmail(),
         	    cliente.getTelefone(),
        	    cliente.getDataNascimento(),
        	    cliente.getSexo()
        		);
		
		return result;
	}
	
	public int editar(Cliente cliente, int idCliente) {
		String sql = "UPDATE cliente SET nome=?, cpf=?, email=?, telefone=?, dataNascimento=?, sexo=? WHERE idCliente=?";
		
	    Object[] params = {
        		cliente.getNome(),
        		cliente.getCpf(),
        		cliente.getEmail(),
        	    cliente.getTelefone(),
        	    cliente.getDataNascimento(),
        	    cliente.getSexo(),
        	    idCliente};
	    
	    int result = jdbcTemplate.update(sql, params);
	     
		return result;
	}
	
	public int deletar(int idCliente) {
		
		String sql = "DELETE FROM cliente WHERE idCliente=?";
		
		Object[] params = {idCliente};
		
		int result = jdbcTemplate.update(sql, params);
		
		return result;
	}
	
	
}