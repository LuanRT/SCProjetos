package com.senacfuc.vurna.utils;

public class Constants {
    public static String
            // Database 
            URL = "jdbc:mysql://localhost:3306/urnadb",
            USER = "root",
            PASSWORD = "root",

            // Login
            UNAUTHORIZED = "Parece que você não pode participar dessa votação!\nEntre em contato com os organizadores e tente novamente.",
            INVALID_INPUT = "Invalido, somente valores números são aceitos!",
            
            // MainScreen
            WELCOME = "Bem-vindo {user}!",

            // InfoScreen
            CANDIDATO = "Candidato",
            INSCRICAO = "Inscrição",
            VOTOS = "Votos",
            PER = "%",

            // Urna 
            VOTE_TIP_1 = "Seu voto para {cargo}",
            VOTE_TIP_2 = "Percebemos que você já votou para {cargo}, então vamos pular para o próximo cargo.",
            VOTE_TIP_3 = "Você já participou desta eleição!",
            
            VOTE_ERR_1 = "Este candidato não pertence ao cargo de {cargo}!",
            VOTE_ERR_2 = "Este candidato não existe!",
            VOTE_ERR_3 = "Não foi possível verificar o seu voto.",
            
            DB_ERR = "Não foi possível se conectar a database.";

}
