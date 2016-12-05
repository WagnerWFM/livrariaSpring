package com.iftm.livraria.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="tb_emprestimos")
public class Emprestimo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	// Internal Variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codEmprestimo;
	private Integer duracaoEmDias;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataEmprestimo;
	
	// Relationship Variables
	@ManyToOne
	@JoinColumn(name="cliente")
	@JsonIgnore
	private Cliente cliente;
	
	@OneToMany(mappedBy="emprestimo")
	@JsonIgnore
	private List<ItemEmprestimo> itens;
	
	public Emprestimo()
	{
		this.itens = new ArrayList<>();
	}

	public Emprestimo(Integer codEmprestimo, Date dataEmprestimo, Integer duracaoEmDias, Cliente cliente) {
		super();
		this.codEmprestimo = codEmprestimo;
		this.dataEmprestimo = dataEmprestimo;
		this.duracaoEmDias = duracaoEmDias;
		this.cliente = cliente;
		this.itens = new ArrayList<>();
	}

	/**
	 * @return the codEmprestimo
	 */
	public Integer getCodEmprestimo() {
		return codEmprestimo;
	}

	/**
	 * @param codEmprestimo the codEmprestimo to set
	 */
	public void setCodEmprestimo(Integer codEmprestimo) {
		this.codEmprestimo = codEmprestimo;
	}

	/**
	 * @return the dataEmprestimo
	 */
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	/**
	 * @param dataEmprestimo the dataEmprestimo to set
	 */
	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	/**
	 * @return the duracaoEmDias
	 */
	public Integer getDuracaoEmDias() {
		return duracaoEmDias;
	}

	/**
	 * @param duracaoEmDias the duracaoEmDias to set
	 */
	public void setDuracaoEmDias(Integer duracaoEmDias) {
		this.duracaoEmDias = duracaoEmDias;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
		return "Emprestimo [codEmprestimo=" + codEmprestimo + ", dataEmprestimo=" + dataEmprestimo + ", duracaoEmDias="
				+ duracaoEmDias + ", cliente=" + cliente + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codEmprestimo == null) ? 0 : codEmprestimo.hashCode());
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
		if (!(obj instanceof Emprestimo)) {
			return false;
		}
		Emprestimo other = (Emprestimo) obj;
		if (codEmprestimo == null) {
			if (other.codEmprestimo != null) {
				return false;
			}
		} else if (!codEmprestimo.equals(other.codEmprestimo)) {
			return false;
		}
		return true;
	}
	
	public BigDecimal valorTotal()
	{
		BigDecimal sum = new BigDecimal("0.00");
		
		for(ItemEmprestimo item: this.itens)
		{
			sum.add(item.subTotal());
		}
		return sum.multiply(new BigDecimal(this.getDuracaoEmDias()));
	}

	
	

}
