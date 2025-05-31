package br.pm.business;

import java.util.*;

public class GerenciadorReservas {
    private Map<Livro, Queue<Usuario>> reservas = new HashMap<>();

    public void adicionarReserva(Livro livro, Usuario usuario) {
        reservas.computeIfAbsent(livro, k -> new LinkedList<>()).add(usuario);
    }

    public Usuario proximaReserva(Livro livro) {
        Queue<Usuario> fila = reservas.get(livro);
        if (fila == null || fila.isEmpty()) return null;

        Usuario proximo = fila.poll();
        if (fila.isEmpty()) {
            reservas.remove(livro);
        }
        return proximo;
    }

    public boolean temReservas(Livro livro) {
        return reservas.containsKey(livro) && !reservas.get(livro).isEmpty();
    }
}
