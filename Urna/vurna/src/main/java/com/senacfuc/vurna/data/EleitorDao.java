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
     * @param inscricao
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
     * @param inscricao
     * @return Boolean
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
     * Verifica se o eleitor ja votou atraves de sua inscricao.
     * 
     * @param inscricao
     * @return Boolean
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

    /**
     * Verifica se o eleitor ja tem voto em um cargo.
     * 
     * @param cargo
     * @param inscricao_eleitor
     * @return Boolean
     * @throws SQLException
     */
    public boolean jaVotou(int inscricao_eleitor, String cargo) throws SQLException {
        Connection conn = dbmanager.getConnection();

        String query = "SELECT COUNT(*) FROM Voto WHERE Voto.codCargo = ? AND Voto.inscricaoEleitor = ?;";

        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, cargo);
        statement.setInt(2, inscricao_eleitor);

        ResultSet result = statement.executeQuery();
        result.next();

        boolean voted = result.getInt(1) > 0;

        dbmanager.closePreparedStatement(statement);
        dbmanager.closeResultSet(result);

        return voted;
    }
}