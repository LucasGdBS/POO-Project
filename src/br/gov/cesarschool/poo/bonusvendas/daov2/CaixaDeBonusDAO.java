package br.gov.cesarschool.poo.bonusvendas.daov2;

import java.io.Serializable;

import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;

public class CaixaDeBonusDAO {
	private static final String BRANCO = "";
	private DAOGenerico dao;
	
	public CaixaDeBonusDAO() {
		dao = new DAOGenerico(CaixaDeBonus.class);
	}	
	
	public boolean incluir(CaixaDeBonus caixaBonus) {
		return dao.incluir(caixaBonus); 
	}
	public boolean alterar(CaixaDeBonus caixaBonus) {
		return dao.alterar(caixaBonus);	
	}
	public CaixaDeBonus buscar(long codigo) {
		return (CaixaDeBonus)dao.buscar(BRANCO + codigo);
	}
	public CaixaDeBonus[] buscarTodos() {
		Serializable[] rets = dao.buscarTodos();
		CaixaDeBonus[] caixaBonus = new CaixaDeBonus[rets.length];
		for(int i=0; i<rets.length; i++) {
			caixaBonus[i] = (CaixaDeBonus)rets[i];
		}
		return caixaBonus;
	} 


}
