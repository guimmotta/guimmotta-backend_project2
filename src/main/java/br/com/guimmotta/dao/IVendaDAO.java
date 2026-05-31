package br.com.guimmotta.dao;

import br.com.guimmotta.dao.generic.IGenericDAO;
import br.com.guimmotta.domain.Venda;
import br.com.guimmotta.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException;
}
