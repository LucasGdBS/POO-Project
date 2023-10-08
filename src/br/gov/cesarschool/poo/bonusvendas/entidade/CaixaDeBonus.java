package br.gov.cesarschool.poo.bonusvendas.entidade;

import java.time.LocalDateTime;
import java.io.Serializable;

public class CaixaDeBonus implements Serializable{
	private long numero;
	private double saldo;
	private java.time.LocalDateTime dataHoraAtualização;
	
	// Constructor
	public CaixaDeBonus(long numero, double saldo, LocalDateTime dataHoraAtualização) {
		super();
		this.numero = numero;
		this.saldo = saldo;
		this.dataHoraAtualização = dataHoraAtualização;
	}
	
	// Métodos personalizados
	void creditar(double valor) {
		/*deve adicionar ao saldo atual valor, e atualizar
		dataHoraAtualizacao com a data atual.*/
		
		saldo += valor;
		dataHoraAtualização = java.time.LocalDateTime.now();
	}
	
	void debitar(double valor) {
		/*deve subtrair do saldo atual valor, e atualizar a
		dataHoraAtualizacao com a data atual.*/
		
		saldo -= valor;
		dataHoraAtualização = java.time.LocalDateTime.now();
	}
	
	// Getters
	public long getNumero() {
		return numero;
	}
	public double getSaldo() {
		return saldo;
	}
	public java.time.LocalDateTime getDataHoraAtualização() {
		return dataHoraAtualização;
	}
	
	
}
