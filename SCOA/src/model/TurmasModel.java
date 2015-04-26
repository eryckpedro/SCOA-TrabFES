package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import dados.Aluno;
import dados.Disciplina;
import dados.Professor;
import dados.Sala;
import dados.Turma;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class TurmasModel {
	
	private String nomeTabela = "Turma";
    MysqlDataSource dataSource;
    
    public TurmasModel(MysqlDataSource dataSource){
        this.dataSource = dataSource;
    }

    public ArrayList<Turma> lista() {
    	try {
    		//Class.forName("com.mysql.jdbc.Driver");

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
    		System.out.println(e);
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
    		System.out.println(e);
    	}
    }
    
}