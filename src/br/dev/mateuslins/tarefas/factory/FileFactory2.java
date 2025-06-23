package br.dev.mateuslins.tarefas.factory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileFactory2 {
	
	private String arquivo2 = "C:\\Users\\PC\\Desktop\\projetos\\tarefas.csv";
	
	private FileWriter fw;
	private BufferedWriter bw;
	
	private FileReader fr;
	private BufferedReader br;
	
	public FileFactory2() throws IOException{
		
		fw = new FileWriter(arquivo2, true);
		bw = new BufferedWriter(fw);
		

		fr = new FileReader(arquivo2);
		br = new BufferedReader(fr);
	}
	
	public BufferedWriter getBufferedWriter() {
		return bw;
	}
	
	public BufferedReader getBufferedReader() {
		return br;
	}

}
