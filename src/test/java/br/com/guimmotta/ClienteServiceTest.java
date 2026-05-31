package br.com.guimmotta;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.guimmotta.dao.ClienteDaoMock;
import br.com.guimmotta.dao.IClienteDAO;
import br.com.guimmotta.domain.Cliente;
import br.com.guimmotta.exceptions.TipoChaveNaoEncontradaException;
import br.com.guimmotta.services.ClienteService;
import br.com.guimmotta.services.IClienteService;

public class ClienteServiceTest {
	
	private IClienteService clienteService;
	
	private Cliente cliente;
	
	public ClienteServiceTest() {
		IClienteDAO dao = new ClienteDaoMock();
		clienteService = new ClienteService(dao);
	}
	
	@Before
	public void init() {
		cliente = new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Aguinaldo");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("MG");
		cliente.setNumero(10);
		cliente.setTel(3599999999L);
		
	}
	
	@Test
	public void pesquisarCliente() {
		Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException {
		Boolean retorno = clienteService.cadastrar(cliente);
		
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() {
		clienteService.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException {
		cliente.setNome("Aguinaldo Motta");
		clienteService.alterar(cliente);
		
		Assert.assertEquals("Aguinaldo Motta", cliente.getNome());
	}
}
