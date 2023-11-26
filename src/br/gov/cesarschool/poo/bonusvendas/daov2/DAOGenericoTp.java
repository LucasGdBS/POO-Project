package br.gov.cesarschool.poo.bonusvendas.daov2;

import java.io.Serializable;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Registro;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoObjetoJaExistente;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoObjetoNaoExistente;

public class DAOGenericoTp<T extends Registro> {
    private CadastroObjetos cadastro;
    private String nomeEntidade;

    public DAOGenericoTp(Class<?> tipo, String nomeEntidade) {
        this.cadastro = new CadastroObjetos(tipo);
        this.nomeEntidade = nomeEntidade;
    }

    public void incluir(T reg) throws ExcecaoObjetoJaExistente {
        T busca = null;
        try {
            busca = buscar(reg.getIdUnico());
        } catch (ExcecaoObjetoNaoExistente e) {
            e.printStackTrace();
        }
        if (busca != null) {
            throw new ExcecaoObjetoJaExistente(nomeEntidade + " ja existente");
        }
        cadastro.incluir(reg, reg.getIdUnico());
    }

    public void alterar(T reg) throws ExcecaoObjetoNaoExistente {
        T busca = buscar(reg.getIdUnico());
        if (busca == null) {
            throw new ExcecaoObjetoNaoExistente(nomeEntidade + " nao existente");
        }
        cadastro.alterar(reg, reg.getIdUnico());
    }

    public T buscar(String id) throws ExcecaoObjetoNaoExistente {
        T busca = (T) cadastro.buscar(id);
        if (busca == null) {
            throw new ExcecaoObjetoNaoExistente(nomeEntidade + " nao existente");
        }
        return busca;
    }

    public T[] buscarTodos() {
        Serializable[] rets = cadastro.buscarTodos(cadastro.getClass());
        T[] regs = (T[]) rets;
        return regs;
    }
}
