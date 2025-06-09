package br.dev.mateuslins.tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.dev.mateuslins.tarefas.dao.FuncionarioDAO;
import br.dev.mateuslins.tarefas.model.Funcionario;
import br.dev.mateuslins.tarefas.ui.FrameFuncionario;
import br.dev.mateuslins.tarefas.ui.FrameFuncionarioList;
import br.dev.mateuslins.tarefas.ui.FrameGerenciador;
import br.dev.mateuslins.tarefas.utils.Utils;

public class Main {

	private static String path = "c:\\Users\\25132834\\ProjetoTarefasDS1TB\\tarefas.txt";
	
	public static void main(String[] args) {
		
		new FrameGerenciador();
			
		
		
//		List<String> frutas = new ArrayList<String>();
//		frutas.add("banana");
//		frutas.add("melancia");
//		frutas.add("maçã");
//		frutas.add("uva");
//		frutas.add("ameixa");
		
		//System.out.println(frutas);
		
		//new FrameFuncionario();
		
//		FuncionarioDAO dao = new FuncionarioDAO();
//		List<Funcionario> funcionarios = dao.listar();
//		
//		for(Funcionario f : funcionarios) {
//			System.out.println(f.getNome());
//			System.out.println(f.getCargo());
//			System.out.println(f.getSalario());
//			System.out.println("-----------");
//		}
//		
//		Funcionario f = new Funcionario();
//		f.setNome("Priscila Duarte");
//		f.setCargo("Gerente de Contas");
//		f.setSalario(11989.73);
//		
//		FuncionarioDAO dao = new FuncionarioDAO(f);
//		dao.gravar();
		
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
