/*
	ResultadoInclusaoVendedor
	Pacote: br.gov.cesarschool.poo.bonusvendas.negocio
	Atributos: devem ser privados
	• numeroCaixaDeBonus – long
	• mensagemErroValidacao – String
	Construtor: público, deve inicializar os dois atributos.
	Métodos: gets públicos para os dois atrubutos
*/

package br.gov.cesarschool.poo.bonusvendas.negocio;

public class ResultadoInclusaoVendedor {
	private long numeroCaixaDeBonus;
	private String mensagemErroValidacao;
	
	public ResultadoInclusaoVendedor(long numeroCaixaDeBonus, String mensagemErroValidacao){
		this.numeroCaixaDeBonus = numeroCaixaDeBonus;
		this.mensagemErroValidacao = mensagemErroValidacao;
	}
	
	public long getNumeroCaixaDeBonus() {
		return numeroCaixaDeBonus;
	}
	
	public String getMensagemErroValidacao() {
		return mensagemErroValidacao;
	}
	
}
