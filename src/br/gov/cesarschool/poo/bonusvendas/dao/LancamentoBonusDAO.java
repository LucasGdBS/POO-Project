package br.gov.cesarschool.poo.bonusvendas.dao;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonus;

public class LancamentoBonusDAO {
	private static final String BRANCO = "";
	private CadastroObjetos cadastro = new CadastroObjetos(LancamentoBonus.class);
	
	 public String identificador(LancamentoBonus bonus) {
	    String dataFormat = bonus.getDataHoraLancamento().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
	    String concat = String.valueOf(bonus.getNumeroCaixaDeBonus()) + dataFormat;
	    return concat;
	   }
	
	public boolean incluir(LancamentoBonus bonus) {
		LancamentoBonus buscado = buscar(identificador(bonus));
		
		if (buscado != null) {
			return false;
		}else {
			cadastro.incluir(bonus, BRANCO+identificador(bonus));
			return true;
		}
	}
	
	public boolean alterar(LancamentoBonus bonus) {
		LancamentoBonus buscado = buscar(identificador(bonus));
		if (buscado == null) {
			return false;
		} else {
			cadastro.alterar(bonus, BRANCO + identificador(bonus));
			return true;
		}		
	}
	
	public boolean excluir(LancamentoBonus bonus) {
		LancamentoBonus buscado = buscar(identificador(bonus));
		if(buscado == null) {
			return false;
		}else {
			cadastro.excluir(BRANCO+identificador(bonus));
			return true;
		}
	}
	
	public LancamentoBonus buscar(String id) {
		return (LancamentoBonus)cadastro.buscar(BRANCO + id);
	}
	
	public LancamentoBonus[] buscarTodos() {
		Serializable[] rets = cadastro.buscarTodos(LancamentoBonus.class);
		LancamentoBonus[] bonus = new LancamentoBonus[rets.length];
		for(int i=0; i<rets.length; i++) {
			bonus[i] = (LancamentoBonus)rets[i];
		}
		return bonus;
	} 

}
