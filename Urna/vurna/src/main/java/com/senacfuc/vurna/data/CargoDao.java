package com.senacfuc.vurna.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
     * @return List<Cargo>
     * @throws SQLException
     */
    public List<Cargo> getAllCargos() throws SQLException {
        Connection conn = dbmanager.getConnection();

        String query = "SELECT * FROM Cargo;";
        PreparedStatement statement = conn.prepareStatement(query);
        ResultSet result = statement.executeQuery();

        List<Cargo> cargos = new ArrayList<Cargo>();
        while (result.next()) {
            Cargo cargo = new Cargo();
            cargo.setNome(result.getString("nome"));
            cargo.setCodCargo(result.getString("codCargo"));
            cargos.add(cargo);
        }

        dbmanager.closePreparedStatement(statement);
        dbmanager.closeResultSet(result);

        return cargos;
    }
}
