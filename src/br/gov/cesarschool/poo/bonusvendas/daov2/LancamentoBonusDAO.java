package br.gov.cesarschool.poo.bonusvendas.daov2;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonus;

public class LancamentoBonusDAO {
	private DAOGenerico dao;
	
	public LancamentoBonusDAO() {
		dao = new DAOGenerico(LancamentoBonus.class);
	}
	
	public boolean incluir(LancamentoBonus lancamento) {
		return dao.incluir(lancamento); 
	}
	
	public boolean alterar(LancamentoBonus lancamento) {
		return dao.alterar(lancamento);	
	}
	public LancamentoBonus buscar(String codigo) {
		return (LancamentoBonus)dao.buscar(codigo);
	}
	public LancamentoBonus[] buscarTodos() {
		Serializable[] rets = dao.buscarTodos();
		LancamentoBonus[] lancamentos = new LancamentoBonus[rets.length];
		for(int i=0; i<rets.length; i++) {
			lancamentos[i] = (LancamentoBonus)rets[i];
		}
		return lancamentos;
	} 

}
