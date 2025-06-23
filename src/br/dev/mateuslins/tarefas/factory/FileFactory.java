package br.dev.mateuslins.tarefas.factory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileFactory {
	
	private String arquivo2 = "C:\\Users\\PC\\Desktop\\projetos\\tarefas.csv";
	private String arquivo1 = "C:\\Users\\PC\\Desktop\\projetos\\funcionarios.csv";
	
	private FileWriter fwfuncionario;
	private BufferedWriter bwfuncionario;

	private FileReader frfuncionario;
	private BufferedReader brfuncionario;

	private FileWriter fwtarefas;
	private BufferedWriter bwtarefas;

	private FileReader frtarefas;
	private BufferedReader brtarefas;

	public FileFactory() throws IOException {

		
		fwfuncionario = new FileWriter(arquivo1, true);
		bwfuncionario = new BufferedWriter(fwfuncionario);

	
		frfuncionario = new FileReader(arquivo1);
		brfuncionario = new BufferedReader(frfuncionario);

		fwtarefas = new FileWriter(arquivo2, true);
		bwtarefas = new BufferedWriter(fwtarefas);

		
		frtarefas = new FileReader(arquivo2);
		brtarefas = new BufferedReader(frtarefas);

	}

	public BufferedWriter getBufferedWriterFuncionario() {
		return bwfuncionario;
	}

	public BufferedReader getBufferedReaderFuncionario() {
		return brfuncionario;
	}

	public BufferedWriter getBufferedWriterTarefas() {
		return bwtarefas;
	}

	public BufferedReader getBufferedReaderTarefas() {
		return brtarefas;
	}


}
