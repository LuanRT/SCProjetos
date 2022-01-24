package com.senacfuc.vurna;

import java.sql.SQLException;

import com.senacfuc.vurna.screens.LoginScreen;
import com.senacfuc.vurna.screens.SplashScreen;
import com.senacfuc.vurna.utils.Constants;
import com.senacfuc.vurna.utils.DbManager;

public class App {
    private static DbManager dbmanager;
    private static int splashscreen_duration = 3000;
    
    public static void main(String[] args) {
        initDatabaseConn();
        initScreens();
    }

    /**
     * Inicia a logica principal e as telas.
     */
    private static void initScreens() {
        // Exibe a SplashScreen
        SplashScreen ss = new SplashScreen(splashscreen_duration);
        ss.init();

        // Exibe a tela de login
        LoginScreen ec = new LoginScreen(dbmanager);
        ec.init();
    }

    /**
     * Inicia a conexao com a database.
     */
    private static void initDatabaseConn() {
        try {
            dbmanager = new DbManager(Constants.URL, Constants.USER, Constants.PASSWORD); 
            dbmanager.connect();
        } catch (SQLException e) {
            System.err.println("Erro de conexao: " + e.getMessage());
        }
    }
}
