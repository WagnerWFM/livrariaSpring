package com.iftm.livraria.dominio;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_itensemprestimo")
public class ItemEmprestimo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	// Internal Variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codItemEmprestimo;
	private Integer quantidade;
	
	// Relationship Variables
	@ManyToOne
	@JoinColumn(name="livro")
	@JsonIgnore
	private Livro livro;
	
	@ManyToOne
	@JoinColumn(name="emprestimo")
	@JsonIgnore
	private Emprestimo emprestimo;
	
	public ItemEmprestimo(){}

	public ItemEmprestimo(Integer codItemEmprestimo, Integer quantidade, Livro livro, Emprestimo emprestimo) {
		super();
		this.codItemEmprestimo = codItemEmprestimo;
		this.quantidade = quantidade;
		this.livro = livro;
		this.emprestimo = emprestimo;
	}

	/**
	 * @return the codItemEmprestimo
	 */
	public Integer getCodItemEmprestimo() {
		return codItemEmprestimo;
	}

	/**
	 * @param codItemEmprestimo the codItemEmprestimo to set
	 */
	public void setCodItemEmprestimo(Integer codItemEmprestimo) {
		this.codItemEmprestimo = codItemEmprestimo;
	}

	/**
	 * @return the quantidade
	 */
	public Integer getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * @return the livro
	 */
	public Livro getLivro() {
		return livro;
	}

	/**
	 * @param livro the livro to set
	 */
	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	/**
	 * @return the emprestimo
	 */
	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	/**
	 * @param emprestimo the emprestimo to set
	 */
	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ItemEmprestimo [codItemEmprestimo=" + codItemEmprestimo + ", quantidade=" + quantidade + ", livro="
				+ livro + ", emprestimo=" + emprestimo + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codItemEmprestimo == null) ? 0 : codItemEmprestimo.hashCode());
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
		if (!(obj instanceof ItemEmprestimo)) {
			return false;
		}
		ItemEmprestimo other = (ItemEmprestimo) obj;
		if (codItemEmprestimo == null) {
			if (other.codItemEmprestimo != null) {
				return false;
			}
		} else if (!codItemEmprestimo.equals(other.codItemEmprestimo)) {
			return false;
		}
		return true;
	}
	
	public BigDecimal subTotal()
	{
		return this.livro.getValorDiario().multiply(new BigDecimal(getQuantidade()));
	}

}
