package br.dev.mateuslins.tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	private static String path = "c:\\Users\\25132834\\ProjetoTarefasDS1TB\\tarefas.txt";
	
	public static void main(String[] args) {
		
//		gravarArquivo();
		lerArquivo();

	}
	
	private static void gravarArquivo() {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(path, true);
			bw = new BufferedWriter(fw);

			String novaLinha = "Isso é uma nova linha!\n";
			String novaLinha1 = "Senai Jandira\n";
			String novaLinha2 = "Turma DS1TB\n";

			bw.write(novaLinha);
			bw.write(novaLinha1);
			bw.write(novaLinha2);
			bw.flush();

		} catch (Exception erro) {

			System.out.println(erro.getMessage());
		}

	}

	private static void lerArquivo() {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);

			String linha = br.readLine();
			while (linha != null) {
				String registro[] = linha.split(";");
				System.out.println(" ____________________________________");
				System.out.println("| Nome:    " + registro[0]);
				System.out.println("| Tarefa:  " + registro[1]);
				System.out.println("|____________________________________");

				
				linha = br.readLine();
			}

		} catch (FileNotFoundException erro) {
			System.out.println(erro.getMessage());

		} catch (IOException erro) {
			System.out.println(erro.getMessage());

		} catch (Exception erro) {
			System.out.println(erro.getMessage());

		}
	}

}
