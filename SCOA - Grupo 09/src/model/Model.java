package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class Model {
	
	private MysqlDataSource dataSource;
    
    private FuncionariosModel funcionariosModel;
    private AlunosModel alunosModel;
    private ProfessoresModel professoresModel;
    private DisciplinasModel disciplinasModel;
    private SalasModel salasModel;
    private TurmasModel turmasModel;
    
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
        turmasModel = new TurmasModel(dataSource);
        
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
    
    public TurmasModel getTurmasModel() {
    	return this.turmasModel;
    }
   
    
    
    public boolean loginValido(String login, String senha, String nomeTabela) {
    	
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
    		e.printStackTrace();
    	}
        
    	return r;
    }
    
    
    
    public boolean existeLogin(String login, String nomeTabela) {
    	
    	boolean r = false;
    	
    	try {
    		Connection con = dataSource.getConnection();
    		
    		PreparedStatement pst = con.prepareStatement("SELECT * FROM " + nomeTabela + " WHERE login = ?");
    		pst.setString(1, login);
    		
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
    
    public boolean existeNome(String nome, String nomeTabela) {
    	
    	boolean r = false;
    	
    	try {
    		Connection con = dataSource.getConnection();
    		
    		PreparedStatement pst = con.prepareStatement("SELECT * FROM " + nomeTabela + " WHERE nome = ?");
    		pst.setString(1, nome);
    		
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

    
    
    public boolean existeMatricula(String matricula, String nomeTabela) {
    	
    	boolean r = false;
    	
    	try {
    		Connection con = dataSource.getConnection();
    		
    		PreparedStatement pst = con.prepareStatement("SELECT * FROM " + nomeTabela + " WHERE matricula = ?");
    		pst.setString(1, matricula);
    		
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
    
    public boolean existeSala(int sala, int andar, String bloco) {
    	
    	boolean r = false;
    	
    	try {
    		Connection con = dataSource.getConnection();
    		
    		PreparedStatement pst = con.prepareStatement("SELECT * FROM Sala WHERE numSala = ? AND andar = ? AND bloco = ?");
    		pst.setInt(1, sala);
    		pst.setInt(2,  andar);
    		pst.setString(3, bloco);
    		
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
    
    
    
    public boolean existeTurma(int idDisciplina, Date data, int idProfessor, int idSala) {
    	
    	boolean r = false;
    	
    	try {
    		Connection con = dataSource.getConnection();
    		PreparedStatement pst = con.prepareStatement("SELECT * FROM Turma WHERE idDisciplina = ? AND horario = ? AND idProfessor = ? AND idSala = ?");
    		
    		Timestamp timestamp = new Timestamp(data.getTime());
    		
    		pst.setInt(1, idDisciplina);
    		pst.setTimestamp(2, timestamp);
    		pst.setInt(3, idProfessor);
    		pst.setInt(4, idSala);
    		
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
    
    public String getPrimaryKey(String nomeTabela) {
		String nome = null;
		
    	try {
    		Connection con = dataSource.getConnection();
    		
    		PreparedStatement pst = con.prepareStatement("SHOW KEYS FROM " + nomeTabela + " WHERE Key_name = 'PRIMARY'");
    		
    		ResultSet rs = pst.executeQuery();
    		
	        if(rs.next())
	        	nome = rs.getString("Column_name");
	        
    		rs.close();
    		pst.close();
    		con.close();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
        
    	return nome;
    }

	public String getNomeById(int id, String nomeTabela) {
		String nome = null;
		
    	try {
    		Connection con = dataSource.getConnection();
    		
    		String pk = getPrimaryKey(nomeTabela);
    		
    		PreparedStatement pst = con.prepareStatement("SELECT * FROM " + nomeTabela + " WHERE " + pk + " = ?");
    		pst.setInt(1, id);
    		
    		ResultSet rs = pst.executeQuery();
    		
	        if(rs.next())
	        	nome = rs.getString("Nome");
	        
    		rs.close();
    		pst.close();
    		con.close();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
        
    	return nome;
	}
	
	public String getSalaById(int id) {
		String nome = null;
		
    	try {
    		Connection con = dataSource.getConnection();
    		
    		PreparedStatement pst = con.prepareStatement("SELECT * FROM Sala WHERE idSala = ?");
    		pst.setInt(1, id);
    		
    		ResultSet rs = pst.executeQuery();
    		
	        if(rs.next())
	        	nome = "bloco " + rs.getString("bloco") + ", andar " + rs.getInt("andar") + ", sala " + rs.getInt("numSala"); 
	        
    		rs.close();
    		pst.close();
    		con.close();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
        
    	return nome;
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
    		e.printStackTrace();
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
	        	id = rs.getInt("idFuncCad");
	        
    		rs.close();
    		pst.close();
    		con.close();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
        
    	return id;
	}
	
    

}

