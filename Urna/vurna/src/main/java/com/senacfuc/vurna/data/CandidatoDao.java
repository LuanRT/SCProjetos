package com.senacfuc.vurna.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.senacfuc.vurna.objs.Candidato;
import com.senacfuc.vurna.utils.DbManager;

public class CandidatoDao {
    private DbManager dbmanager;

    public CandidatoDao(DbManager dbmanager) {
        this.dbmanager = dbmanager;
    }

    /**
     * Retorna um candidato.
     * 
     * @param inscricao Numero de inscricao do candidato.
     * @return Candidato
     * @throws SQLException
     */
    public Candidato getCandidato(int inscricao) throws SQLException {
        Connection conn = dbmanager.getConnection();

        String query = "SELECT * FROM Candidato WHERE Candidato.inscricao = ?";

        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, inscricao);

        ResultSet result = statement.executeQuery();
        result.next();

        Candidato candidato = new Candidato();
        candidato.setNome(result.getString("name"));
        candidato.setInscricao(result.getInt("inscricao"));
        candidato.setCodPartido(result.getString("codPartido"));
        candidato.setCodCargo(result.getString("codCargo"));

        dbmanager.closePreparedStatement(statement);
        dbmanager.closeResultSet(result);

        return candidato;
    }

    /**
     * Retorna todos os candidatos disponiveis.
     * 
     * @return List<Candidato>
     * @throws SQLException
     */
    public List<Candidato> getAllCandidatos() throws SQLException {
        Connection conn = dbmanager.getConnection();

        String query = "SELECT * FROM Candidato";

        PreparedStatement statement = conn.prepareStatement(query);
        ResultSet result = statement.executeQuery();

        List<Candidato> candidatos = new ArrayList<Candidato>();

        while (result.next()) {
            Candidato candidato = new Candidato();
            candidato.setNome(result.getString("nome"));
            candidato.setInscricao(result.getInt("inscricao"));
            candidato.setCodPartido(result.getString("codPartido"));
            candidato.setCodCargo(result.getString("codCargo"));
            candidatos.add(candidato);
        }

        dbmanager.closePreparedStatement(statement);
        dbmanager.closeResultSet(result);

        return candidatos;
    }

    /**
     * Verifica se o candidato esta cadastrado na database.
     * 
     * @param inscricao O numero de inscricao do eleitor.
     * @return true | false
     * @throws SQLException
     */
    public boolean existe(int inscricao) throws SQLException {
        Connection conn = dbmanager.getConnection();

        String query = "SELECT COUNT(*) FROM Candidato WHERE Candidato.inscricao = ?";
        
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, inscricao);

        ResultSet result = statement.executeQuery();
        result.next();

        boolean exists = result.getInt(1) > 0;

        dbmanager.closePreparedStatement(statement);
        dbmanager.closeResultSet(result);

        return exists;
    }
    
}