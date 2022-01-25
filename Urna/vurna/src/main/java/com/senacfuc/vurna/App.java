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
        SplashScreen splash_screen = new SplashScreen(splashscreen_duration);
        splash_screen.init();

        // Exibe a tela de login
        LoginScreen login_screen = new LoginScreen(dbmanager);
        login_screen.init();
    }

    /**
     * Inicia a conexao com a database.
     */
    private static void initDatabaseConn() {
        try {
            dbmanager = new DbManager(Constants.URL, Constants.USER, Constants.PASSWORD); 
            dbmanager.connect();
            
        } catch (SQLException e) {
            System.out.println("Nao foi possivel se conectar a database: " + e.getMessage());
        }
    }
}
