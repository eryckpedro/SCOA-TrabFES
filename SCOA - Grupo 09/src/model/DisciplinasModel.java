package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import dados.Disciplina;

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
	        	
	        	a.id        = rs.getInt("idDisciplina");
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
    		e.printStackTrace();
    	}
        
    	return null;
    }
    
    public ArrayList<Disciplina> listaDiscConcluidas(int idAluno) {
    	try {
    		//Class.forName("com.mysql.jdbc.Driver");

    		Connection con = dataSource.getConnection();
    		PreparedStatement pst = con.prepareStatement("SELECT * FROM Aluno_conclui_Disciplina WHERE idAluno = ?");
    		pst.setInt(1, idAluno);
    		
    		
    		ResultSet rs = pst.executeQuery();
	        
	        ArrayList<Disciplina> lista = new ArrayList<>();
	        
	        
	        while (rs.next()) {
	        	int idDisciplina = rs.getInt("idDisciplina");
	        	Disciplina a = getDisciplina(idDisciplina);
	        	a.media = rs.getFloat("media");
	        	//TODO a.date = ...
	        	
	        	lista.add(a);
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
    
    public Disciplina getDisciplina(int idDisciplina) {
    	try {
    		//Class.forName("com.mysql.jdbc.Driver");

    		Connection con = dataSource.getConnection();
    		PreparedStatement pst = con.prepareStatement("SELECT * FROM " + nomeTabela + " WHERE idDisciplina = ?");
    		pst.setInt(1, idDisciplina);
    		
    		
    		ResultSet rs = pst.executeQuery();
	        
        	Disciplina a = new Disciplina();
        	
	        while (rs.next()) {
	        	a.id        = rs.getInt("idDisciplina");
	        	a.nome      = rs.getString("Nome");
	        	a.idFuncCad = rs.getInt("idFuncCad");
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
    
    
    public ArrayList<Integer> listaPreRequisitos(int idDisciplina) {
    	try {

    		Connection con = dataSource.getConnection();
    		PreparedStatement pst = con.prepareStatement("SELECT * FROM Disciplina_requisita_Disciplina WHERE idDisciplina = ?");
    		pst.setInt(1, idDisciplina);
    		
    		
    		ResultSet rs = pst.executeQuery();
	        
	        ArrayList<Integer> lista = new ArrayList<>();
	        
	        
	        while (rs.next()) {
	        	int id =  rs.getInt("idDisciplinaRequisitada");
	        	
	        	lista.add(id);
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
    
    public void adiciona(String nome, int idFuncCad, ArrayList<Integer> idDisciplinas) {
    	try {
    		Connection con = dataSource.getConnection();
    		PreparedStatement pst = con.prepareStatement("INSERT INTO  " + nomeTabela + "(Nome, idFuncCad) VALUES (?, ?)", new String[]{"USER_ID"});
            
            pst.setString(1, nome);
            pst.setInt(2, idFuncCad);
            pst.execute();
            
            
            // id da disciplina inserida, para ser passada pra adicionaPreRequisitos()
            int id = -1;
            
            ResultSet rs = pst.getGeneratedKeys();
            if(rs.next()) {
              id = rs.getInt(1);
            }
            
            
	        pst.close();
	        con.close();
	        
	        for(Integer i : idDisciplinas)
	        	adicionaPreRequisito(id, i);
	        
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void adicionaPreRequisito(int idDisciplina, int idDisciplinaRequisitada) {
    	try {
    		Connection con = dataSource.getConnection();
    		PreparedStatement pst = con.prepareStatement("INSERT INTO Disciplina_requisita_Disciplina(idDisciplina, idDisciplinaRequisitada) VALUES (?, ?)");
            
            pst.setInt(1, idDisciplina);
            pst.setInt(2, idDisciplinaRequisitada);
            pst.execute();
	        
	        pst.close();
	        con.close();
	        
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
        
}
