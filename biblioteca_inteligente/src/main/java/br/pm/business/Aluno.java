package br.pm.business;

public class Aluno extends Usuario {
    public Aluno(String nome, String matricula) {
        super(nome, matricula, new PoliticaAluno());
    }
}


