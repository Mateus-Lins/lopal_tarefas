package br.dev.mateuslins.tarefas.dao;

import java.io.BufferedReader;

import br.dev.mateuslins.tarefas.model.Tarefas;

public class TarefasDao {

	private Tarefas tarefa;
	
	public TarefasDao(){}
	
	public TarefasDao(Tarefas tarefas) {
		this.tarefa = tarefas;
	}
	
	
//  isso aq ta dando errado, talves seja melhor só apagar esse dao e criar outro 
}
