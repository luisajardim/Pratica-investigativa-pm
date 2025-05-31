package br.pm.business;

public abstract class Usuario {
    private String nome;
    private String matricula;
    private PoliticaEmprestimo politica;

    public Usuario(String nome, String matricula, PoliticaEmprestimo politica) {
        this.nome = nome;
        this.matricula = matricula;
        this.politica = politica;
    }

    public String getNome() { return nome; }
    public String getMatricula() { return matricula; }
    public int getPrazoMaximo() { return politica.getPrazoMaximoDias(); }
    public double getMultaPorDia() { return politica.getMultaPorDia(); }
}

