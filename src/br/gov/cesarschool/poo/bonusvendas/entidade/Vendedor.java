package br.gov.cesarschool.poo.bonusvendas.entidade;

import java.time.LocalDate;
import java.io.Serializable;

import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Sexo;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Endereco;

public class Vendedor implements Serializable{
	private String cpf;
	private String nomeCompleto;
	private Sexo sexo;
	private LocalDate dataNascimento;
	private double renda;
	private Endereco endereco;
	
	//Constructor
	public Vendedor(String cpf, String nomeCompleto, Sexo sexo, LocalDate dataNascimento, double renda,
			Endereco endereco) {
		super();
		this.cpf = cpf;
		this.nomeCompleto = nomeCompleto;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.renda = renda;
		this.endereco = endereco;
	}
	
	// Métodos Personalizados
	int calcularIdade() {
		/*calcularIdade(), que calcula e retorna a idade do vendedor em função
		da data atual (obtê-la do JAVA) e da data de nascimento (que é atributo de
		vendedor).*/
		
		return java.time.Period.between(dataNascimento, LocalDate.now()).getYears();
	}
	
	// Getters and Setters (CPF sem set)
	public String getCpf() {
		return cpf;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public double getRenda() {
		return renda;
	}

	public void setRenda(double renda) {
		this.renda = renda;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
	
	
	
}
