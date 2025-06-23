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
    private JTextField txtDataInicial;
    private JLabel labelDataFinal;
    private JTextField txtDataFinal;
    private JLabel labelPrazo;
    private JTextField txtPrazo;
    private JLabel labelStatus;
    private JComboBox<Status> cmbStatus;
    private JLabel labelResponsavel;
    private JComboBox<String> cmbResponsavel;
    private JButton btnSalvar;

    public FrameTarefasCadastro(JFrame frame) {
        criarTela(frame);
    }

    public void criarTela(JFrame frame) {
        JDialog tela = new JDialog(frame, true);
        tela.setTitle("Cadastro de Tarefas");
        tela.setSize(400, 600);
        tela.setResizable(false);
        tela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        tela.setLayout(null);
        tela.setLocationRelativeTo(frame);

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
        txtDataInicial = new JTextField();
        txtDataInicial.setBounds(10, 170, 365, 30);

        labelPrazo = new JLabel("Prazo (dias):");
        labelPrazo.setBounds(10, 205, 150, 30);
        txtPrazo = new JTextField();
        txtPrazo.setBounds(10, 235, 365, 30);

        labelDataFinal = new JLabel("Data conclusão:");
        labelDataFinal.setBounds(10, 265, 150, 30);
        txtDataFinal = new JTextField();
        txtDataFinal.setBounds(10, 295, 365, 30);
        txtDataFinal.setEditable(false);

        labelStatus = new JLabel("Status:");
        labelStatus.setBounds(10, 325, 150, 30);
        cmbStatus = new JComboBox<>(Status.values());
        cmbStatus.setBounds(10, 355, 150, 30);

        labelResponsavel = new JLabel("Responsável:");
        labelResponsavel.setBounds(10, 385, 150, 30);

        cmbResponsavel = new JComboBox<>();
        cmbResponsavel.setBounds(10, 415, 200, 30);

        FuncionarioDAO dao = new FuncionarioDAO();
        List<Funcionario> funcionarios = dao.listar();

        for (Funcionario f : funcionarios) {
            cmbResponsavel.addItem(f.getNome());
        }

        if (funcionarios.size() > 0) {
            cmbResponsavel.setSelectedIndex(0);
        }

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(10, 465, 175, 40);

        Container painel = tela.getContentPane();
        painel.add(labelTitulo);
        painel.add(txtTitulo);
        painel.add(labelDescricao);
        painel.add(txtDescricao);
        painel.add(labelDataInicial);
        painel.add(txtDataInicial);
        painel.add(labelPrazo);
        painel.add(txtPrazo);
        painel.add(labelDataFinal);
        painel.add(txtDataFinal);
        painel.add(labelStatus);
        painel.add(cmbStatus);
        painel.add(labelResponsavel);
        painel.add(cmbResponsavel);
        painel.add(btnSalvar);

        // Eventos para atualizar a data de conclusão
        txtDataInicial.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                atualizarDataConclusao();
            }
        });

        txtPrazo.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                atualizarDataConclusao();
            }
        });

        // Evento do botão Salvar
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarTarefa(tela);
            }
        });

        tela.setVisible(true);
    }

    private void atualizarDataConclusao() {
        String dataInicialStr = txtDataInicial.getText().trim();
        String prazoStr = txtPrazo.getText().trim();

        try {
            if (dataInicialStr.isEmpty() || prazoStr.isEmpty()) {
                txtDataFinal.setText("");
                return;
            }

            int prazoDias = Integer.parseInt(prazoStr);

            DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                    .appendValue(ChronoField.DAY_OF_MONTH)
                    .appendLiteral('/')
                    .appendValue(ChronoField.MONTH_OF_YEAR)
                    .appendLiteral('/')
                    .appendValue(ChronoField.YEAR, 4)
                    .toFormatter();

            LocalDate dataInicial = LocalDate.parse(dataInicialStr, formatter);
            LocalDate dataFinal = dataInicial.plusDays(prazoDias);
            String dataFinalStr = dataFinal.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            txtDataFinal.setText(dataFinalStr);
        } catch (Exception e) {
            txtDataFinal.setText("Data inválida");
        }
    }

    private void salvarTarefa(JDialog tela) {
        String titulo = txtTitulo.getText().trim();
        String descricao = txtDescricao.getText().trim();
        String dataInicial = txtDataInicial.getText().trim();
        String prazo = txtPrazo.getText().trim();
        String dataFinal = txtDataFinal.getText().trim();
        Status status = (Status) cmbStatus.getSelectedItem();
        String responsavel = (String) cmbResponsavel.getSelectedItem();

        if (titulo.isEmpty() || descricao.isEmpty() || dataInicial.isEmpty() ||
                prazo.isEmpty() || dataFinal.isEmpty() || responsavel == null) {
            JOptionPane.showMessageDialog(tela, "Preencha todos os campos!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Tarefas tarefa = new Tarefas(
                titulo, descricao, dataInicial, prazo, dataFinal, status.name(), responsavel
        );

        TarefasDAO dao = new TarefasDAO(tarefa);
        dao.gravar();

        JOptionPane.showMessageDialog(tela, "Tarefa gravada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        limparFormulario();
    }

    private void limparFormulario() {
        txtTitulo.setText("");
        txtDescricao.setText("");
        txtDataInicial.setText("");
        txtPrazo.setText("");
        txtDataFinal.setText("");
        cmbStatus.setSelectedIndex(0);
        cmbResponsavel.setSelectedIndex(0);
        txtTitulo.requestFocus();
    }
}
