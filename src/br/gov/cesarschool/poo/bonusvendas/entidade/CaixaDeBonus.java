package br.gov.cesarschool.poo.bonusvendas.entidade;

import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Registro;
import java.time.LocalDateTime;

public class CaixaDeBonus extends Registro {
	private long numero; 
	private double saldo; 
	private LocalDateTime dataHoraAtualizacao;
	public CaixaDeBonus(long numero) {
		super();
		this.numero = numero;
		dataHoraAtualizacao = LocalDateTime.now();
	}
	
	@Override
	public String getIdUnico() {
		String numeroString = "" + this.getNumero();
		return numeroString;
	}
	
	public long getNumero() {
		return numero;
	}
	public double getSaldo() {
		return saldo;
	}
	public LocalDateTime getDataHoraAtualizacao() {
		return dataHoraAtualizacao;
	}
	public void creditar(double valor) {
		saldo = saldo + valor;
		dataHoraAtualizacao = LocalDateTime.now();
	}
	public void debitar(double valor) {
		saldo = saldo - valor;
		dataHoraAtualizacao = LocalDateTime.now();
	}

}
