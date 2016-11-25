package com.iftm.livraria.servico;

import java.util.List;

import javax.transaction.Transaction;

import com.iftm.livraria.dominio.Cliente;
import com.iftm.livraria.servico.excecoes.ServicoException;

public class ClienteServico {
	
	
	public ClienteServico() {
		dao = DaoFactory.criarClienteDao();
	}
	
	public void inserir(Cliente x) throws ServicoException {
		try {
			Cliente aux = dao.buscaClientePorCpf(x.getCpf());
			if (aux != null) {
				throw new ServicoException("J� existe um cliente com esse CPF! Inser��o cancelada.", 1);
			}
			
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
		}
		catch (RuntimeException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void atualizar(Cliente x) throws ServicoException {
		try {
			Cliente aux = dao.buscaClientePorCpf(x.getCpf());
			if (aux != null && aux.getCodCliente() != x.getCodCliente()) {
				throw new ServicoException("J� existe um cliente com esse CPF! Atualiza��o cancelada.", 1);
			}
			
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
		}
		catch (RuntimeException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void excluir(Cliente x) throws ServicoException {
		try {
			x = dao.buscar(x.getCodCliente());
			if (!x.getEmprestimos().isEmpty()) {
				throw new ServicoException("Exclus�o n�o permitida! Cliente possui emprestimos!", 2);
			}
			
			Transaction.begin();
			dao.excluir(x);
			Transaction.commit();
		}
		catch (RuntimeException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public Cliente buscar(int cod) 
	{
		return dao.buscar(cod);
	}
	
	public List<Cliente> buscarTodos() 
	{
		return dao.buscarTodos();
	}

}
