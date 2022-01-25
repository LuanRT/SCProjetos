package com.senacfuc.vurna.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.senacfuc.vurna.objs.Candidato;
import com.senacfuc.vurna.objs.Cargo;
import com.senacfuc.vurna.utils.DbManager;

public class CargoDao {
    private DbManager dbmanager;

    public CargoDao(DbManager dbmanager) {
        this.dbmanager = dbmanager;
    }

    /**
     * Retrona a quantidade de cargos cadastrados no sistema.
     * 
     * @return Integer
     * @throws SQLException
     */
    public int getCargosCount() throws SQLException {
        Connection conn = dbmanager.getConnection();

        String query = "SELECT COUNT(*) FROM Cargo;";

        PreparedStatement statement = conn.prepareStatement(query);

        ResultSet result = statement.executeQuery();
        result.next();

        int cargo_count = result.getInt(1);

        dbmanager.closePreparedStatement(statement);
        dbmanager.closeResultSet(result);

        return cargo_count;
    }

    /**
     * Retorna o cargo.
     * 
     * @param cargo_codigo
     * @return Cargo
     * @throws SQLException
     */
    public Cargo getCargo(String cargo_codigo) throws SQLException {
        Connection conn = dbmanager.getConnection();

        String query = "SELECT * FROM Cargo WHERE Cargo.codCargo = ?";

        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, cargo_codigo);

        ResultSet result = statement.executeQuery();
        result.next();

        Cargo cargo = new Cargo();
        cargo.setNome(result.getString("nome"));
        cargo.setCodCargo(result.getString("codCargo"));

        dbmanager.closePreparedStatement(statement);
        dbmanager.closeResultSet(result);

        return cargo;
    }

    /**
     * Return todos os cargos disponiveis.
     * 
     * @return ArrayList<Cargo>
     * @throws SQLException
     */
    public List<Cargo> getAllCargos() throws SQLException {
        Connection conn = dbmanager.getConnection();

        String query = "SELECT * FROM Cargo;";
        PreparedStatement statement = conn.prepareStatement(query);
        ResultSet result = statement.executeQuery();

        ArrayList<Cargo> cargos = new ArrayList<Cargo>();
        while (result.next()) {
            Cargo cargo = new Cargo();
            cargo.setNome(result.getString("nome"));
            cargo.setCodCargo(result.getString("codCargo"));
            cargos.add(cargo);
        }

        // Organiza a lista.
        Collections.sort(cargos, new Comparator<Cargo>() {
            private Candidato candidato_o1;
            private Candidato candidato_o2;

            @Override
            public int compare(Cargo o1, Cargo o2) {
                // Pega o primeiro candidato da lista para fazer comparacao de inscricoes.
                try {
                    candidato_o1 = new CandidatoDao(dbmanager)
                            .getAllCandidatos(o1.getCodCargo()).get(0);
                    candidato_o2 = new CandidatoDao(dbmanager)
                            .getAllCandidatos(o2.getCodCargo()).get(0);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                /** 
                * Compara as inscricoes dos candidatos, assim o cargo que tem candidatos 
                * com inscricoes de menos digitos sao postos no top da lista.
                */
                return Integer.toString(candidato_o1.getInscricao()).length()
                        - Integer.toString(candidato_o2.getInscricao()).length();
            }
        });

        dbmanager.closePreparedStatement(statement);
        dbmanager.closeResultSet(result);

        return cargos;
    }
}
