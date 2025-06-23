package br.dev.mateuslins.tarefas.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.dev.mateuslins.tarefas.dao.TarefasDAO;
import br.dev.mateuslins.tarefas.model.Tarefas;

public class FrameTarefasList {

	private JTable tabelaTarefas;
	private DefaultTableModel modelTarefas;
	private JScrollPane scrollTarefas;
	private JButton btnNovaTarefa;
	private JButton btnSair;
	private String[] colunas = { "CÓDIGO", "TAREFA", "RESPONSÁVEL" };
	
	public FrameTarefasList(JFrame FrameGerenciador) {
		criarTela(FrameGerenciador);
	}

	public void criarTela(JFrame FrameGerenciador) {

		
		JDialog tela = new JDialog(FrameGerenciador, true);
		Dimension tamanho = new Dimension();
		tamanho.setSize(500, 420);
		tela.setSize(tamanho);
		tela.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		tela.setTitle("Lista de Tarefas");
		tela.setLayout(null);
		tela.setLocationRelativeTo(FrameGerenciador);
		tela.setResizable(false);

		modelTarefas = new DefaultTableModel(colunas, 5) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		tabelaTarefas = new JTable(modelTarefas);
		tabelaTarefas.getTableHeader().setReorderingAllowed(false);
		scrollTarefas = new JScrollPane(tabelaTarefas);
		scrollTarefas.setBounds(10, 20, 460, 300);

		carregarDados();
		
		btnNovaTarefa = new JButton("Nova Tarefa");
		btnNovaTarefa.setBounds(10, 330, 180, 40);

		btnNovaTarefa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new FrameTarefasCadastro(tela);
				carregarDados();

			}
		});

		btnSair = new JButton("Sair");
		btnSair.setBounds(200, 330, 180, 40);

		btnSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				tela.dispose();
				carregarDados();

			}
		});

		Container painel = tela.getContentPane();
		painel.add(scrollTarefas);
		painel.add(btnNovaTarefa);
		painel.add(btnSair);

		tela.setVisible(true);

	}

	private void carregarDados() {
		TarefasDAO dao = new TarefasDAO();
		List<Tarefas> tarefas = dao.listar();

		Object[][] dados = new Object[tarefas.size()][3];

		int i = 0;
		for (Tarefas t : tarefas) {
			dados[i][0] = t.getCodigo();
			dados[i][1] = t.getTitulo();
			dados[i][2] = t.getResponsavel();
			i++;
		}

		modelTarefas.setDataVector(dados, colunas);
	}
}