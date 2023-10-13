package br.gov.cesarschool.poo.bonusvendas.entidade;

import java.time.LocalDateTime;
import java.io.Serializable;

public class CaixaDeBonus implements Serializable{
	private long numero;
	private double saldo;
	private java.time.LocalDateTime dataHoraAtualização;
	
	// Constructor
	public CaixaDeBonus(long numero) {
		super();
		this.numero = numero;
	}
	
	// Métodos personalizados
	public void creditar(double valor) {
		/*deve adicionar ao saldo atual valor, e atualizar
		dataHoraAtualizacao com a data atual.*/
		
		saldo += valor;
		dataHoraAtualização = java.time.LocalDateTime.now();
	}
	
	public void debitar(double valor) {
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
