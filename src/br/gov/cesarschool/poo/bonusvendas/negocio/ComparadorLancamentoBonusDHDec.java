package br.gov.cesarschool.poo.bonusvendas.negocio;

import java.time.LocalDateTime;
import java.util.Comparator;

import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonus;

public class ComparadorLancamentoBonusDHDec implements Comparator {
	
	private static final ComparadorLancamentoBonusDHDec instancia = new ComparadorLancamentoBonusDHDec();
	
	private ComparadorLancamentoBonusDHDec() {
	}
	
	public static ComparadorLancamentoBonusDHDec getInstance() {
		return instancia;
	}
	
	@Override
	public int compare(Object o1, Object o2) {		
		LancamentoBonus lancamento1 = (LancamentoBonus) o1;
		LancamentoBonus lancamento2 = (LancamentoBonus) o2;
        
		
		LocalDateTime dataHoraLancamento1 = lancamento1.getDataHoraLancamento();
		LocalDateTime dataHoraLancamento2 = lancamento2.getDataHoraLancamento();
		
		int compare = dataHoraLancamento1.compareTo(dataHoraLancamento2);
        
        if (compare > 0){
        	return -1;
        }else if (compare == 0) {
        	return 0;
        }
        return 1;
	}
}
