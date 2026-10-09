package br.com.fiap.games.view;

import br.com.fiap.games.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) {
        try {
            //Abrir uma conexão com o banco de dados
//         Connection churros = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl",
//                    "pf0392", "izumi25");
            Connection churros = ConnectionFactory.getConnection();
            System.out.println("Conectado!");
            churros.close();
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
