package com.iftm.livraria.recursos;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.iftm.livraria.dominio.Cliente;
import com.iftm.livraria.servico.ClienteServico;

@RestController
@RequestMapping("/clientes")
public class ClienteRecurso {

	@Autowired
	private ClienteServico cs;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> todos() {
		List<Cliente> lista = cs.buscarTodosOrdenadosPorNome();
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Integer id) {
		Cliente cli = cs.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(cli);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> criar(@RequestBody Cliente cliente) {
		cliente = cs.inserir(cliente);
		URI uri = getUri("/{id}", cliente.getCodCliente());
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Integer id) {
		cs.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)	// atualizar
	public ResponseEntity<Void> atualizar(@RequestBody Cliente cliente, @PathVariable("id") Integer id) {
		cliente.setCodCliente(id);
		cliente = cs.atualizar(cliente);
		return ResponseEntity.noContent().build();
	}
	
	private URI getUri(String nome, Integer valor) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path(nome).buildAndExpand(valor).toUri();
	}
}

