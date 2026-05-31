package br.com.guimmotta.services;

import br.com.guimmotta.dao.IProdutoDAO;
import br.com.guimmotta.domain.Produto;
import br.com.guimmotta.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
