package br.dev.mateuslins.tarefas.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrameGerenciador {
	
	private JLabel labelTitulo;
	private JButton btnFuncionarios;
	private JButton btnTarefas;
	
	
	public FrameGerenciador() {
		criarTela();
	}
	
	private void criarTela() {
		
		JFrame tela = new JFrame();
		tela.setSize(600, 300);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		tela.setTitle("Gerenciador de Tarefas");
		tela.setResizable(false);
		
		Container painel = tela.getContentPane();
		
//		labelTitulo = new JLabel("Gerenciador de Tarefas");
//		labelTitulo.setFont(new Font("Arial", Font.BOLD, 25));
//		labelTitulo.setForeground(Color.BLUE);
//		labelTitulo.setBounds(20, 20, 400, 50);
		
		btnFuncionarios = new JButton("Funcionários");
		btnFuncionarios.setBounds(50, 100, 200, 50);
		
		btnFuncionarios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameFuncionarioList();
				
			}
		});
	
		btnTarefas = new JButton("Tarefas");
		btnTarefas.setBounds(300, 100, 200, 50);
		
		btnTarefas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameTarefasList(tela);
				
			}
		});
		
	
//		painel.add(labelTitulo);
		painel.add(btnFuncionarios);
		painel.add(btnTarefas);
		
		tela.setVisible(true);
	
	}
	
}
