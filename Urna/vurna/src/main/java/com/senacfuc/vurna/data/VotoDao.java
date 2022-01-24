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
     * @param eleitor_inscricao
     * @param candidato_inscricao
     * @throws SQLException
     */
    public void registerVote(int eleitor_inscricao, int candidato_inscricao) throws SQLException {
        Connection conn = dbmanager.getConnection();

        String cargo = new CandidatoDao(dbmanager).getCandidato(candidato_inscricao).getCodCargo();
        String query = "INSERT INTO Voto (inscricaoEleitor, inscricaoCandidato, codCargo) VALUES (?, ?, ?);";

        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, eleitor_inscricao);
        statement.setInt(2, candidato_inscricao);
        statement.setString(3, cargo);
        statement.executeUpdate();

        dbmanager.closePreparedStatement(statement);
    }

    /**
     * Registra um voto como branco.
     * 
     * @param eleitor_inscricao 
     * @param cargo
     * @throws SQLException
     */
    public void registerVote(int eleitor_inscricao, String cargo) throws SQLException {
        Connection conn = dbmanager.getConnection();

        String query = "INSERT INTO Voto (inscricaoEleitor, codCargo) VALUES (?, ?);";

        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, eleitor_inscricao);
        statement.setString(2, cargo);
        statement.executeUpdate();

        dbmanager.closePreparedStatement(statement);
    }

    /**
     * Returna a quantidade total de votos registrados em um cargo.
     * 
     * @return Integer
     * @throws SQLException
     */
    public int getTotalVotesCount(String cargo) throws SQLException {
        Connection conn = dbmanager.getConnection();

        String query = "SELECT COUNT(*) FROM Voto WHERE Voto.codCargo = ? AND Voto.inscricaoCandidato IS NOT NULL";

        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, cargo);

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
     * @param inscricao_candidato
     * @return Integer
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

    /**
     * Retorna quantidade de votos brancos.
     * 
     * @return Integer
     * @throws SQLException
     */
    public int getWhiteVotesCount(String cargo) throws SQLException {
        Connection conn = dbmanager.getConnection();

        String query = "SELECT COUNT(*) FROM Voto WHERE Voto.inscricaoCandidato IS NULL AND Voto.codCargo = ?;";
       
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, cargo);

        ResultSet result = statement.executeQuery();
        result.next();

        int votes_count = result.getInt(1);

        dbmanager.closePreparedStatement(statement);
        dbmanager.closeResultSet(result);
        return votes_count;
    }

    /**
     * Retorna a porcentagem de votos que um candidato tem.
     * 
     * @param cargo
     * @param inscricao_candidato
     * @return Integer
     * @throws SQLException
     */
    public int getVotePercentage(String cargo, int inscricao_candidato) throws SQLException {
        double total_votes = getTotalVotesCount(cargo);
        double votes_count = getVotesCount(inscricao_candidato);
        int percentage = (int) (votes_count / total_votes * 100);
        return percentage;
    }

    /**
     * Retorna a porcentagem de votos brancos.
     * 
     * @param cargo
     * @return Integer
     * @throws SQLException
     */
    public int getWhiteVotePercentage(String cargo) throws SQLException {
        double total_votes = getTotalVotesCount(cargo);
        double votes_count = getWhiteVotesCount(cargo);
        int percentage = (int) (votes_count / total_votes * 100);
        return percentage;
    }
}