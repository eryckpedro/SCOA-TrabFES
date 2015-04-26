package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import dados.Funcionario;

public class FuncionariosModel {
    
	private String nomeTabela = "Funcionario";
    MysqlDataSource dataSource;
    
    public FuncionariosModel(MysqlDataSource dataSource){
        this.dataSource = dataSource;
    }
    
    public ArrayList<Funcionario> lista() {
    	try {
    		Connection con = dataSource.getConnection();
    		Statement st = con.createStatement();
    		ResultSet rs = st.executeQuery("SELECT * FROM " + nomeTabela);
	        
	        ArrayList<Funcionario> lista = new ArrayList<>();
	        
	        
	        while (rs.next()) {
	        	Funcionario a = new Funcionario();
	        	
	        	a.id        = rs.getInt("idFuncionario");
	        	a.nome      = rs.getString("Nome");
	        	a.setor     = rs.getString("Setor");
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
    
    public void adiciona(String nome, String setor, String login, String senha, int idFuncCad) {
    	try {
    		Connection con = dataSource.getConnection();
    		PreparedStatement pst = con.prepareStatement("INSERT INTO " + nomeTabela + "(Nome, Setor, login, senha, idFuncCad) VALUES (?, ?, ?, ?, ?)");
            
            pst.setString(1, nome);
            pst.setString(2, setor);
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
    

	public boolean tabelaVazia() {
		boolean r = false;
		
    	try {
    		Connection con = dataSource.getConnection();
    		PreparedStatement pst = con.prepareStatement("SELECT * FROM " + nomeTabela);
    		ResultSet rs = pst.executeQuery();
    		
    		if(rs.next()) r = false; // tabela não vazia
    		else          r = true;  // tabela vazia
    		
    		rs.close();
    		pst.close();
    		con.close();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
        
    	return r;
    }
	
	public void primeiroAcesso() {
		if(tabelaVazia()) {
			System.out.println("Tabela vazia! Criado usuário de admin.");
			adiciona("Administrador", "administração", "admin", "senha", 1);
		}
	}
	
	
   
}

