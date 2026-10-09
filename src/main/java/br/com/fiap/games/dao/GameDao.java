package br.com.fiap.games.dao;

import br.com.fiap.games.exception.EntidadeNaoEncontradaException;
import br.com.fiap.games.factory.ConnectionFactory;
import br.com.fiap.games.model.Game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GameDao {

    private Connection conexao;

    public GameDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void cadastrar(Game game) throws SQLException {
        //Criar o comando SQL
        PreparedStatement stmt = conexao.prepareStatement(
                "insert into tb_game (cd_game, nm_game, nr_nota, nr_ano, dt_compra, st_finalizado) " +
                        "values (sq_tb_game.nextval, ?, ? , ?, ?, ?)");
        //Setar os valores do comando SQL
        stmt.setString(1, game.getNome());
        stmt.setDouble(2, game.getNota());
        stmt.setInt(3, game.getAno());
        stmt.setObject(4, game.getDataCompra());
        stmt.setBoolean(5, game.isFinalizado());
        //Executar o comando SQL no banco
        stmt.executeUpdate();
    }

    public Game pesquisarPorId(int id) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stmt = conexao.prepareStatement("select * from tb_game where cd_game = ?");
        stmt.setInt(1, id);
        ResultSet resultSet = stmt.executeQuery();
        if (!resultSet.next()){
            throw new EntidadeNaoEncontradaException("Jogo não encontrado");
        }
        //Pegar os dados do resultset e colocar em um objeto Game
        return getGame(resultSet);
    }

    private static Game getGame(ResultSet resultSet) throws SQLException {
        int codigo = resultSet.getInt("cd_game");
        String nome = resultSet.getString("nm_game");
        double nota = resultSet.getDouble("nr_nota");
        int ano = resultSet.getInt("nr_ano");
        LocalDate dataCompra = resultSet.getObject("dt_compra", LocalDate.class);
        boolean finalizado = resultSet.getBoolean("st_finalizado");
        return new Game(codigo, nome, nota, ano, dataCompra, finalizado);
    }

    public List<Game> listar() throws SQLException {
        PreparedStatement stmt = conexao.prepareStatement("select * from tb_game");
        ResultSet resultSet = stmt.executeQuery();
        List<Game> lista = new ArrayList<>();
        while (resultSet.next()){
            lista.add(getGame(resultSet));
        }
        return lista;
    }

    public void atualizar(Game game) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stmt = conexao.prepareStatement("update tb_game set nm_game = ? " +
                ", nr_nota = ?, nr_ano = ?, dt_compra = ?, st_finalizado = ? where cd_game = ?");
        stmt.setString(1, game.getNome());
        stmt.setDouble(2, game.getNota());
        stmt.setInt(3, game.getAno());
        stmt.setObject(4, game.getDataCompra());
        stmt.setBoolean(5, game.isFinalizado());
        stmt.setInt(6, game.getCodigo());
        int linhas = stmt.executeUpdate();
        //verifica a quantidade de linhas atualizadas
        if (linhas == 0)
            throw new EntidadeNaoEncontradaException("Não tem game para atualizar!");
    }

    public void deletar(int id) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stmt = conexao.prepareStatement("delete from tb_game where cd_game = ?");
        stmt.setInt(1, id);
        int linhas = stmt.executeUpdate();
        if (linhas == 0)
            throw new EntidadeNaoEncontradaException("Id não encontrado para remoção");
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }

}
