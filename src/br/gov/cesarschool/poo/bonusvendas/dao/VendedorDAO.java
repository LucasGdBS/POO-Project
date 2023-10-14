package br.gov.cesarschool.poo.bonusvendas.dao;

import java.io.Serializable;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;

public class VendedorDAO {
	private static final String BRANCO = "";
	private CadastroObjetos cadastro = new CadastroObjetos(Vendedor.class);
	
	public boolean incluir(Vendedor vend) {
		Vendedor buscado = buscar(vend.getCpf());
		
		if (buscado != null) {
			return false;
		}else {
			cadastro.incluir(vend, BRANCO+vend.getCpf());
			return true;
		}
	}
	
	public boolean alterar(Vendedor vend) {
		Vendedor buscado = buscar(vend.getCpf());
		if (buscado == null) {
			return false;
		} else {
			cadastro.alterar(vend, BRANCO + vend.getCpf());
			return true;
		}		
	}
	
	public boolean excluir(Vendedor vend) {
		Vendedor buscado = buscar(vend.getCpf());
		if(buscado == null) {
			return false;
		}else {
			cadastro.excluir(BRANCO+vend.getCpf());
			return true;
		}
	}
	
	public Vendedor buscar(String cpf) {
		return (Vendedor)cadastro.buscar(BRANCO + cpf);
	}
	
	public Vendedor[] buscarTodos() {
		Serializable[] rets = cadastro.buscarTodos(Vendedor.class);
		Vendedor[] vendedores = new Vendedor[rets.length];
		for(int i=0; i<rets.length; i++) {
			vendedores[i] = (Vendedor)rets[i];
		}
		return vendedores;
	} 
	
	
}
