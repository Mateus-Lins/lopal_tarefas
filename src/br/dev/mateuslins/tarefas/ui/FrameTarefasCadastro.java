package br.dev.mateuslins.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.List;

import javax.swing.JButton;	
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.dev.mateuslins.tarefas.dao.FuncionarioDAO;
import br.dev.mateuslins.tarefas.dao.TarefasDAO;
import br.dev.mateuslins.tarefas.model.Funcionario;
import br.dev.mateuslins.tarefas.model.Status;
import br.dev.mateuslins.tarefas.model.Tarefas;

public class FrameTarefasCadastro {

	private JLabel labelTitulo;
	private JTextField txtTitulo;
	private JLabel labelDescricao;
	private JTextField txtDescricao;
	private JLabel labelDataInicial;
	private JTextField txtDataIncial;
	private JLabel labelDataDeConclusao;
	private JTextField txtDataFinal;
	private JLabel labelPrazo;
	private JTextField txtPrazo;
	private JLabel labelStatus;
	private JComboBox<Status> cmbStatus;
	private JLabel labelResponsavel;
	private JComboBox cmbResponsavel;
	private JButton btnSalvar;
	private JButton btnSair;

	public FrameTarefasCadastro(JDialog dialog) {
		criarTela(dialog);
	}

	public void criarTela(JDialog dialog) {
		JDialog tela = new JDialog(dialog, true);
		tela.setTitle("Cadastro de Tarefas");
		tela.setSize(400, 600);
		tela.setResizable(false);
		tela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(dialog);

		labelTitulo = new JLabel("Título:");
		labelTitulo.setBounds(10, 10, 200, 30);
		txtTitulo = new JTextField();
		txtTitulo.setBounds(10, 40, 365, 30);

		labelDescricao = new JLabel("Descrição:");
		labelDescricao.setBounds(10, 75, 200, 30);
		txtDescricao = new JTextField();
		txtDescricao.setBounds(10, 105, 365, 30);

		labelDataInicial = new JLabel("Data Inicial:");
		labelDataInicial.setBounds(10, 140, 200, 30);
		txtDataIncial = new JTextField();
		txtDataIncial.setBounds(10, 170, 365, 30);

		labelPrazo = new JLabel("Prazo:");
		labelPrazo.setBounds(10, 205, 150, 30);
		txtPrazo = new JTextField();
		txtPrazo.setBounds(10, 235, 365, 30);

		labelDataDeConclusao = new JLabel("Data conclusão:");
		labelDataDeConclusao.setBounds(10, 265, 150, 30);
		txtDataFinal = new JTextField();
		txtDataFinal.setBounds(10, 295, 365, 30);

		labelStatus = new JLabel("Status:");
		labelStatus.setBounds(10, 325, 150, 30);
		cmbStatus = new JComboBox<>(Status.values());
		cmbStatus.setBounds(10, 355, 150, 30);

		labelResponsavel = new JLabel("Responsável:");
		labelResponsavel.setBounds(10, 385, 150, 30);

		cmbResponsavel = new JComboBox<>();
		cmbResponsavel.setBounds(10, 415, 150, 30);

		FuncionarioDAO dao = new FuncionarioDAO();
		List<Funcionario> funcionario = dao.listar();

		for (Funcionario f : funcionario) {
			cmbResponsavel.addItem(f.getNome()); // Adiciona diretamente o nome de cada funcionário
		}

		// Define o primeiro item como selecionado por padrão
		if (funcionario.size() > 0) {
			cmbResponsavel.setSelectedIndex(0);
		}

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 465, 175, 40);
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(190, 465, 175, 40);
		

		Container painel = tela.getContentPane();
		painel.add(labelTitulo);
		painel.add(txtTitulo);
		painel.add(labelDescricao);
		painel.add(txtDescricao);
		painel.add(labelDataInicial);
		painel.add(txtDataIncial);
		painel.add(labelPrazo);
		painel.add(txtPrazo);
		painel.add(labelDataDeConclusao);
		painel.add(txtDataFinal);
		painel.add(labelStatus);
		painel.add(cmbStatus);
		painel.add(labelResponsavel);
		painel.add(cmbResponsavel);
		painel.add(btnSalvar);
		painel.add(btnSair);

		txtDataIncial.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				atualizarDataConclusao();
			}
		});
		txtPrazo.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				atualizarDataConclusao();
			}
		});

		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int resposta = JOptionPane.showConfirmDialog(tela, "Confirma a saída do sistema?");
				
				if (resposta == 0) {
					tela.dispose();
				}
				
			}
		});
		
		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
				
				String responsavelSelecionado = (String) cmbResponsavel.getSelectedItem();

				// Verificar se há um responsável selecionado
				if (responsavelSelecionado == null || responsavelSelecionado.isEmpty()) {
					JOptionPane.showMessageDialog(tela, "Selecione um responsável!", "Aviso",
							JOptionPane.WARNING_MESSAGE);
					return;
				}

				Funcionario f = new Funcionario();
				// Este condigo, pega o status selecionado
				Status statusEscolhido = (Status) cmbStatus.getSelectedItem();

				// Criando Tarefa
				Tarefas t = new Tarefas(txtTitulo.getText(), txtDescricao.getText(), txtDataIncial.getText(),
						txtPrazo.getText(), txtDataFinal.getText(), statusEscolhido.name(),
						responsavelSelecionado);

				// Ler data inicial e prazo
				String dataInicialStr = txtDataIncial.getText();
				int prazoDias = Integer.parseInt(txtPrazo.getText());

				// Converter e somar prazo usando LocalDate
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate dataInicial = LocalDate.parse(dataInicialStr, formatter);
				LocalDate dataConclusao = dataInicial.plusDays(prazoDias);
				String dataConclusaoStr = dataConclusao.format(formatter);
				txtDataFinal.setText(dataConclusaoStr);

				TarefasDAO dao = new TarefasDAO(t);
				dao.gravar();

				JOptionPane.showMessageDialog(tela, txtTitulo.getText() + " gravado com sucesso", "Sucesso !!!",
						JOptionPane.INFORMATION_MESSAGE);
				limparFormulario();
				
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(tela, "Por favor, corrija os campos preenchidos incorretamente", "ERRO",
					JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
			
		});

		tela.setVisible(true);

	}

	private void atualizarDataConclusao() {
		String dataInicialStr = txtDataIncial.getText().trim();
		String prazoStr = txtPrazo.getText().trim();

		try {
			if (dataInicialStr.isEmpty() || prazoStr.isEmpty())
				return;

			int prazoDias = Integer.parseInt(prazoStr);

			DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendValue(ChronoField.DAY_OF_MONTH)
					.appendLiteral('/').appendValue(ChronoField.MONTH_OF_YEAR).appendLiteral('/')
					.appendValue(ChronoField.YEAR, 4).toFormatter();

			LocalDate dataInicial = LocalDate.parse(dataInicialStr, formatter);
			LocalDate dataConclusao = dataInicial.plusDays(prazoDias);
			String dataConclusaoStr = dataConclusao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			txtDataFinal.setText(dataConclusaoStr);
		} catch (Exception e) {
			txtDataFinal.setText("Data inválida");
		}
	}

	private void limparFormulario() {
		txtTitulo.setText(null);
		txtDescricao.setText(null);
		txtDataIncial.setText(null);
		txtPrazo.setText(null);
		txtDataFinal.setText(null);
		cmbResponsavel.setSelectedIndex(0);
		cmbStatus.setSelectedIndex(0);
		txtTitulo.requestFocus();
	}

}