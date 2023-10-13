package br.gov.cesarschool.poo.bonusvendas.entidade;

import java.time.LocalDateTime;
import java.io.Serializable;

public class LancamentoBonus implements Serializable{
	private long numeroCaixaDeBonus;
	private double valor;
	private LocalDateTime dataHoraLancamento;
	
	// Constructor
	public LancamentoBonus(long numeroCaixaDeBonus, double valor, LocalDateTime dataHoraLancamento) {
		super();
		this.numeroCaixaDeBonus = numeroCaixaDeBonus;
		this.valor = valor;
		this.dataHoraLancamento = dataHoraLancamento;
	}
	
	// Getters
	public long getNumeroCaixaDeBonus() {
		return numeroCaixaDeBonus;
	}

	public double getValor() {
		return valor;
	}

	public LocalDateTime getDataHoraLancamento() {
		return dataHoraLancamento;
	}

	// Setters
	public void setNumeroCaixaDeBonus(long numeroCaixaDeBonus) {
		this.numeroCaixaDeBonus = numeroCaixaDeBonus;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
