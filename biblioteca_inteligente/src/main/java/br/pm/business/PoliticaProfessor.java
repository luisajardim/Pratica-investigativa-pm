package br.pm.business;

class PoliticaProfessor implements PoliticaEmprestimo {
    public int getPrazoMaximoDias() { return 14; }
    public double getMultaPorDia() { return 1.5; }
}
