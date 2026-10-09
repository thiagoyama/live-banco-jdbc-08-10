package br.com.fiap.games.view;

import br.com.fiap.games.dao.GameDao;
import br.com.fiap.games.model.Game;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class CadastroView {

    public static void main(String[] args) {
        try {
            GameDao dao = new GameDao();
            Scanner leitor = new Scanner(System.in);
            System.out.println("Digite o nome do jogo");
            String nome = leitor.next() + leitor.nextLine();
            System.out.println("Digite a nota");
            double nota = leitor.nextDouble();
            System.out.println("Digite o ano");
            int ano = leitor.nextInt();
            System.out.println("Esta finalizado? s/n");
            boolean finalizado = leitor.next().equals("s");
            System.out.println("Digite a data de compra aaaa-mm-dd");
            LocalDate dataCompra = LocalDate.parse(leitor.next());
            Game game = new Game(nome, nota, ano, dataCompra, finalizado);
            dao.cadastrar(game);
            System.out.println("Game cadastradado!");
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
