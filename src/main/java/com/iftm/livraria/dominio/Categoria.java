package com.iftm.livraria.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_categorias")
public class Categoria implements Serializable{
	
	private static final long serialVersionUID = 1L;
	// Internal Variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codCategoria;
	private String nome;
	
	// Relationship Variables
	@OneToMany(mappedBy="categoria")
	private List<Livro>livros;
	
	public Categoria()
	{
		this.livros = new ArrayList<>();
	}

	public Categoria(Integer codCategoria, String nome) {
		super();
		this.codCategoria = codCategoria;
		this.nome = nome;
		this.livros = new ArrayList<>();
	}

	/**
	 * @return the codCategoria
	 */
	public Integer getCodCategoria() {
		return codCategoria;
	}

	/**
	 * @param codCategoria the codCategoria to set
	 */
	public void setCodCategoria(Integer codCategoria) {
		this.codCategoria = codCategoria;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the livros
	 */
	public List<Livro> getLivros() {
		return livros;
	}

	/**
	 * @param livros the livros to set
	 */
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Categoria [codCategoria=" + codCategoria + ", nome=" + nome + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codCategoria == null) ? 0 : codCategoria.hashCode());
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
		if (!(obj instanceof Categoria)) {
			return false;
		}
		Categoria other = (Categoria) obj;
		if (codCategoria == null) {
			if (other.codCategoria != null) {
				return false;
			}
		} else if (!codCategoria.equals(other.codCategoria)) {
			return false;
		}
		return true;
	}
	
	

}
