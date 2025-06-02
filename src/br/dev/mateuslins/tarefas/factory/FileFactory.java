package br.dev.mateuslins.tarefas.factory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileFactory {
	
	private String arquivo = "C:\\Users\\25132834\\ProjetoTarefasDS1TB\\funcionarios.csv";
	
	private FileWriter fw;
	private BufferedWriter bw;
	
	private FileReader fr;
	private BufferedReader br;
	
	public FileFactory() throws IOException {
		
		//necessario para escrever um arquivo
		fw = new FileWriter(arquivo, true);
		bw = new BufferedWriter(fw);
		
		//necessario para ler um arquivo
		fr = new FileReader(arquivo);
		br = new BufferedReader(fr);
	}

	public BufferedWriter getBufferedWriter() {
		return bw;
	}
	
	public BufferedReader getBufferedReader() {
		return br;
	}
	
}
