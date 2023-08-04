package com.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLiteExample {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Carregar o driver JDBC do SQLite
            Class.forName("org.sqlite.JDBC");

            // Estabelecer a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:/home/julian/Desktop/oracao/SERPRO/TREINO_pratico_agosto_16/apagar/sexta_04_agosto/sqlite-java-example/db04.db");

            // Criar uma instrução SQL
            statement = connection.createStatement();

            // Executar uma consulta SELECT
            resultSet = statement.executeQuery("SELECT * FROM employees");

            // Iterar sobre os resultados
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fechar os recursos
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

