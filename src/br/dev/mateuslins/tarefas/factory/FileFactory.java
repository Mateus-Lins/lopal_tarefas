package br.dev.mateuslins.tarefas.factory;

import java.io.*;

public class FileFactory {

    private String arquivoTarefas = "C:\\Users\\PC\\Desktop\\projetos\\tarefas.csv";
    private String arquivoFuncionarios = "C:\\Users\\PC\\Desktop\\projetos\\funcionarios.csv";

    // Escrita de tarefas
    public BufferedWriter getBufferedWriterTarefas(boolean append) throws IOException {
        return new BufferedWriter(new FileWriter(arquivoTarefas, append));
    }

    // Leitura de tarefas
    public BufferedReader getBufferedReaderTarefas() throws IOException {
        return new BufferedReader(new FileReader(arquivoTarefas));
    }

    // Escrita de funcionários
    public BufferedWriter getBufferedWriterFuncionario(boolean append) throws IOException {
        return new BufferedWriter(new FileWriter(arquivoFuncionarios, append));
    }

    // Leitura de funcionários
    public BufferedReader getBufferedReaderFuncionario() throws IOException {
        return new BufferedReader(new FileReader(arquivoFuncionarios));
    }
}
