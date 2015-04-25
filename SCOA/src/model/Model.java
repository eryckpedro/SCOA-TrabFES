package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class Model {
	
    MysqlDataSource dataSource;
    
    FuncionariosModel funcionariosModel;
    AlunosModel alunosModel;
    ProfessoresModel professoresModel;
    DisciplinasModel disciplinasModel;
    SalasModel salasModel;
    
    public Model(){
    	dataSource = new MysqlDataSource();
        dataSource.setUser("fes_bd");
        dataSource.setPassword("fes_bd");
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("scoa_db");
        
        funcionariosModel = new FuncionariosModel(dataSource);
        alunosModel = new AlunosModel(dataSource);
        professoresModel = new ProfessoresModel(dataSource);
        disciplinasModel = new DisciplinasModel(dataSource);
        salasModel = new SalasModel(dataSource);
        
        funcionariosModel.primeiroAcesso();
    }
    
    
    public FuncionariosModel getFuncionariosModel() {
    	return this.funcionariosModel;
    }
    
    public AlunosModel getAlunosModel() {
    	return this.alunosModel;
    }
   
    public ProfessoresModel getProfessoresModel() {
    	return this.professoresModel;
    }

    public DisciplinasModel getDisciplinasModel() {
    	return this.disciplinasModel;
    }
    
    public SalasModel getSalasModel() {
    	return this.salasModel;
    }
   
    
    
    public boolean existe(String login, String senha, String nomeTabela) {
    	
    	boolean r = false;
    	
    	try {
    		Connection con = dataSource.getConnection();
    		
    		PreparedStatement pst = con.prepareStatement("SELECT * FROM " + nomeTabela + " WHERE login = ? AND senha = ?");
    		pst.setString(1, login);
    		pst.setString(2, senha);
    		
    		ResultSet rs = pst.executeQuery();
    		
    		if(rs.next())
    			r = true;
    		
    		rs.close();
    		pst.close();
    		con.close();
        
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
        
    	return r;
    }

	public String getNome(String login, String nomeTabela) {
		String nome = null;
		
    	try {
    		Connection con = dataSource.getConnection();
    		
    		PreparedStatement pst = con.prepareStatement("SELECT * FROM " + nomeTabela + " WHERE login = ?");
    		pst.setString(1, login);
    		
    		ResultSet rs = pst.executeQuery();
    		
	        if(rs.next())
	        	nome = rs.getString("Nome");
	        
    		rs.close();
    		pst.close();
    		con.close();
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
        
    	return nome;
	}
	
	public int getId(String login, String nomeTabela) {
		int id = -1;
		
    	try {
    		Connection con = dataSource.getConnection();
    		
    		PreparedStatement pst = con.prepareStatement("SELECT * FROM " + nomeTabela + " WHERE login = ?");
    		pst.setString(1, login);
    		
    		ResultSet rs = pst.executeQuery();
    		
	        if(rs.next())
	        	id = rs.getInt("idFuncionario");
	        
    		rs.close();
    		pst.close();
    		con.close();
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
        
    	return id;
	}
	
    

}

