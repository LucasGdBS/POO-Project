package br.gov.cesarschool.poo.bonusvendas.entidade;

import java.io.Serializable;

public class CaixaDeBonus implements Serializable{
	private long numero;
	private double saldo;
	private java.time.LocalDateTime dataHoraAtualizacao;
	
	// Constructor
	public CaixaDeBonus(long numero) {
		super();
		this.numero = numero;
		this.dataHoraAtualizacao = java.time.LocalDateTime.now();
	}
	
	// Métodos personalizados
	public void creditar(double valor) {		
		saldo += valor;
		dataHoraAtualizacao = java.time.LocalDateTime.now();
	}
	
	public void debitar(double valor) {		
		saldo -= valor;
		dataHoraAtualizacao = java.time.LocalDateTime.now();
	}
	
	// Getters
	public long getNumero() {
		return numero;
	}
	public double getSaldo() {
		return saldo;
	}
	public java.time.LocalDateTime getDataHoraAtualizacao() {
		return dataHoraAtualizacao;
	}
	
	
}
