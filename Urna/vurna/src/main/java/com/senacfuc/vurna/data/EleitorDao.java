package com.senacfuc.vurna.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.senacfuc.vurna.objs.Eleitor;
import com.senacfuc.vurna.utils.DbManager;

public class EleitorDao {
    private DbManager dbmanager;

    public EleitorDao(DbManager dbmanager) {
        this.dbmanager = dbmanager;
    }

    /**
     * Retorna dados de um eleitor especifico.
     * 
     * @param inscricao O numero da inscricao do eleitor.
     * @return Eleitor
     * @throws SQLException
     */
    public Eleitor getEleitor(int inscricao) throws SQLException {
        Connection conn = dbmanager.getConnection();

        String query = "SELECT * FROM Eleitor WHERE Eleitor.inscricao = ?";

        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, inscricao);

        ResultSet result = statement.executeQuery();
        result.next();

        Eleitor eleitor = new Eleitor();
        eleitor.setNome(result.getString("nome"));
        eleitor.setInscricao(result.getInt("inscricao"));

        dbmanager.closePreparedStatement(statement);
        dbmanager.closeResultSet(result);

        return eleitor;
    }

    /**
     * Retorna todos os eleitores.
     * 
     * @return List<Eleitor>
     * @throws SQLException
     */
    public List<Eleitor> getAllEleitores() throws SQLException {
        Connection conn = dbmanager.getConnection();

        String query = "SELECT * FROM Eleitor";
        PreparedStatement statement = conn.prepareStatement(query);

        ResultSet result = statement.executeQuery();

        ArrayList<Eleitor> eleitores = new ArrayList<Eleitor>();
        while (result.next()) {
            Eleitor eleitor = new Eleitor();
            eleitor.setNome(result.getString("nome"));
            eleitor.setInscricao(result.getInt("inscricao"));
            eleitores.add(eleitor);
        }

        dbmanager.closePreparedStatement(statement);
        dbmanager.closeResultSet(result);

        return eleitores;
    }

    /**
     * Verifica se o eleitor esta cadastrado na database.
     * 
     * @param inscricao O numero de inscricao do eleitor.
     * @return true | false
     * @throws SQLException
     */
    public boolean existe(int inscricao) throws SQLException {
        Connection conn = dbmanager.getConnection();

        String query = "SELECT COUNT(*) FROM Eleitor WHERE Eleitor.inscricao = ?";

        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, inscricao);

        ResultSet result = statement.executeQuery();
        result.next();

        boolean exists = result.getInt(1) > 0;

        dbmanager.closePreparedStatement(statement);
        dbmanager.closeResultSet(result);

        return exists;
    }

    /**
     * Verifica se o eleitor ja votou.
     * 
     * @param inscricao O numero de inscricao do eleitor.
     * @return true | false
     * @throws SQLException
     */
    public boolean jaVotou(int inscricao) throws SQLException {
        Connection conn = dbmanager.getConnection();

        String query = "SELECT COUNT(*) FROM Voto WHERE Voto.inscricaoEleitor = ?";

        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, inscricao);

        ResultSet result = statement.executeQuery();
        result.next();

        CargoDao cargos = new CargoDao(dbmanager);
        int cargos_count = cargos.getCargosCount();

        // Verifica se a quantidade de votos bate com a quantidade de cargos.
        boolean voted = result.getInt(1) == cargos_count;

        dbmanager.closePreparedStatement(statement);
        dbmanager.closeResultSet(result);

        return voted;
    }

    public boolean jaVotou(int inscricao_eleitor, int inscricao_candidato) throws SQLException {
        Connection conn = dbmanager.getConnection();

        String query = "SELECT COUNT(*) FROM Voto WHERE Voto.inscricaoEleitor = ? AND Voto.inscricaoCandidato = ?";

        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, inscricao_eleitor);

        ResultSet result = statement.executeQuery();
        result.next();

        boolean voted = result.getInt(1) > 0;

        dbmanager.closePreparedStatement(statement);
        dbmanager.closeResultSet(result);

        return voted;
    }
}