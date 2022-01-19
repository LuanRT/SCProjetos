package com.senacfuc.vurna.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbManager {
    private final String url;
    private final String user;
    private final String password;
    private Connection connection;

    public DbManager(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    /**
     * Abre conexao com o db.
     * @return Connection
     * @throws SQLException
     */
    public Connection connect() throws SQLException {
        this.connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    /**
     * Retorna uma referencia a conexao com o db.
     * @return Connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Fecha conexao com o db.
     * @throws SQLException
     */
    public void disconnect() throws SQLException {
        connection.close();
    }
    
     /**
     * Fecha o objeto de resultados na database.
     * 
     * @param  rs
     * @throws SQLException
     */
    public void closeResultSet(ResultSet rs) throws SQLException {
        if (rs != null) rs.close();
    }

     /**
     * Fecha o objeto de declaracoes na database.
     * 
     * @param ps
     * @throws SQLException
     */
    public void closePreparedStatement(PreparedStatement ps) throws SQLException {
        if (ps != null) ps.close();
    }
}