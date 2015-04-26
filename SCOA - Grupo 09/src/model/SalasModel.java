package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import dados.Sala;

public class SalasModel {
	
	private String nomeTabela = "Sala";
    MysqlDataSource dataSource;
    
    public SalasModel(MysqlDataSource dataSource){
        this.dataSource = dataSource;
    }

    public ArrayList<Sala> lista() {
    	try {
    		Connection con = dataSource.getConnection();
    		Statement st = con.createStatement();
    		ResultSet rs = st.executeQuery("SELECT * FROM " + nomeTabela);
	        
	        ArrayList<Sala> lista = new ArrayList<>();
	        
	        
	        while (rs.next()) {
	        	Sala a = new Sala();
	        	
	        	a.id        = rs.getInt("idSala");
	        	a.numSala   = rs.getInt("numSala");
	        	a.andar     = rs.getInt("andar");
	        	a.bloco     = rs.getString("bloco");
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
    
    public void adiciona(int numSala, int andar, String bloco, int idFuncCad) {
    	try {
    		Connection con = dataSource.getConnection();
    		PreparedStatement pst = con.prepareStatement("INSERT INTO  " + nomeTabela + "(numSala, andar, bloco, idFuncCad) VALUES (?, ?, ?, ?)");
            
    		pst.setInt(1, numSala);
    		pst.setInt(2, andar);
    		pst.setString(3, bloco);
    		pst.setInt(4, idFuncCad);
            pst.execute();
	        
	        pst.close();
	        con.close();
	        
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
}
