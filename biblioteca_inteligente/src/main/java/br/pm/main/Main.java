package br.pm.main;

import br.pm.business.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        BibliotecaService biblioteca = new BibliotecaService();

        Livro livro1 = new Livro("Java: Como Programar", "Deitel", "123456");
        Livro livro2 = new Livro("Clean Code", "Robert C. Martin", "654321");

        Usuario aluno = new Aluno("João", "2021001");
        Usuario professor = new Professor("Maria", "P2022001");

        biblioteca.cadastrarLivro(livro1);
        biblioteca.cadastrarLivro(livro2);
        biblioteca.cadastrarUsuario(aluno);
        biblioteca.cadastrarUsuario(professor);

        System.out.println("Tentando emprestar livro1 para aluno...");
        biblioteca.emprestarLivro(livro1, aluno);
        System.out.println("Livro1 emprestado para aluno? " + !livro1.isDisponivel());

        System.out.println("Tentando emprestar livro1 para professor (deve entrar em reserva)...");
        biblioteca.emprestarLivro(livro1, professor);

        System.out.println("Devolvendo livro1 após 10 dias...");
        biblioteca.devolverLivro(livro1, LocalDate.now().plusDays(10));
        System.out.println("Livro1 disponível? " + livro1.isDisponivel());

        System.out.println("Tentando emprestar livro2 para professor...");
        biblioteca.emprestarLivro(livro2, professor);
        System.out.println("Livro2 emprestado para professor? " + !livro2.isDisponivel());
    }
}