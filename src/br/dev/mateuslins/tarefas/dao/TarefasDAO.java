package br.dev.mateuslins.tarefas.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import br.dev.mateuslins.tarefas.factory.FileFactory;
import br.dev.mateuslins.tarefas.model.Status;
import br.dev.mateuslins.tarefas.model.Tarefas;

public class TarefasDAO {

	private Tarefas tarefas;

	public TarefasDAO() {
	}

	public TarefasDAO(Tarefas tarefas) {
		this.tarefas = tarefas;
	}

	public void gravar() {
		try {
			FileFactory ff = new FileFactory();
			ff.getBufferedWriterTarefas().write(tarefas.toString());
			ff.getBufferedWriterTarefas().flush();

		} catch (IOException erro) {

			erro.printStackTrace();
		}
	}

	public List<Tarefas> listar() {

		List<Tarefas> tarefas = new ArrayList<Tarefas>();

		try {
			FileFactory ff = new FileFactory();
			BufferedReader br = ff.getBufferedReaderTarefas();
			BufferedReader br1 = ff.getBufferedReaderFuncionario();

			String linha = "";
			String linha1 = "";

			br.readLine();
			br1.readLine();

			while ((linha = br.readLine()) != null) {
				if (!linha.trim().isEmpty()) {
					String[] tarefaStr = linha.split(",");

					if (tarefaStr.length >= 7) { 
						Tarefas tarefa = new Tarefas();
						tarefa.setTitulo(tarefaStr[0]);
						tarefa.setDescricao(tarefaStr[1]);
						tarefa.setDataInicial(tarefaStr[2]);
						tarefa.setPrazo(tarefaStr[3]);
						tarefa.setDataFinal(tarefaStr[4]);
						tarefa.setStatus(tarefaStr[5]);
						tarefa.setResponsavel(tarefaStr[6]);

						tarefas.add(tarefa);
					}
				}
			}
			br.close();
			return tarefas;

		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Tarefas>(); 
		}
	}

}
