package br.gov.cesarschool.poo.bonusvendas.entidade;

import java.time.Period;
import java.time.LocalDate;
import java.io.Serializable;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Endereco;

public class Vendedor implements Serializable {
	private static final long serialVersionUID = 1L; 
	private String cpf;
	private String nomeCompleto;
	private String sexo;
	private LocalDate dataNascimento;
	private double renda;
	private Endereco endereco;

	public Vendedor(String cpf, String nomeCompleto, String sexo, LocalDate dataNascimento, double renda,
			Endereco endereco) {
		super();
		this.cpf = cpf;
		this.nomeCompleto = nomeCompleto;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.renda = renda;
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
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

	public int calcularIdade(LocalDate dataAtual) {
		Period periodo = Period.between(dataNascimento, dataAtual);
		int idade = periodo.getYears();
		return idade;
	}
}
