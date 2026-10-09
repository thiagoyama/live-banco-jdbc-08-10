package br.com.fiap.games.view;

import br.com.fiap.games.dao.GameDao;
import br.com.fiap.games.exception.EntidadeNaoEncontradaException;
import br.com.fiap.games.model.Game;

import java.sql.SQLException;

public class PesquisaView {

    public static void main(String[] args) {
        try {
            GameDao dao = new GameDao();
            Game game = dao.pesquisarPorId(1);
            System.out.println(game);
            dao.fecharConexao();
        } catch (SQLException e){
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Código não existe " + e.getMessage());
        }
    }

}
