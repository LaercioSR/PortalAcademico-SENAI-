package br.senai.ds.portalAcademico.model.dao;

import br.senai.ds.portalAcademico.model.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfessorDAO {
    public boolean inserir(Professor professor) {
        Connection conn = ConexaoJDBC.conectar();
        PreparedStatement pstm = null;
        
        String sql = "INSERT INTO professor(matricula, nome, email, telefone) VALUES(?,?,?,?)";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, professor.getMatricula());
            pstm.setString(2, professor.getNome());
            pstm.setString(3, professor.getEmail());
            pstm.setString(4, professor.getTelefone());
            pstm.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConexaoJDBC.desconectar(conn, pstm, null);
        }
    }
    
    public void remover(int matricula) {
        Connection conn = ConexaoJDBC.conectar();
        PreparedStatement pstm = null;
        
        String sql = "DELETE FROM professor WHERE matricula = " + matricula;
        try { 
            pstm = conn.prepareStatement(sql);
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoJDBC.desconectar(conn, pstm, null);
        }
    }

    public List<Professor> listar() {
        Connection conn = ConexaoJDBC.conectar();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM professor";
        List<Professor> retorno = new ArrayList<>();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Professor professor = new Professor();
                professor.setMatricula(rs.getInt("matricula"));
                professor.setNome(rs.getString("nome"));
                professor.setEmail(rs.getString("email"));
                professor.setTelefone(rs.getString("telefone"));
                retorno.add(professor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoJDBC.desconectar(conn, pstm, rs);
        }

        return retorno;    
    }
    
    public Professor obterPorMatricula(int matricula){
        Connection conn = ConexaoJDBC.conectar();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM professor WHERE matricula = " + matricula;
            Professor retorno = new Professor();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            if (rs.next()) {
                retorno.setMatricula(rs.getInt("matricula"));
                retorno.setNome(rs.getString("nome"));
                retorno.setEmail(rs.getString("email"));
                retorno.setTelefone(rs.getString("telefone"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoJDBC.desconectar(conn, pstm, rs);
        }
        
        return retorno;
    }
    
    public Professor obterPorNome(String nome){
        Connection conn = ConexaoJDBC.conectar();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM professor WHERE nome LIKE '" + nome + "%'";
            Professor retorno = new Professor();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            if (rs.next()) {
                retorno.setMatricula(rs.getInt("matricula"));
                retorno.setNome(rs.getString("nome"));
                retorno.setEmail(rs.getString("email"));
                retorno.setTelefone(rs.getString("telefone"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoJDBC.desconectar(conn, pstm, rs);
        }
        
        return retorno;
    }
}