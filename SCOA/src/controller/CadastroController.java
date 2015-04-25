package controller;

import java.awt.Component;

import javax.swing.JOptionPane;

import model.AlunosModel;
import model.DisciplinasModel;
import model.FuncionariosModel;
import model.Model;
import model.ProfessoresModel;
import model.SalasModel;
import view.Cadastrar;
import view.CadastrarAluno;
import view.CadastrarDisciplina;
import view.CadastrarFuncionario;
import view.CadastrarProfessor;
import view.CadastrarSala;
import view.View;

public class CadastroController {
	
	Model model;
	View view;
	
	private FuncionariosModel funcionariosModel;
	private AlunosModel alunosModel;
	private ProfessoresModel professoresModel;
	private DisciplinasModel disciplinasModel;
	private SalasModel salasModel;
	
	public CadastroController(Model model, View view) {
		this.model = model;
		this.view = view;
		
		this.funcionariosModel = model.getFuncionariosModel();
		this.alunosModel = model.getAlunosModel();
		this.professoresModel = model.getProfessoresModel();
		this.disciplinasModel = model.getDisciplinasModel();
		this.salasModel = model.getSalasModel();
	}
	
	public void adicionaFuncionario(Component c, int idFuncCad){
		
		CadastrarFuncionario cad = (CadastrarFuncionario) c;
	
    	String nome = cad.getNome();
    	String setor = cad.getSetor();
    	String login = cad.getLogin();
    	String senha = cad.getSenha();
    	
    	if(nome.isEmpty() || setor.isEmpty() || login.isEmpty() || senha.isEmpty()) {
    		alert("Por favor, preencha todos os campos.");
    		return;
    	}
    	
    	if(nome.length() > 45) {
    		alert("O nome não deve ter mais que 45 caracteres!");
    		return;
    	}
    		
    	if(setor.length() > 45) {
    		alert("O setor não deve ter mais que 45 caracteres!");
    		return;
    	}
    		
    	if(login.length() > 20) {
    		alert("O login não deve ter mais que 20 caracteres!");
    		return;
    	}
    	
    	if(senha.length() > 20) {
    		alert("A senha não deve ter mais que 20 caracteres!");
    		return;
    	}
    		
    		
    	
    	funcionariosModel.adiciona(nome, setor, login, senha, idFuncCad);
    	
    	cad.limpaCampos();
    	
    	alert("Funcionário cadastrado!");
    }   
	
    
	public void adicionaAluno(Component c, int idFuncCad){
    	
		CadastrarAluno cad = (CadastrarAluno) c;
		
    	String nome = cad.getNome();
    	String matricula = cad.getMatricula();
    	String login = cad.getLogin();
    	String senha = cad.getSenha();
    	
    	if(nome.isEmpty() || senha.isEmpty() || login.isEmpty() || senha.isEmpty()) {
    		alert("Por favor, preencha todos os campos.");
    		return;
    	}
    	
    	if(nome.length() > 45) {
    		alert("O nome não deve ter mais que 45 caracteres!");
    		return;
    	}
    		
    	if(matricula.length() > 45) {
    		alert("A matrícula não deve ter mais que 45 caracteres!");
    		return;
    	}
    		
    	if(login.length() > 20) {
    		alert("O login não deve ter mais que 20 caracteres!");
    		return;
    	}
    	
    	if(senha.length() > 20) {
    		alert("A senha não deve ter mais que 20 caracteres!");
    		return;
    	}
    	
    	alunosModel.adiciona(nome, matricula, login, senha, idFuncCad);
    	
    	cad.limpaCampos();
    	
    	alert("Aluno cadastrado!");
    }
	
    
	public void adicionaProfessor(Component c, int idFuncCad){
    	
		CadastrarProfessor cad = (CadastrarProfessor) c;
		
    	String nome = cad.getNome();
    	String matricula = cad.getMatricula();
    	String login = cad.getLogin();
    	String senha = cad.getSenha();
    	
    	if(nome.isEmpty() || senha.isEmpty() || login.isEmpty() || senha.isEmpty()) {
    		alert("Por favor, preencha todos os campos.");
    		return;
    	}
    	
    	if(nome.length() > 45) {
    		alert("O nome não deve ter mais que 45 caracteres!");
    		return;
    	}
    		
    	if(matricula.length() > 45) {
    		alert("A matrícula não deve ter mais que 45 caracteres!");
    		return;
    	}
    		
    	if(login.length() > 20) {
    		alert("O login não deve ter mais que 20 caracteres!");
    		return;
    	}
    	
    	if(senha.length() > 20) {
    		alert("A senha não deve ter mais que 20 caracteres!");
    		return;
    	}
    	
    	professoresModel.adiciona(nome, matricula, login, senha, idFuncCad);
    	
    	cad.limpaCampos();
    	
    	alert("Professor cadastrado!");
    }
	
	public void adicionaDisciplina(Component c, int idFuncCad){
    	
		CadastrarDisciplina cad = (CadastrarDisciplina) c;
		
    	String nome = cad.getNome();
    	
    	if(nome.isEmpty()) {
    		alert("Por favor, preencha o campo.");
    		return;
    	}
    	
    	if(nome.length() > 45) {
    		alert("A disciplina não deve ter mais que 45 caracteres!");
    		return;
    	}
    	
    	disciplinasModel.adiciona(nome, idFuncCad);
    	
    	cad.limpaCampos();
    	
    	alert("Disciplina cadastrada!");
    }
	
	public void adicionaSala(Component c, int idFuncCad){
    	
		CadastrarSala cad = (CadastrarSala) c;
		
    	String sala = cad.getSala();
    	String andar = cad.getAndar();
    	String bloco = cad.getBloco();
    	
    	int salaInt = 0;
    	int andarInt = 0;
    	
    	if(sala.isEmpty() || andar.isEmpty() || bloco.isEmpty()) {
    		alert("Por favor, preencha todos os campos.");
    		return;
    	}
    	
    	
    	if(!sala.matches("[0-9]+")) {
    		alert("A sala só pode conter números.");
    		return;
    	}
    	else {
    		try {
    			salaInt = Integer.parseInt(sala);
    			
    			if(salaInt < 0) {
    				alert("O número da sala não pode ser menor que 0!");
    				return;
    			}
    		}
    		catch(Exception e) {
    			alert("O número da sala não deve exceder 2147483647!");
    			return;
    		}
    	}
    	
    	
    	
    	if(!andar.matches("[0-9]+")) {
    		alert("O andar só poder conter números.");
    	}
    	else {
    		try {
    			andarInt = Integer.parseInt(sala);
    			if(andarInt < 0) {
    				alert("O número do andar não pode ser menor que 0!");
    				return;
    			}
    		}
    		catch(Exception e) {
    			alert("O número do andar não deve exceder 2147483647!");
    			return;
    		}
    	}
    	
    	if(bloco.length() > 5) {
    		alert("O bloco não deve ter mais que 5 caracteres!");
    		return;
    	}
    	
    	
    	salasModel.adiciona(salaInt, andarInt, bloco, idFuncCad);
    	
    	cad.limpaCampos();
    	
    	alert("Sala cadastrada!");
    }
	
	
	public void alert(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}
}
