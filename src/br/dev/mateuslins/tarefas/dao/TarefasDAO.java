package br.dev.mateuslins.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.mateuslins.tarefas.factory.FileFactory;
import br.dev.mateuslins.tarefas.model.Tarefas;

public class TarefasDAO {

    private Tarefas tarefa;

    public TarefasDAO() {}

    public TarefasDAO(Tarefas tarefa) {
        this.tarefa = tarefa;
    }

    public void gravar() {
        FileFactory ff = new FileFactory();
        try (BufferedWriter bw = ff.getBufferedWriterTarefas(true)) {
            bw.write(tarefa.toCSV());
        } catch (IOException erro) {
            erro.printStackTrace();
        }
    }

    public List<Tarefas> listar() {
        List<Tarefas> tarefas = new ArrayList<>();
        FileFactory ff = new FileFactory();

        try (BufferedReader br = ff.getBufferedReaderTarefas()) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    String[] tarefaStr = linha.split(",");
                    if (tarefaStr.length >= 7) {
                        Tarefas t = new Tarefas();
                        t.setTitulo(tarefaStr[0]);
                        t.setDescricao(tarefaStr[1]);
                        t.setDataInicial(tarefaStr[2]);
                        t.setPrazo(tarefaStr[3]);
                        t.setDataFinal(tarefaStr[4]);
                        t.setStatus(tarefaStr[5]);
                        t.setResponsavel(tarefaStr[6]);
                        tarefas.add(t);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tarefas;
    }
}
