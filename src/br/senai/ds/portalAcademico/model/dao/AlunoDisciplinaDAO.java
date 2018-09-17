package br.senai.ds.portalAcademico.model.dao;

import br.senai.ds.portalAcademico.model.Aluno;
import br.senai.ds.portalAcademico.model.Disciplina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlunoDisciplinaDAO {

    public boolean iserir(int idAluno, int idDisciplina) {
        Connection conn = ConexaoJDBC.conectar();
        PreparedStatement pstm = null;

        String sql = "INSERT INTO aluno_disciplina(fk_disciplina, fk_matricula) VALUES(?,?)";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idDisciplina);
            pstm.setInt(2, idAluno);
            pstm.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConexaoJDBC.desconectar(conn, pstm, null);
        }
    }
    
    public List<Aluno> buscarAlunosDisciplina(int idDisciplina) {
        Connection conn = ConexaoJDBC.conectar();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        List retorno = new ArrayList<>();
        String sql = "SELECT * FROM aluno_disciplina AS PD "
                   + "INNER JOIN aluno " 
                   + "WHERE aluno.matricula = PD.fk_matricula AND fk_disciplina = " + idDisciplina;
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()) {
                Aluno aluno = new Aluno(rs.getString("nome"), rs.getString("telefone"));
                aluno.setMatricula(rs.getInt("matricula"));
                retorno.add(aluno);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
    }
    
    public List<Disciplina> buscarDisciplinasAluno(int idAluno) {
        Connection conn = ConexaoJDBC.conectar();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        List retorno = new ArrayList<>();
        String sql = "SELECT * FROM aluno_disciplina AS PD "
                   + "INNER JOIN disciplina AS Disc " 
                   + "WHERE Disc.id_disciplina = PD.fk_disciplina AND fk_matricula = " + idAluno;
        
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
        }
        
        return retorno;
    }
}
