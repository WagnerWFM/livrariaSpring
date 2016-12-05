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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_clientes")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	// Internal Variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codCliente;
	private String nome, cpf, fone, email;
	private BigDecimal rendaMensal;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date nascimento;
	
	// Relationship Variables
	@OneToMany(mappedBy="cliente")
	@JsonIgnore
	private List<Emprestimo> emprestimos;
	
	Cliente()
	{
		this.emprestimos = new ArrayList<>();
	}

	public Cliente(Integer codCliente, String nome, String cpf, String fone, String email, Date nascimento,
			BigDecimal rendaMensal) {
		super();
		this.codCliente = codCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.fone = fone;
		this.email = email;
		this.nascimento = nascimento;
		this.rendaMensal = rendaMensal;
		this.emprestimos = new ArrayList<>();
	}

	/**
	 * @return the codCliente
	 */
	public Integer getCodCliente() {
		return codCliente;
	}

	/**
	 * @param codCliente the codCliente to set
	 */
	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
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
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the fone
	 */
	public String getFone() {
		return fone;
	}

	/**
	 * @param fone the fone to set
	 */
	public void setFone(String fone) {
		this.fone = fone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the nascimento
	 */
	public Date getNascimento() {
		return nascimento;
	}

	/**
	 * @param nascimento the nascimento to set
	 */
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	/**
	 * @return the rendaMensal
	 */
	public BigDecimal getRendaMensal() {
		return rendaMensal;
	}

	/**
	 * @param rendaMensal the rendaMensal to set
	 */
	public void setRendaMensal(BigDecimal rendaMensal) {
		this.rendaMensal = rendaMensal;
	}

	/**
	 * @return the emprestimos
	 */
	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	/**
	 * @param emprestimos the emprestimos to set
	 */
	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cliente [codCliente=" + codCliente + ", nome=" + nome + ", cpf=" + cpf + ", fone=" + fone + ", email="
				+ email + ", nascimento=" + nascimento + ", rendaMensal=" + rendaMensal + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codCliente == null) ? 0 : codCliente.hashCode());
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
		if (!(obj instanceof Cliente)) {
			return false;
		}
		Cliente other = (Cliente) obj;
		if (codCliente == null) {
			if (other.codCliente != null) {
				return false;
			}
		} else if (!codCliente.equals(other.codCliente)) {
			return false;
		}
		return true;
	}
	
	
}
