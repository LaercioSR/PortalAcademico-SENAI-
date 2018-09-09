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
    private Connection connection;

    
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    public boolean inserir(Aluno aluno) {
        String sql = "INSERT INTO aluno(matricula, nome, telefone) VALUES(?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, aluno.getMatricula());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getTelefone());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Aluno> listar() {
        String sql = "SELECT * FROM aluno";
        List<Aluno> retorno = new ArrayList<>();
            try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet resultado = stmt.executeQuery();
                while (resultado.next()) {
                    Aluno aluno = new Aluno();
                    aluno.setMatricula(resultado.getInt("matricula"));
                    aluno.setNome(resultado.getString("nome"));
                    aluno.setTelefone(resultado.getString("telefone"));
                    retorno.add(aluno);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            return retorno;    
    }
    
    public Aluno obterAlunoPorMatricula(int matricula){
        String sql = "SELECT * FROM aluno WHERE matricula = " + matricula;
        Aluno retorno = new Aluno();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            if (resultado.next()) {
                retorno.setNome(resultado.getString("nome"));
                retorno.setMatricula(resultado.getInt("matricula"));
                retorno.setTelefone(resultado.getString("telefone"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
    public Aluno obterAlunoPorNome(String nome){
        String sql = "SELECT * FROM aluno WHERE nome like '"+nome+"%'";
        Aluno retorno = new Aluno();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            if (resultado.next()) {
                retorno.setNome(resultado.getString("nome"));
                retorno.setMatricula(resultado.getInt("matricula"));
                retorno.setTelefone(resultado.getString("telefone"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
    public void remover(int matricula) {
        String sql = "DELETE FROM aluno WHERE matricula = " + matricula;
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}