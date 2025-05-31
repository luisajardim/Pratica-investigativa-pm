package br.pm.business;

class PoliticaAluno implements PoliticaEmprestimo {
    public int getPrazoMaximoDias() { return 7; }
    public double getMultaPorDia() { return 1.5; }
}
