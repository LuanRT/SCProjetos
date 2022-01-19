package com.senacfuc.vurna;

import com.senacfuc.vurna.screens.EleitorCreds;
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
        EleitorCreds ec = new EleitorCreds(dbmanager);
        ec.init();
    }

    /**
     * Inicia a conexao com a database.
     */
    private static void initDatabaseConn() {
        try {
            dbmanager = new DbManager(Constants.URL, Constants.USER, Constants.PASSWORD); 
            dbmanager.connect();
        } catch (Exception e) {
            System.err.println("Could not connect to db: " + e.getMessage());
        }
    }
}
