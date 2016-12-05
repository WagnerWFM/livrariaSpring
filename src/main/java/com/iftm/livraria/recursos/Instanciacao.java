package com.iftm.livraria.recursos;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iftm.livraria.dominio.Categoria;
import com.iftm.livraria.dominio.Cliente;
import com.iftm.livraria.dominio.Editora;
import com.iftm.livraria.dominio.Emprestimo;
import com.iftm.livraria.dominio.ItemEmprestimo;
import com.iftm.livraria.dominio.Livro;
import com.iftm.livraria.repositorio.CategoriaRepositorio;
import com.iftm.livraria.repositorio.ClienteRepositorio;
import com.iftm.livraria.repositorio.EditoraRepositorio;
import com.iftm.livraria.repositorio.EmprestimoRepositorio;
import com.iftm.livraria.repositorio.ItemEmprestimoRepositorio;
import com.iftm.livraria.repositorio.LivroRepositorio;

@RestController
@RequestMapping("/instanciacao")
public class Instanciacao {

	@Autowired
	private ClienteRepositorio clienteRepo;
	
	@Autowired
	private CategoriaRepositorio categoriaRepo;
	
	@Autowired
	private EditoraRepositorio editoraRepo;
	
	@Autowired
	private EmprestimoRepositorio emprestimoRepo;
	
	@Autowired
	private ItemEmprestimoRepositorio itemEmpestimoRepo;
	
	@Autowired
	private LivroRepositorio livroRepo;
	
	@RequestMapping(method=RequestMethod.GET)
	public String executar() {
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
			
			clienteRepo.save(c1);
			clienteRepo.save(c2);
			clienteRepo.save(c3);
			
			editoraRepo.save(e1);
			editoraRepo.save(e2);
			editoraRepo.save(e3);
			
			categoriaRepo.save(ct1);
			categoriaRepo.save(ct2);
			categoriaRepo.save(ct3);
			
			livroRepo.save(l1);
			livroRepo.save(l2);
			livroRepo.save(l3);
			livroRepo.save(l4);
			livroRepo.save(l5);
			livroRepo.save(l6);
			livroRepo.save(l7);
			livroRepo.save(l8);
			livroRepo.save(l9);
			livroRepo.save(l10);
			
			emprestimoRepo.save(em1);
			emprestimoRepo.save(em2);
			emprestimoRepo.save(em3);
			emprestimoRepo.save(em4);
			emprestimoRepo.save(em5);
			
			itemEmpestimoRepo.save(im1);
			itemEmpestimoRepo.save(im2);
			itemEmpestimoRepo.save(im3);
			itemEmpestimoRepo.save(im4);
			itemEmpestimoRepo.save(im5);
			itemEmpestimoRepo.save(im6);
			itemEmpestimoRepo.save(im7);
			itemEmpestimoRepo.save(im8);
			itemEmpestimoRepo.save(im9);
			itemEmpestimoRepo.save(im10);
			
		}
		catch (ParseException e) {
			return e.getMessage();
		}
		return "Pronto!";
	}
}
