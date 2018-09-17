package br.senai.ds.portalAcademico.model.dao;

import br.senai.ds.portalAcademico.model.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlunoDAO {
    public boolean inserir(Aluno aluno) {
        Connection conn = ConexaoJDBC.conectar();
        PreparedStatement pstm = null;
        
        String sql = "INSERT INTO aluno(matricula, nome, telefone) VALUES(?,?,?)";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, aluno.getMatricula());
            pstm.setString(2, aluno.getNome());
            pstm.setString(3, aluno.getTelefone());
            pstm.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConexaoJDBC.desconectar(conn, pstm, null);
        }
    }
    
    public void remover(int matricula) {
        Connection conn = ConexaoJDBC.conectar();
        PreparedStatement pstm = null;
        
        String sql = "DELETE FROM aluno WHERE matricula = " + matricula;
        try { 
            pstm = conn.prepareStatement(sql);
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoJDBC.desconectar(conn, pstm, null);
        }
    }

    public List<Aluno> listar() {
        Connection conn = ConexaoJDBC.conectar();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM aluno";
        List<Aluno> retorno = new ArrayList<>();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setMatricula(rs.getInt("matricula"));
                aluno.setNome(rs.getString("nome"));
                aluno.setTelefone(rs.getString("telefone"));
                retorno.add(aluno);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoJDBC.desconectar(conn, pstm, rs);
        }
           
        return retorno;    
    }
    
    public Aluno obterAlunoPorMatricula(int matricula){
        Connection conn = ConexaoJDBC.conectar();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM aluno WHERE matricula = " + matricula;
        Aluno retorno = new Aluno();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            if (rs.next()) {
                retorno.setNome(rs.getString("nome"));
                retorno.setMatricula(rs.getInt("matricula"));
                retorno.setTelefone(rs.getString("telefone"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoJDBC.desconectar(conn, pstm, rs);
        }
        
        return retorno;
    }
    
    public Aluno obterAlunoPorNome(String nome){
        Connection conn = ConexaoJDBC.conectar();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM aluno WHERE nome like '"+nome+"%'";
        Aluno retorno = new Aluno();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            if (rs.next()) {
                retorno.setNome(rs.getString("nome"));
                retorno.setMatricula(rs.getInt("matricula"));
                retorno.setTelefone(rs.getString("telefone"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoJDBC.desconectar(conn, pstm, rs);
        }
        
        return retorno;
    }
}