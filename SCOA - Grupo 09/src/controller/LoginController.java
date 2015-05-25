package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Model;
import view.Logado;
import view.LogadoAluno;
import view.LogadoFuncionario;
import view.LogadoProfessor;
import view.Login;
import view.View;

public class LoginController {
	
    private Model model;
    private View view;
    
    private static final int LOGIN_NENHUM      = 0;
    private static final int LOGIN_ALUNO       = 1;
    private static final int LOGIN_PROFESSOR   = 2;
    private static final int LOGIN_FUNCIONARIO = 3;
    
    private boolean logado = false;
    private int tipoLogin = LOGIN_NENHUM;
    private int id = 0;
    
	public LoginController(Model model, View view){
        this.model = model;
        this.view = view;
	}
	
	public void init() {
		Login loginView = (Login) view.getPanel();
		
		// ação do botao do formulário de login
		loginView.getBotao().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {                  
            	login();
            }
    	});
		
		// definir botao padrão (que será pressionado com enter)
		loginView.getRootPane().setDefaultButton(loginView.getBotao());
	}
	
	// retorna se o login foi feito com sucesso
	public boolean login() {
		Login loginView = (Login) view.getPanel();
		
		int tipo     = loginView.getTipo();
		String login = loginView.getLogin();
		String senha = loginView.getSenha();
		
		logado = false;
		tipoLogin = LOGIN_NENHUM;

		if(login.isEmpty()) {
			alert("Por favor, informe o login.");
			return false;
		}
		
		else if(senha.isEmpty()) {
			alert("Por favor, informe a senha.");
			return false;
		}
		
		else if(tipo == LOGIN_NENHUM) {
			alert("Por favor, selecione o tipo de usuário (aluno, professor ou funcionário).");
			return false;
		}
		
		else if(tipo == LOGIN_ALUNO) {
			if(model.loginValido(login, senha, "Aluno")) {
				logado = true;
				tipoLogin = LOGIN_ALUNO;
				
				// mudar pra página de aluno logado
				mudaPagina(new LogadoAluno(), login, "Aluno");
				
				// cria e inicia o controller dos alunos
				AlunosController f = new AlunosController(model, view, id);
				f.init();
			}
		}
		
		else if(tipo == LOGIN_PROFESSOR) {
			if(model.loginValido(login, senha, "Professor")) {
				logado = true;
				tipoLogin = LOGIN_PROFESSOR;
				
				// mudar pra página de aluno logado
				mudaPagina(new LogadoProfessor(), login, "Professor");
				
				// cria e inicia o controller dos professores
				ProfessoresController f = new ProfessoresController(model, view);
				f.init();
			}
		}
		
		else if(tipo == LOGIN_FUNCIONARIO) {

			if(model.loginValido(login, senha, "Funcionario")) {
				logado = true;
				tipoLogin = LOGIN_FUNCIONARIO;
				
				// mudar pra página de aluno logado
				mudaPagina(new LogadoFuncionario(), login, "Funcionario");
								
				// cria e inicia o controller dos funcionários
				FuncionariosController f = new FuncionariosController(model, view, id);
				f.init();
			}
		}
		
		
		if(tipo != LOGIN_NENHUM && !logado)
			alert("O usuário ou senha que você digitou está incorreto.");

		return logado;
	}
	
	public void mudaPagina(Logado pagina, String login, String tabela) {
		
		view.substituiPanel(pagina); 
		
		Logado panel = (Logado) view.getPanel();
		
		id = model.getId(login, tabela);
		
		// nome no header
		panel.setNome(model.getNome(login, tabela));
		
		// botao de logout
		panel.getBotaoLogout().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {                  
            	logout();
            }
    	});
	}
	
	public void preparaHeader(String login, String tabela) {

	}
	
	
	public void alert(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}
	
	public boolean isLogado() {
		return this.logado;
	}
	
	public int tipoLogin() {
		return this.tipoLogin;
	}
	
	
	public void logout() {
		logado = false;
		tipoLogin = LOGIN_NENHUM;
		view.substituiPanel(new Login());
		init();
	}
	
	
	// TODO remover
	public void testeRapido() {
		
		Login l = (Login) view.getPanel();
		l.testeRapido();
		login();
	}
	
	// TODO remover
	public void testeRapidoAluno() {
		
		Login l = (Login) view.getPanel();
		l.testeRapidoAluno();
		login();
	}
	
	
}
