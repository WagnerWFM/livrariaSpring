package com.iftm.livraria.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_editoras")
public class Editora implements Serializable {

	private static final long serialVersionUID = 1L;
	// Internal Variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codEditora;
	private String nome;
	
	// Relationship Variables
	@OneToMany(mappedBy="editora")
	@JsonIgnore
	private List<Livro>livros;
	
	public Editora()
	{
		this.livros = new ArrayList<>();
	}

	public Editora(Integer codEditora, String nome) {
		super();
		this.codEditora = codEditora;
		this.nome = nome;
		this.livros = new ArrayList<>();
	}

	/**
	 * @return the codEditora
	 */
	public Integer getCodEditora() {
		return codEditora;
	}

	/**
	 * @param codEditora the codEditora to set
	 */
	public void setCodEditora(Integer codEditora) {
		this.codEditora = codEditora;
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
		return "Editora [codEditora=" + codEditora + ", nome=" + nome + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codEditora == null) ? 0 : codEditora.hashCode());
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
		if (!(obj instanceof Editora)) {
			return false;
		}
		Editora other = (Editora) obj;
		if (codEditora == null) {
			if (other.codEditora != null) {
				return false;
			}
		} else if (!codEditora.equals(other.codEditora)) {
			return false;
		}
		return true;
	}
	
	public Livro livroMaisCaro()
	{
		BigDecimal maisCaro = new BigDecimal("0.00");
		Livro livro = null;
		
		for(Livro l : this.livros)
		{
			if(l.getValorDiario().compareTo(maisCaro) > 0)
			{
				livro = l;
				maisCaro.add(l.getValorDiario());
			}
		}
		return livro;
	}
	
	

}
