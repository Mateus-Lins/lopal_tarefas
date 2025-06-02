package br.dev.mateuslins.tarefas.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.dev.mateuslins.tarefas.dao.FuncionarioDAO;
import br.dev.mateuslins.tarefas.model.Funcionario;

public class FrameFuncionarioList {
	
	private JLabel labelTitulo;
	private JButton btnCadastro;
	private JTable tabelaFuncionarios;
	private JScrollPane scrollFuncionarios;
	private DefaultTableModel modelFuncionarios;
	private String[] colunas = {"CÓDIGO", "NOME", "CARGO"};
	
	public FrameFuncionarioList() {
		criarTela();
	}
	
	private void criarTela() {
		
		JFrame tela = new JFrame();
		tela.setSize(500, 500);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		tela.setTitle("Lista de Funcionários");
		tela.setResizable(false);
		
		Container painel = tela.getContentPane();
		
		labelTitulo = new JLabel("Cadastro de Funcionários");
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 25));
		labelTitulo.setForeground(Color.BLUE);
		labelTitulo.setBounds(10, 10, 300, 40);
		
		//criação da tabela
		modelFuncionarios = new DefaultTableModel(colunas, 5) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		tabelaFuncionarios = new JTable(modelFuncionarios);
		tabelaFuncionarios.getTableHeader().setReorderingAllowed(false);
		scrollFuncionarios = new JScrollPane(tabelaFuncionarios);
		scrollFuncionarios.setBounds(10, 60, 460, 300);
		
		carregarDados();
		
		btnCadastro = new JButton("Cadastrar");
		btnCadastro.setBounds(10, 380, 200, 40);
		
		btnCadastro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new FrameFuncionario(tela);
				carregarDados();
				
			}
		});
		
		
		painel.add(labelTitulo);
		painel.add(scrollFuncionarios);
		painel.add(btnCadastro);
		
		tela.setVisible(true);
		
	}
	
	private void carregarDados() {
		FuncionarioDAO dao = new FuncionarioDAO();
		List<Funcionario> funcionarios = dao.listar();
		
		Object[][] dados = new Object[funcionarios.size()][3];
		
		int i = 0;
		for (Funcionario f : funcionarios) {
			dados[i][0] = f.getMatricula();
			dados[i][1] = f.getNome();
			dados[i][2] = f.getCargo();
			i++;
		}
		
		modelFuncionarios.setDataVector(dados, colunas);
	}

}
