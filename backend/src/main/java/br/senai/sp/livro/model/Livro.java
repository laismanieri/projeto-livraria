package br.senai.sp.livro.model;

public class Livro {
	
	private int idLivro;
	private String anoDePublicacao;
	private float preco;
	private String nome;
	private String autor;
	private String genero;
	private String editora;
	private int qtdEstoque;
	private String descricao;
	private String imagem;
	private int qtdPagina;
    private boolean oferta; // indica se o livro está em oferta
    private boolean destaque; // indica se o livro é um destaque
    private float precoOferta; 
 
    
    

    // getters e setters
    
	
	public String getDescricao() {
		return descricao;
	}
	public boolean isOferta() {
		return oferta;
	}
	public void setOferta(boolean oferta) {
		this.oferta = oferta;
	}
	public boolean isDestaque() {
		return destaque;
	}
	public void setDestaque(boolean destaque) {
		this.destaque = destaque;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public int getIdLivro() {
		return idLivro;
	}
	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}
	public String getAnoDePublicacao() {
		return anoDePublicacao;
	}
	public void setAnoDePublicacao(String anoDePublicacao) {
		this.anoDePublicacao = anoDePublicacao;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public int getQtdEstoque() {
		return qtdEstoque;
	}
	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}
	
	public Livro(int idLivro, String anoDePublicacao, float preco, String nome, String autor, String genero,
			String editora, int qtdEstoque, int qtdPagina, boolean oferta, boolean destaque ) {
		super();
		this.idLivro = idLivro;
		this.anoDePublicacao = anoDePublicacao;
		this.preco = preco;
		this.nome = nome;
		this.autor = autor;
		this.genero = genero;
		this.editora = editora;
		this.qtdEstoque = qtdEstoque;
		this.qtdPagina = qtdPagina;
		this.oferta = oferta;
		this.destaque = destaque;
	}
	
	public Livro() {}

	public int getQtdPagina() {
		return qtdPagina;
	}

	public void setQtdPagina(int qtdPagina) {
		this.qtdPagina = qtdPagina;
	}
	public float getPrecoOferta() {
		return precoOferta;
	}
	public void setPrecoOferta(float precoOferta) {
		this.precoOferta = precoOferta;
	}
	
}
