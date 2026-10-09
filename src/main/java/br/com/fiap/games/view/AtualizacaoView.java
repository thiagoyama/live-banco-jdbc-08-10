package br.com.fiap.games.view;

import br.com.fiap.games.dao.GameDao;
import br.com.fiap.games.exception.EntidadeNaoEncontradaException;
import br.com.fiap.games.model.Game;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class AtualizacaoView {

    public static void main(String[] args) {
        try {
            GameDao dao = new GameDao();
            Scanner leitor = new Scanner(System.in);
            System.out.println("Digite o código do jogo");
            int codigo = leitor.nextInt();
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
            Game game = new Game(codigo, nome, nota, ano, dataCompra, finalizado);
            dao.atualizar(game);
            System.out.println("Game atualizado!");
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Erro: "  + e.getMessage());
        }
    }

}
