package br.gov.cesarschool.poo.bonusvendas.negocio;

import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;
import br.gov.cesarschool.poo.bonusvendas.util.Comparador;

public class ComparadorCaixaDeBonusSaldoDec implements Comparador{
	
	private static final ComparadorCaixaDeBonusSaldoDec instancia = new ComparadorCaixaDeBonusSaldoDec();
	
	private ComparadorCaixaDeBonusSaldoDec() {
	}
	
	public static ComparadorCaixaDeBonusSaldoDec getInstance() {
		return instancia;
	}
	
	@Override
	public int comparar(Object o1, Object o2) {		
		CaixaDeBonus caixa1 = (CaixaDeBonus) o1;
        CaixaDeBonus caixa2 = (CaixaDeBonus) o2;
        
        
        if (caixa1.getSaldo() > caixa2.getSaldo()){
        	return -1;
        }else if (caixa1.getSaldo() == caixa2.getSaldo()) {
        	return 0;
        }
        return 1;
	}
}
