package br.gov.cesarschool.poo.bonusvendas.negocio;

import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.gov.cesarschool.poo.bonusvendas.util.Comparador;

public class ComparadorVendedorNome implements Comparador{
	
	private static final ComparadorVendedorNome instancia = new ComparadorVendedorNome();
	
	private ComparadorVendedorNome() {
	}
	
	public static ComparadorVendedorNome getInstance() {
		return instancia;
	}
	
	@Override
	public int comparar(Object o1, Object o2) {		
		Vendedor vendedor1 = (Vendedor) o1;
        Vendedor vendedor2 = (Vendedor) o2;
        
        int compare = vendedor1.getNomeCompleto().compareTo(vendedor2.getNomeCompleto());
        if (compare > 0){
        	return 1;
        }else if (compare == 0) {
        	return 0;
        }
        return -1;
	}
}
