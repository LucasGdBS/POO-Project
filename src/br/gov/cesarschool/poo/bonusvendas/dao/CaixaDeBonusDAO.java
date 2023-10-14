package br.gov.cesarschool.poo.bonusvendas.dao;

import java.io.Serializable;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;

public class CaixaDeBonusDAO {
	private static final String BRANCO = "";
	private CadastroObjetos cadastro = new CadastroObjetos(CaixaDeBonus.class);
	
	public boolean incluir(CaixaDeBonus caixa) {
		CaixaDeBonus buscado = buscar(caixa.getNumero());
		
		if (buscado != null) {
			return false;
		}else {
			cadastro.incluir(caixa, BRANCO+caixa.getNumero());
			return true;
		}
	}
	
	public boolean alterar(CaixaDeBonus caixa) {
		CaixaDeBonus buscado = buscar(caixa.getNumero());
		if (buscado == null) {
			return false;
		} else {
			cadastro.alterar(caixa, BRANCO + caixa.getNumero());
			return true;
		}		
	}
	
	public boolean excluir(CaixaDeBonus caixa) {
		CaixaDeBonus buscado = buscar(caixa.getNumero());
		if(buscado == null) {
			return false;
		}else {
			cadastro.excluir(BRANCO+caixa.getNumero());
			return true;
		}
	}
	
	public CaixaDeBonus buscar(long numero) {
		return (CaixaDeBonus)cadastro.buscar(BRANCO+numero);
	}
	
	public CaixaDeBonus[] buscarTodos() {
		Serializable[] rets = cadastro.buscarTodos(CaixaDeBonus.class);
		CaixaDeBonus[] caixas = new CaixaDeBonus[rets.length];
		for(int i=0; i<rets.length; i++) {
			caixas[i] = (CaixaDeBonus)rets[i];
		}
		return caixas;
	} 
}


