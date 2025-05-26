package br.dev.mateuslins.tarefas.model;

import br.dev.mateuslins.tarefas.utils.Utils;

public class Funcionario {

	private String nome;	
	private String matricula;
	private String cargo;
	private double salario;

	//método construtor - obrigatoriamente publico, sem retorno, mesmo nome da classe
	public Funcionario(String nome) {
		this.nome = nome;
		this.matricula = Utils.gerarUUID8();
	}
	
	//Construtor padrão / default
	public Funcionario() {
		this.matricula = Utils.gerarUUID8();
	}
	
	public Funcionario(String cargo, String nome) {
		this.cargo = cargo;
		this.nome = nome;
		this.matricula = Utils.gerarUUID8();
	}
	
	public Funcionario(String cargo, String nome, double salario) {
		this.cargo = cargo;
		this.nome = nome;
		this.matricula = Utils.gerarUUID8();
		this.salario = salario;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	@Override
	public String toString() {
//		System.out.println("meu toString");
		String funcionario = matricula + "," + nome + "," + cargo + "," + "salario" + "\n";
		return funcionario;
	}
	
}
