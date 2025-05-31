package br.pm.business;

import java.time.LocalDate;

class Emprestimo {
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;

    public Emprestimo(Livro livro, Usuario usuario, LocalDate dataEmprestimo) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
    }

    public Livro getLivro() { return livro; }
    public Usuario getUsuario() { return usuario; }

    public boolean estaAtrasado(LocalDate dataAtual) {
        return dataEmprestimo.plusDays(usuario.getPrazoMaximo()).isBefore(dataAtual);
    }

    public double calcularMulta(LocalDate dataAtual) {
        if (!estaAtrasado(dataAtual)) return 0.0;
        long diasAtraso = java.time.temporal.ChronoUnit.DAYS.between(
            dataEmprestimo.plusDays(usuario.getPrazoMaximo()), dataAtual);
        return diasAtraso * usuario.getMultaPorDia();
    }
}


