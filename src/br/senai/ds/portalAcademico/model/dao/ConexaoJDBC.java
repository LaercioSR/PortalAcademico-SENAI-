package br.senai.ds.portalAcademico.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoJDBC {
    private Connection connection;

    public Connection conectar() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/portal_academico", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.connection;
    }

    public void desconectar(Connection connection) {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
