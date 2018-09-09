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
    private Connection connection;

    
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    public boolean inserir(Professor professor) {
        String sql = "INSERT INTO professor(matricula, nome, email, telefone) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, professor.getMatricula());
            stmt.setString(2, professor.getNome());
            stmt.setString(3, professor.getEmail());
            stmt.setString(4, professor.getTelefone());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Professor> listar() {
        String sql = "SELECT * FROM professor";
            List<Professor> retorno = new ArrayList<>();
            try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet resultado = stmt.executeQuery();
                while (resultado.next()) {
                    Professor professor = new Professor();
                    professor.setMatricula(resultado.getInt("matricula"));
                    professor.setNome(resultado.getString("nome"));
                    professor.setEmail(resultado.getString("email"));
                    professor.setTelefone(resultado.getString("telefone"));
                    retorno.add(professor);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            return retorno;    
    }
    
    public Professor obterPorMatricula(int matricula){
        String sql = "SELECT * FROM professor WHERE matricula = " + matricula;
            Professor retorno = new Professor();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                retorno.setMatricula(resultado.getInt("matricula"));
                retorno.setNome(resultado.getString("nome"));
                retorno.setEmail(resultado.getString("email"));
                retorno.setTelefone(resultado.getString("telefone"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
    public Professor obterPorNome(String nome){
        String sql = "SELECT * FROM professor WHERE nome LIKE '" + nome + "%'";
            Professor retorno = new Professor();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                retorno.setMatricula(resultado.getInt("matricula"));
                retorno.setNome(resultado.getString("nome"));
                retorno.setEmail(resultado.getString("email"));
                retorno.setTelefone(resultado.getString("telefone"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
    public void remover(int matricula) {
        String sql = "DELETE FROM professor WHERE matricula = " + matricula;
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}