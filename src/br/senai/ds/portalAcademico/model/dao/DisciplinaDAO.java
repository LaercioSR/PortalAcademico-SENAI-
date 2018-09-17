package br.senai.ds.portalAcademico.model.dao;

import br.senai.ds.portalAcademico.model.Disciplina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DisciplinaDAO {
    
    public boolean inserir(Disciplina disciplina) {
        Connection conn = ConexaoJDBC.conectar();
        PreparedStatement pstm = null;
        
        String sql = "INSERT INTO disciplina(descricao, cargaHoraria) VALUES(?,?)";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, disciplina.getNome());
            pstm.setInt(2, disciplina.getCargaHoraria());
            pstm.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConexaoJDBC.desconectar(conn, pstm, null);
        }
    }
    
    public void remover(int id) {
        Connection conn = ConexaoJDBC.conectar();
        PreparedStatement pstm = null;
        
        String sql = "DELETE FROM disciplina WHERE id_disciplina = " + id;
        try { 
            pstm = conn.prepareStatement(sql);
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoJDBC.desconectar(conn, pstm, null);
        }
    }

    public List<Disciplina> listar() {
        Connection conn = ConexaoJDBC.conectar();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM disciplina";
        List<Disciplina> retorno = new ArrayList<>();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Disciplina disciplina = new Disciplina();
                disciplina.setCodigo(rs.getInt("id_disciplina"));
                disciplina.setNome(rs.getString("descricao"));
                disciplina.setCargaHoraria(rs.getInt("cargaHoraria"));
                retorno.add(disciplina);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoJDBC.desconectar(conn, pstm, rs);
        }
           
        return retorno;    
    }
    
    public Disciplina obterPorMatricula(int id){
        Connection conn = ConexaoJDBC.conectar();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM disciplina WHERE id_disciplina = " + id;
        Disciplina retorno = new Disciplina();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            if (rs.next()) {
                retorno.setCodigo(rs.getInt("id_disciplina"));
                retorno.setNome(rs.getString("descricao"));
                retorno.setCargaHoraria(rs.getInt("cargaHoraria"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoJDBC.desconectar(conn, pstm, rs);
        }
        
        return retorno;
    }
    
    public Disciplina obterPorNome(String nome){
        Connection conn = ConexaoJDBC.conectar();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM disciplina WHERE descricao like '"+nome+"%'";
        Disciplina retorno = new Disciplina();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            if (rs.next()) {
                retorno.setCodigo(rs.getInt("id_disciplina"));
                retorno.setNome(rs.getString("descricao"));
                retorno.setCargaHoraria(rs.getInt("cargaHoraria"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoJDBC.desconectar(conn, pstm, rs);
        }
        
        return retorno;
    }
}
