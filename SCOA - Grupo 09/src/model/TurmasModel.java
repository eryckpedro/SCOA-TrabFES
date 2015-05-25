package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import dados.Turma;

public class TurmasModel {
	
	private String nomeTabela = "Turma";
    MysqlDataSource dataSource;
    
    public TurmasModel(MysqlDataSource dataSource){
        this.dataSource = dataSource;
    }

    public ArrayList<Turma> lista() {
    	try {
    		Connection con = dataSource.getConnection();
    		Statement st = con.createStatement();
    		ResultSet rs = st.executeQuery("SELECT * FROM " + nomeTabela);
	        
	        ArrayList<Turma> lista = new ArrayList<>();
	        
	        
	        while (rs.next()) {
	        	Turma a = new Turma();
	        	
	        	a.id           = rs.getInt("idTurma");
	        	a.idDisciplina = rs.getInt("idDisciplina");
	        	a.horario      = rs.getTimestamp("horario");
	        	a.idProfessor  = rs.getInt("idProfessor");
	        	a.idSala       = rs.getInt("idSala");
	        	
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
    
    public ArrayList<Turma> listaTurmasInscritas(int idAluno) {
    	try {
    		Connection con = dataSource.getConnection();
    		PreparedStatement pst = con.prepareStatement("SELECT * FROM Aluno_frequenta_Turma WHERE idAluno = ?");
    		pst.setInt(1, idAluno);
    		
    		
    		ResultSet rs = pst.executeQuery();
    		
	        ArrayList<Turma> lista = new ArrayList<>();
	        
	        
	        while (rs.next()) {
	        	int id = rs.getInt("idTurma");
	        	Turma turma = getTurma(id);
	        	lista.add(turma);
            }
	        
	        rs.close();
	        pst.close();
	        con.close();
	        
	        return lista;
        
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
        
    	return null;
    }
    
    public Turma getTurma(int idTurma) {
    	try {
    		Connection con = dataSource.getConnection();
    		PreparedStatement pst = con.prepareStatement("SELECT * FROM Turma WHERE idTurma = ?");
    		pst.setInt(1, idTurma);
    		
    		ResultSet rs = pst.executeQuery();
	        
        	Turma a = new Turma();
        	
	        while (rs.next()) {
	        	a.id           = rs.getInt("idTurma");
	        	a.idDisciplina = rs.getInt("idDisciplina");
	        	a.horario      = rs.getTimestamp("horario");
	        	a.idProfessor  = rs.getInt("idProfessor");
	        	a.idSala       = rs.getInt("idSala");
            }
	        
	        rs.close();
	        pst.close();
	        con.close();
	        
	        return a;
        
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
        
    	return null;
    }
    
    public void adiciona(int idDisciplina, Date data, int idProfessor, int idSala, int idFuncCad) {
    	try {
    		Connection con = dataSource.getConnection();
    		PreparedStatement pst = con.prepareStatement("INSERT INTO  " + nomeTabela + "(idDisciplina, horario, idProfessor, idSala, idFuncCad) VALUES (?, ?, ?, ?, ?)");
            
    		Timestamp timestamp = new Timestamp(data.getTime());
    		
    		pst.setInt(1, idDisciplina);
    		pst.setTimestamp(2, timestamp);
    		pst.setInt(3, idProfessor);
    		pst.setInt(4, idSala);
    		pst.setInt(5, idFuncCad);
    		
            pst.execute();
	        pst.close();
	        con.close();
	        
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
}
