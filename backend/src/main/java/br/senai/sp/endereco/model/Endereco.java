package br.senai.sp.endereco.model;

public class Endereco {

	private int idEndereco;
	private String uf;
	private String numero;
	private String cep;
	private String logradouro;
	private String cidade;
	private String bairro;
	private String complemento;

	public Endereco() {
	}

	public Endereco(int idEndereco, String uf, String numero, String cep, String logradouro, String cidade,
			String bairro, String complemento) {

		this.idEndereco = idEndereco;
		this.uf = uf;
		this.numero = numero;
		this.cep = cep;
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.bairro = bairro;
		this.complemento = complemento;
	}

	public int getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
