package br.senai.ds.portalAcademico.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoJDBC {
    public static Connection conectar() {
        try {
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/portal_academico", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static void desconectar(Connection conn, PreparedStatement pstm, ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (rs != null) {
               rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
