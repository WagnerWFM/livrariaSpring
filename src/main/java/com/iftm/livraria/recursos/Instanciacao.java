package com.iftm.livraria.recursos;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Categoria;
import dominio.Cliente;
import dominio.Editora;
import dominio.Emprestimo;
import dominio.ItemEmprestimo;
import dominio.Livro;
import servico.CategoriaServico;
import servico.ClienteServico;
import servico.EditoraServico;
import servico.EmprestimoServico;
import servico.ItemEmprestimoServico;
import servico.LivroServico;
import servico.ServicoException;


/**
 * Servlet implementation class Instanciacao
 */
@WebServlet("/Instanciacao")
public class Instanciacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			Cliente c1 = new Cliente(null, "Guilherme Ferreira", "09243891685", "34-3235-8893", "guilherme.oliveira@gmail.com", sdf.parse("04/08/1989"), new BigDecimal("200000.00"));
			Cliente c2 = new Cliente(null, "Luciana Oliveira", "07248892635", "34-3255-8893", "luciana.oliveira@gmail.com", sdf.parse("04/09/1990"), new BigDecimal("600000.00"));
			Cliente c3 = new Cliente(null, "Gustavo Ferreira", "09243801685", "34-3235-9893", "gustavo.oliveira@gmail.com", sdf.parse("24/08/1989"), new BigDecimal("200000.00"));
			
			Editora e1 = new Editora(null, "Atlas");
			Editora e2 = new Editora(null, "Viva");
			Editora e3 = new Editora(null, "Trash");
			
			Categoria ct1 = new  Categoria(null, "Romance");
			Categoria ct2 = new  Categoria(null, "Filosofia");
			Categoria ct3 = new  Categoria(null, "Tecnologia");
			
			Livro l1 = new Livro(null, "HTML & CSS", "", 400, new BigDecimal("20.00"), e1, ct3);
			Livro l2 = new Livro(null, "JAVA", "", 400, new BigDecimal("20.00"), e1, ct3);
			Livro l3 = new Livro(null, "OBJECTIVE C", "", 400, new BigDecimal("20.00"), e1, ct3);
			Livro l4 = new Livro(null, "C#", "", 400, new BigDecimal("20.00"), e1, ct3);
			Livro l5 = new Livro(null, "ERA UMA VEZ", "", 400, new BigDecimal("20.00"), e2, ct1);
			Livro l6 = new Livro(null, "FELICIDADE HOJE", "", 400, new BigDecimal("20.00"), e2, ct1);
			Livro l7 = new Livro(null, "ALEGRIA", "", 400, new BigDecimal("20.00"), e2, ct1);
			Livro l8 = new Livro(null, "SEI QUE NADA SEI", "", 400, new BigDecimal("20.00"), e3, ct2);
			Livro l9 = new Livro(null, "SOCRATES", "", 400, new BigDecimal("20.00"), e3, ct2);
			Livro l10 = new Livro(null, "PLATAO", "", 400, new BigDecimal("20.00"), e3, ct2);
			
			Emprestimo em1 = new Emprestimo(null, sdf.parse("29/08/1989"), 3, c1);
			Emprestimo em2 = new Emprestimo(null, sdf.parse("29/08/1989"), 3, c2);
			Emprestimo em3 = new Emprestimo(null, sdf.parse("29/08/1989"), 3, c3);
			Emprestimo em4 = new Emprestimo(null, sdf.parse("29/08/1989"), 3, c1);
			Emprestimo em5 = new Emprestimo(null, sdf.parse("29/08/1989"), 3, c1);
			
			ItemEmprestimo im1 = new ItemEmprestimo(null, 10, l1, em1);
			ItemEmprestimo im2 = new ItemEmprestimo(null, 10, l2, em1);
			ItemEmprestimo im3 = new ItemEmprestimo(null, 10, l3, em2);
			ItemEmprestimo im4 = new ItemEmprestimo(null, 10, l4, em2);
			ItemEmprestimo im5 = new ItemEmprestimo(null, 10, l7, em3);
			ItemEmprestimo im6 = new ItemEmprestimo(null, 10, l5, em3);
			ItemEmprestimo im7 = new ItemEmprestimo(null, 10, l6, em4);
			ItemEmprestimo im8 = new ItemEmprestimo(null, 10, l8, em4);
			ItemEmprestimo im9 = new ItemEmprestimo(null, 10, l10, em5);
			ItemEmprestimo im10 = new ItemEmprestimo(null, 10, l9, em5);
			
			// Insere cliente
			ClienteServico cs = new ClienteServico();
			cs.inserir(c1);
			cs.inserir(c2);
			cs.inserir(c3);
			
			// Insere editora
			EditoraServico es = new EditoraServico();
			es.inserir(e1);
			es.inserir(e2);
			es.inserir(e3);
			
			es.Atualizar(e3);
			es.Atualizar(e1);
			es.Atualizar(e2);
			
			// Insere categoria
			CategoriaServico cts = new CategoriaServico();
			cts.inserir(ct1);
			cts.inserir(ct2);
			cts.inserir(ct3);
			
			cts.Atualizar(ct3);
			cts.Atualizar(ct1);
			cts.Atualizar(ct2);
			
			// Insere livro
			LivroServico ls = new LivroServico();
			ls.inserir(l1);
			ls.inserir(l2);
			ls.inserir(l3);
			ls.inserir(l4);
			ls.inserir(l5);
			ls.inserir(l6);
			ls.inserir(l7);
			ls.inserir(l8);
			ls.inserir(l9);
			ls.inserir(l10);
			
			// Insere emprestimo
			EmprestimoServico eps = new EmprestimoServico();
			eps.inserirAtualizar(em1);
			eps.inserirAtualizar(em2);
			eps.inserirAtualizar(em3);
			eps.inserirAtualizar(em4);
			eps.inserirAtualizar(em5);
			
			// Insere item do emprestimo
			ItemEmprestimoServico ies = new ItemEmprestimoServico();
			ies.inserirAtualizar(im1);
			ies.inserirAtualizar(im2);
			ies.inserirAtualizar(im3);
			ies.inserirAtualizar(im4);
			ies.inserirAtualizar(im5);
			ies.inserirAtualizar(im6);
			ies.inserirAtualizar(im7);
			ies.inserirAtualizar(im8);
			ies.inserirAtualizar(im9);
			ies.inserirAtualizar(im10);

			response.getWriter().append("<br>Fim");
		}
		catch (ParseException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		catch (ServicoException e) {
			response.getWriter().append("Erro! " + e.getMessage());
		}
	}

}
