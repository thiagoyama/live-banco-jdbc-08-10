package br.com.fiap.games.view;

import br.com.fiap.games.dao.GameDao;
import br.com.fiap.games.model.Game;
import java.sql.SQLException;
import java.util.List;

public class ListagemView {

    public static void main(String[] args) {
        try {
            GameDao dao = new GameDao();
            List<Game> lista = dao.listar();
            for (Game game : lista)
                System.out.println(game);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}
