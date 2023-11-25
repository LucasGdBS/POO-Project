package br.gov.cesarschool.poo.bonusvendas.dao;

import java.io.Serializable;

import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;

public class VendedorDAO {
	private DAOGenerico dao;
	
	public VendedorDAO() {
		dao = new DAOGenerico(Vendedor.class);
	}
	
	public boolean incluir(Vendedor vend) {
		return dao.incluir(vend);	 
	}
	
	public boolean alterar(Vendedor vend) {
		return dao.alterar(vend);	
	}
	
	public Vendedor buscar(String cpf) {
		return (Vendedor)dao.buscar(cpf);
	}
	
	public Vendedor[] buscarTodos() {
		Serializable[] rets = dao.buscarTodos();
		Vendedor[] vends = new Vendedor[rets.length];
		for(int i=0; i<rets.length; i++) { 
			vends[i] = (Vendedor)rets[i];
		}
		return vends;
	} 

}
