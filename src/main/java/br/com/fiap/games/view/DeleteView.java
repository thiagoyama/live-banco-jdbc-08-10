package br.com.fiap.games.view;

import br.com.fiap.games.dao.GameDao;
import br.com.fiap.games.exception.EntidadeNaoEncontradaException;

import java.sql.SQLException;

public class DeleteView {

    public static void main(String[] args) {
        try {
            GameDao dao = new GameDao();
            dao.deletar(1);
            System.out.println("Game removido!");
            dao.fecharConexao();
        } catch (SQLException | EntidadeNaoEncontradaException e) {
            System.err.println(e.getMessage());
        }
    }
}
