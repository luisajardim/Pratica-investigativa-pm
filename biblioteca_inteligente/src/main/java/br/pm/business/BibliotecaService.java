package br.pm.business;

import java.time.LocalDate;
import java.util.*;

public class BibliotecaService {
    private List<Livro> livros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();
    private GerenciadorReservas gerenciadorReservas = new GerenciadorReservas();

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void emprestarLivro(Livro livro, Usuario usuario) {
        if (!livro.isDisponivel()) {
            gerenciadorReservas.adicionarReserva(livro, usuario);
            return;
        }
        livro.setDisponivel(false);
        emprestimos.add(new Emprestimo(livro, usuario, LocalDate.now()));
    }

    public void devolverLivro(Livro livro, LocalDate dataAtual) {
        Optional<Emprestimo> emp = emprestimos.stream()
            .filter(e -> e.getLivro().equals(livro))
            .findFirst();

        if (emp.isPresent()) {
            Emprestimo e = emp.get();
            double multa = e.calcularMulta(dataAtual);

            emprestimos.remove(e);
            livro.setDisponivel(true);

            if (gerenciadorReservas.temReservas(livro)) {
                Usuario proximo = gerenciadorReservas.proximaReserva(livro);
                emprestarLivro(livro, proximo);
            }
        }
    }
}
