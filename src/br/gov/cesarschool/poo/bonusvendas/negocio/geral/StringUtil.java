package br.gov.cesarschool.poo.bonusvendas.negocio.geral;

public class StringUtil {
	
	/*public static boolean ehNuloOuBranco(String str): deve retornar true se a string
	recebida for null ou string vazia quando tem seus espaços à direita e à esquerda
	removidos.*/
	
	public static boolean ehNuloOuBranco(String str) {
		if (str == null || str.trim().isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
}
