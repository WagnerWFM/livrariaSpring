package com.iftm.livraria.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_livros")
public class Livro implements Serializable{
	
	private static final long serialVersionUID = 1L;
	// Internal Variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codLivro;
	private String titulo, isbn;
	private Integer paginas;
	private BigDecimal valorDiario;
	
	// Relationship Variables
	@ManyToOne
	@JoinColumn(name="editora")
	private Editora editora;
	@ManyToOne
	@JoinColumn(name="categoria")
	private Categoria categoria;
	@OneToMany(mappedBy="livro")
	private List<ItemEmprestimo> itens;
	
	public Livro()
	{
		this.itens = new ArrayList<>();
	}

	public Livro(Integer codLivro, String titulo, String isbn, Integer paginas, BigDecimal valorDiario, Editora editora,
			Categoria categoria) {
		super();
		this.codLivro = codLivro;
		this.titulo = titulo;
		this.isbn = isbn;
		this.paginas = paginas;
		this.valorDiario = valorDiario;
		this.editora = editora;
		this.categoria = categoria;
		this.itens = new ArrayList<>();
	}

	/**
	 * @return the codLivro
	 */
	public Integer getCodLivro() {
		return codLivro;
	}

	/**
	 * @param codLivro the codLivro to set
	 */
	public void setCodLivro(Integer codLivro) {
		this.codLivro = codLivro;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the paginas
	 */
	public Integer getPaginas() {
		return paginas;
	}

	/**
	 * @param paginas the paginas to set
	 */
	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

	/**
	 * @return the valorDiario
	 */
	public BigDecimal getValorDiario() {
		return valorDiario;
	}

	/**
	 * @param valorDiario the valorDiario to set
	 */
	public void setValorDiario(BigDecimal valorDiario) {
		this.valorDiario = valorDiario;
	}

	/**
	 * @return the editora
	 */
	public Editora getEditora() {
		return editora;
	}

	/**
	 * @param editora the editora to set
	 */
	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	/**
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return the itens
	 */
	public List<ItemEmprestimo> getItens() {
		return itens;
	}

	/**
	 * @param itens the itens to set
	 */
	public void setItens(List<ItemEmprestimo> itens) {
		this.itens = itens;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Livro [codLivro=" + codLivro + ", titulo=" + titulo + ", isbn=" + isbn + ", paginas=" + paginas
				+ ", valorDiario=" + valorDiario + ", editora=" + editora + ", categoria=" + categoria + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codLivro == null) ? 0 : codLivro.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Livro)) {
			return false;
		}
		Livro other = (Livro) obj;
		if (codLivro == null) {
			if (other.codLivro != null) {
				return false;
			}
		} else if (!codLivro.equals(other.codLivro)) {
			return false;
		}
		return true;
	}
	
	
	
	

}
