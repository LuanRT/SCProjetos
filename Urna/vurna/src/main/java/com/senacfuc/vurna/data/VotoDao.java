package com.senacfuc.vurna.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.senacfuc.vurna.utils.DbManager;

public class VotoDao {
    private DbManager dbmanager;

    public VotoDao(DbManager dbmanager) {
        this.dbmanager = dbmanager;
    }

    /**
     * Registra o voto do eleitor.
     * 
     * @param eleitor_inscricao Numero de inscricao do eleitor.
     * @param candidato_inscricao Numero de inscricao do candidato.
     * @throws SQLException
     */
    public void registraVoto(int eleitor_inscricao, int candidato_inscricao) throws SQLException {
        Connection conn = dbmanager.getConnection();

        String query = "INSERT INTO Voto (inscricaoEleitor, inscricaoCandidato) VALUES (?, ?);";

        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, eleitor_inscricao);
        statement.setInt(2, candidato_inscricao);
        statement.executeUpdate();

        dbmanager.closePreparedStatement(statement);
    }

    /**
     * Returna a quantidade total de votos registrados.
     * 
     * @return Integer
     * @throws SQLException
     */
    public int getTotalVotesCount() throws SQLException {
        Connection conn = dbmanager.getConnection();

        String query = "SELECT COUNT(*) FROM Voto;";
        PreparedStatement statement = conn.prepareStatement(query);

        ResultSet result = statement.executeQuery();
        result.next();

        int votes_count = result.getInt(1);

        dbmanager.closePreparedStatement(statement);
        dbmanager.closeResultSet(result);

        return votes_count;
    }

    /**
     * Retorna a quantidade de votos que um candidato recebeu.
     * 
     * @param inscricao_candidato Numero de inscricao do candidato.
     * @return
     * @throws SQLException
     */
    public int getVotesCount(int inscricao_candidato) throws SQLException {
        Connection conn = dbmanager.getConnection();

        String query = "SELECT COUNT(*) FROM Voto WHERE Voto.inscricaoCandidato = ?;";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, inscricao_candidato);

        ResultSet result = statement.executeQuery();
        result.next();

        int votes_count = result.getInt(1);

        dbmanager.closePreparedStatement(statement);
        dbmanager.closeResultSet(result);
        return votes_count;
    }
}