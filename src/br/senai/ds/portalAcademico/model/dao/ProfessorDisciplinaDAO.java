package br.senai.ds.portalAcademico.model.dao;

import br.senai.ds.portalAcademico.model.Disciplina;
import br.senai.ds.portalAcademico.model.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfessorDisciplinaDAO {
    public boolean iserir(int idProfessor, int idDisciplina) {
        Connection conn = ConexaoJDBC.conectar();
        PreparedStatement pstm = null;
        
        String sql = "INSERT INTO professor_disciplina(fk_disciplina, fk_professor) VALUES(?,?)";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idDisciplina);
            pstm.setInt(2, idProfessor);
            pstm.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConexaoJDBC.desconectar(conn, pstm, null);
        }
    }
    
    public Professor buscarProfessorDisciplina(int idDisciplina) {
        Connection conn = ConexaoJDBC.conectar();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        Professor professor = null;
        String sql = "SELECT * FROM professor_disciplina AS PD "
                   + "INNER JOIN professor AS Prof " 
                   + "WHERE Prof.matricula = PD.fk_professor AND fk_disciplina = " + idDisciplina;
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            if(rs.next()) {
                professor = new Professor(rs.getString("nome"), rs.getString("email"), rs.getString("telefone"));
                professor.setMatricula(rs.getInt("matricula"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoJDBC.desconectar(conn, pstm, rs);
        }
        
        return professor;
    }
    
    public List<Disciplina> buscarDisciplinasProfessor(int idProfessor) {
        Connection conn = ConexaoJDBC.conectar();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        List retorno = new ArrayList<>();
        String sql = "SELECT * FROM professor_disciplina AS PD "
                   + "INNER JOIN disciplina AS Disc " 
                   + "WHERE Disc.id_disciplina = PD.fk_disciplina AND fk_professor = " + idProfessor;
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()) {
                Disciplina disciplina = new Disciplina();
                disciplina.setCodigo(rs.getInt("fk_disciplina"));
                disciplina.setNome(rs.getString("descricao"));
                disciplina.setCargaHoraria(rs.getInt("cargaHoraria"));
                retorno.add(disciplina);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoJDBC.desconectar(conn, pstm, rs);
        }
        
        return retorno;
    }
}
