package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import dados.Professor;

public class ProfessoresModel {
	
	private String nomeTabela = "Professor";
    MysqlDataSource dataSource;
    
    public ProfessoresModel(MysqlDataSource dataSource){
        this.dataSource = dataSource;
    }

    public ArrayList<Professor> lista() {
    	try {
    		Connection con = dataSource.getConnection();
    		Statement st = con.createStatement();
    		ResultSet rs = st.executeQuery("SELECT * FROM " + nomeTabela);
	        
	        ArrayList<Professor> lista = new ArrayList<>();
	        
	        
	        while (rs.next()) {
	        	Professor a = new Professor();
	        	
	        	a.id        = rs.getInt("idProfessor");
	        	a.nome      = rs.getString("Nome");
	        	a.matricula = rs.getString("Matricula");
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
    		Statement st = con.createStatement();
    		PreparedStatement pst = con.prepareStatement("INSERT INTO  " + nomeTabela + "(Nome, Matricula, login, senha, idFuncCad) VALUES (?, ?, ?, ?, ?)");
            
            pst.setString(1, nome);
            pst.setString(2, matricula);
            pst.setString(3, login);
            pst.setString(4, senha);
            pst.setInt(5, idFuncCad);
            pst.execute();
	        
	        pst.close();
	        st.close();
	        con.close();
	        
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}
