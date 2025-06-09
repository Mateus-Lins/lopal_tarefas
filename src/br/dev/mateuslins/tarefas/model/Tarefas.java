package br.dev.mateuslins.tarefas.model;

import java.time.LocalDate;

import br.dev.mateuslins.tarefas.utils.Utils;

public class Tarefas {

	private String titulo;	
	private String descricao;
	private LocalDate dataInicial;
	private int prazo;
	private LocalDate dataFinal;
	private String status;
	private Funcionario responsavel;
	private int codigo;
	
	
	public Tarefas(int codigo, String titulo, String descricao, LocalDate dataInicial, int prazo, Funcionario responsavel) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataInicial = dataInicial;
        this.prazo = prazo;
        this.status = "NÃO INICIADO";
        this.responsavel = responsavel;
    }


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public LocalDate getDataInicial() {
		return dataInicial;
	}


	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}


	public int getPrazo() {
		return prazo;
	}


	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}


	public LocalDate getDataFinal() {
		return dataFinal;
	}


	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Funcionario getResponsavel() {
		return responsavel;
	}


	public void setResponsavel(Funcionario responsavel) {
		this.responsavel = responsavel;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
}
