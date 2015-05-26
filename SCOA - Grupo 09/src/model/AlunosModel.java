package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import dados.Aluno;

public class AlunosModel {
	
	private String nomeTabela = "Aluno";
    MysqlDataSource dataSource;
    
    public AlunosModel(MysqlDataSource dataSource){
        this.dataSource = dataSource;
    }

    public ArrayList<Aluno> lista() {
    	try {
    		Connection con = dataSource.getConnection();
    		Statement st = con.createStatement();
    		ResultSet rs = st.executeQuery("SELECT * FROM " + nomeTabela);
	        
	        ArrayList<Aluno> lista = new ArrayList<>();
	        
	        
	        while (rs.next()) {
	        	Aluno a = new Aluno();
	        	
	        	a.id        = rs.getInt("idAluno");
	        	a.nome      = rs.getString("Nome");
	        	a.matricula = rs.getString("Matricula");
	        	a.cr        = rs.getFloat("CR");
	        	a.idFuncCad = rs.getInt("idFuncCad");
	        	
	        	lista.add(a);
            }
	        
	        rs.close();
	        st.close();
	        con.close();
	        
	        return lista;
        
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
        
    	return null;
    }
    
    public void adiciona(String nome, String matricula, String login, String senha, int idFuncCad) {
    	try {
    		Connection con = dataSource.getConnection();
    		PreparedStatement pst = con.prepareStatement("INSERT INTO  " + nomeTabela + "(Nome, Matricula, login, senha, idFuncCad) VALUES (?, ?, ?, ?, ?)");
            
            pst.setString(1, nome);
            pst.setString(2, matricula);
            pst.setString(3, login);
            pst.setString(4, senha);
            pst.setInt(5, idFuncCad);
            pst.execute();
	        
	        pst.close();
	        con.close();
	        
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void adicionaInscricaoEmTurma(int idAluno, int idTurma) {
    	try {
    		Connection con = dataSource.getConnection();
    		PreparedStatement pst = con.prepareStatement("INSERT INTO Aluno_frequenta_Turma(idAluno, idTurma) VALUES (?, ?)");
            
            pst.setInt(1, idAluno);
            pst.setInt(2, idTurma);
            pst.execute();
	        
	        pst.close();
	        con.close();
	        
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    
    public boolean concluiuDisciplina(int idAluno, int idDisciplina) {
    	
    	boolean r = false;
    	
    	try {
    		Connection con = dataSource.getConnection();
    		PreparedStatement pst = con.prepareStatement("SELECT * FROM Aluno_conclui_Disciplina WHERE idAluno = ? AND idDisciplina = ? AND media >= 5");
    		
    		pst.setInt(1, idAluno);
    		pst.setInt(2, idDisciplina);
    		
    		ResultSet rs = pst.executeQuery();
    		
    		if(rs.next())
    			r = true;
    		
    		rs.close();
    		pst.close();
    		con.close();
        
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
        
    	return r;
    }
    
    public void adicionaFrequencia(int turmaId, int alunoId, float frequencia) {
    	try {
    		Connection con = dataSource.getConnection();
    		PreparedStatement pst = con.prepareStatement("UPDATE Aluno_frequenta_Turma SET frequencia = ? WHERE idTurma = ? AND idAluno = ?");
            
    		pst.setFloat(1, frequencia);
    		pst.setInt(2, turmaId);
    		pst.setInt(3, alunoId);
    		
            pst.execute();
            
	        pst.close();
	        con.close();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }

	public void adicionaMedia(int disciplinaId, int alunoId, float med) {
    	try {
    		Connection con = dataSource.getConnection();
    		PreparedStatement pst = con.prepareStatement("INSERT INTO Aluno_conclui_Disciplina(idAluno, idDisciplina, media) VALUES (?, ?, ?)");
            
            pst.setInt(1, alunoId);
            pst.setInt(2, disciplinaId);
            pst.setFloat(3, med);
            pst.execute();
	        
	        pst.close();
	        con.close();
	        
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
	}
    
}
