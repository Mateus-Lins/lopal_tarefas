package br.dev.mateuslins.tarefas.model;

import java.time.LocalDate;

import br.dev.mateuslins.tarefas.utils.Utils;

public class Tarefas {

	private String titulo;	
	private String descricao;
	private String dataInicial;
	private String prazo;
	private String dataFinal;
	private String status;
	private String responsavel;
	private String codigo;
	
	
	public Tarefas() {
		this.codigo = Utils.gerarUUID8();
	}

	public Tarefas(String titulo) {
		this.titulo = titulo;
		this.codigo = Utils.gerarUUID8();
	}

	public Tarefas(String prazo, String titulo) {

		this.prazo = prazo;
		this.titulo = titulo;
		this.codigo = Utils.gerarUUID8();

	}

	public Tarefas(String prazo, String titulo, String descricao) {
		this.prazo = prazo;
		this.titulo = titulo;
		this.descricao = descricao;
		this.codigo = Utils.gerarUUID8();
	}

	public Tarefas(String titulo, String descricao, String dataInicial, String prazo, String dataFinal) {

		this.prazo = prazo;
		this.dataInicial = dataInicial;
		this.dataFinal = dataInicial;
		this.titulo = titulo;
		this.descricao = descricao;
		this.codigo = Utils.gerarUUID8();

	}

	public Tarefas(String titulo, String descricao, String dataInicial, String prazo, String dataFinal,
			String status, String responsavel) {

		this.prazo = prazo;
		this.dataInicial = dataInicial;
		this.dataFinal = dataInicial;
		this.titulo = titulo;
		this.descricao = descricao;
		this.codigo = Utils.gerarUUID8();
		this.status = status;
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


	public String getDataInicial() {
		return dataInicial;
	}


	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}


	public String getPrazo() {
		return prazo;
	}


	public void setPrazo(String prazo) {
		this.prazo = prazo;
	}


	public String getDataFinal() {
		return dataFinal;
	}


	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getResponsavel() {
		return responsavel;
	}


	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}
