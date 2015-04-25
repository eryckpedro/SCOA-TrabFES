package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dados.Aluno;
import dados.Disciplina;
import dados.Professor;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DisciplinasModel {
	
	private String nomeTabela = "Disciplina";
    MysqlDataSource dataSource;
    
    public DisciplinasModel(MysqlDataSource dataSource){
        this.dataSource = dataSource;
    }

    public ArrayList<Disciplina> lista() {
    	try {
    		//Class.forName("com.mysql.jdbc.Driver");

    		Connection con = dataSource.getConnection();
    		Statement st = con.createStatement();
    		ResultSet rs = st.executeQuery("SELECT * FROM " + nomeTabela);
	        
	        ArrayList<Disciplina> lista = new ArrayList<>();
	        
	        
	        while (rs.next()) {
	        	Disciplina a = new Disciplina();
	        	
	        	a.nome      = rs.getString("Nome");
	        	a.idFuncCad = rs.getInt("idFuncCad");
	        	
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
    
    public void adiciona(String nome, int idFuncCad) {
    	try {
    		Connection con = dataSource.getConnection();
    		Statement st = con.createStatement();
    		PreparedStatement pst = con.prepareStatement("INSERT INTO  " + nomeTabela + "(Nome, idFuncCad) VALUES (?, ?)");
            
            pst.setString(1, nome);
            pst.setInt(2, idFuncCad);
            pst.execute();
	        
	        pst.close();
	        st.close();
	        con.close();
	        
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    }
    
}
