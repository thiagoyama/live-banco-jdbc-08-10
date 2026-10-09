package br.com.fiap.games.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//responsavel por criar as conexões com o banco de dados
public class ConnectionFactory {

    //modificador static -> o método é da classe e não do objeto
    public static Connection getConnection() throws SQLException {
            Connection connection = DriverManager
                    .getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl",
                            "pf0392", "izumi25");
            return connection;
    }

}
