package controller;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import model.AlunosModel;
import model.DisciplinasModel;
import model.FuncionariosModel;
import model.Model;
import model.ProfessoresModel;
import model.SalasModel;
import model.TurmasModel;
import view.CadastrarAluno;
import view.CadastrarDisciplina;
import view.CadastrarFuncionario;
import view.CadastrarPauta;
import view.CadastrarProfessor;
import view.CadastrarSala;
import view.CadastrarTurma;
import view.InscricaoTurma;
import view.LancarFrequencia;
import view.LancarMedia;
import view.View;

public class CadastroController {
	
	Model model;
	View view;
	
	private FuncionariosModel funcionariosModel;
	private AlunosModel alunosModel;
	private ProfessoresModel professoresModel;
	private DisciplinasModel disciplinasModel;
	private SalasModel salasModel;
	private TurmasModel turmasModel;
	
	public CadastroController(Model model, View view) {
		this.model = model;
		this.view = view;
		
		this.funcionariosModel = model.getFuncionariosModel();
		this.alunosModel = model.getAlunosModel();
		this.professoresModel = model.getProfessoresModel();
		this.disciplinasModel = model.getDisciplinasModel();
		this.salasModel = model.getSalasModel();
		this.turmasModel = model.getTurmasModel();
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
    	
    	if(nome.length() <= 3) {
    		alert("O nome deve ter mais de 3 caracteres!");
    		return;
    	}
    	
    	if(setor.length() <= 3) {
    		alert("O setor deve ter mais de 3 caracteres!");
    		return;
    	}
    	
    	if(login.length() <= 5) {
    		alert("O login deve ter mais de 5 caracteres!");
    		return;
    	}
    	
    	if(senha.length() <= 5) {
    		alert("A senha deve ter mais de 5 caracteres!");
    		return;
    	}
    	
    	if(!nome.matches("[^0-9]+")) {
    		alert("O nome deve conter apenas letras.");
    		return;
    	}
    	
    	if(model.existeLogin(login, "Funcionario")) {
    		alert("O login escolhido já existe!");
    		return;
    	}
    	
    	if(model.existeNome(nome, "Funcionario")) {
    		alert("Já existe um funcionário com o nome digitado!");
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
    	
    	if(nome.isEmpty() || matricula.isEmpty() || login.isEmpty() || senha.isEmpty()) {
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
    	
     	if(nome.length() <= 3) {
    		alert("O nome deve ter mais de 3 caracteres!");
    		return;
    	}
    	
    	if(matricula.length() <= 3) {
    		alert("A matricula deve ter mais de 3 caracteres!");
    		return;
    	}
    	
    	if(login.length() <= 5) {
    		alert("O login deve ter mais de 5 caracteres!");
    		return;
    	}
    	
    	if(senha.length() <= 5) {
    		alert("A senha deve ter mais de 5 caracteres!");
    		return;
    	}
    	
    	if(!nome.matches("[^0-9]+")) {
    		alert("O nome deve conter apenas letras.");
    		return;
    	}
    	
    	if(model.existeLogin(login, "Aluno")) {
    		alert("O login escolhido já existe!");
    		return;
    	}
    	
    	if(model.existeNome(nome, "Aluno")) {
    		alert("Já existe um aluno com o nome digitado!");
    		return;
    	}
    	
    	if(model.existeMatricula(matricula, "Aluno")) {
    		alert("Já existe um aluno cadastrado com essa matrícula!");
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
    	
    	
     	if(nome.length() <= 3) {
    		alert("O nome deve ter mais de 3 caracteres!");
    		return;
    	}
    	
    	if(matricula.length() <= 3) {
    		alert("A matricula deve ter mais de 3 caracteres!");
    		return;
    	}
    	
    	if(login.length() <= 5) {
    		alert("O login deve ter mais de 5 caracteres!");
    		return;
    	}
    	
    	if(senha.length() <= 5) {
    		alert("A senha deve ter mais de 5 caracteres!");
    		return;
    	}
    	
    	if(!nome.matches("[^0-9]+")) {
    		alert("O nome deve conter apenas letras.");
    		return;
    	}
    	
    	if(model.existeLogin(login, "Professor")) {
    		alert("O login escolhido já existe!");
    		return;
    	}
    	
    	if(model.existeNome(nome, "Professor")) {
    		alert("Já existe um professor com o nome digitado!");
    		return;
    	}
    	
    	if(model.existeMatricula(matricula, "Professor")) {
    		alert("Já existe um professor cadastrado com essa matrícula!");
    		return;
    	}
    	
    	professoresModel.adiciona(nome, matricula, login, senha, idFuncCad);
    	
    	cad.limpaCampos();
    	
    	alert("Professor cadastrado!");
    }
	
	public void adicionaDisciplina(Component c, int idFuncCad){
    	
		CadastrarDisciplina cad = (CadastrarDisciplina) c;
		
		
		int prereqs = cad.getCheckBoxList().getModel().getSize();
		
		ArrayList<Integer> idDisciplinas = new ArrayList<>();

		for(int i = 0; i < prereqs; i++) {
			JCheckBox checkbox = (JCheckBox) cad.getCheckBoxList().getModel().getElementAt(i);
			if(checkbox.isSelected())
				idDisciplinas.add(cad.getIdDisciplina(i));
		}
		
    	String nome = cad.getNome();
    	
    	if(nome.isEmpty()) {
    		alert("Por favor, preencha o campo.");
    		return;
    	}
    	
    	if(nome.length() > 45) {
    		alert("A disciplina não deve ter mais que 45 caracteres!");
    		return;
    	}
    	
    	if(nome.length() <= 3) {
    		alert("A disciplina deve ter mais que 3 caracteres!");
    		return;
    	}
    	
    	
    	if(model.existeNome(nome, "Disciplina")) {
    		alert("Já existe uma disciplina com o nome digitado!");
    		return;
    	}
    	
    	disciplinasModel.adiciona(nome, idFuncCad, idDisciplinas);
    	
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
    		return;
    	}
    	else {
    		try {
    			andarInt = Integer.parseInt(andar);
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
    	
    	if(model.existeSala(salaInt, andarInt, bloco)) {
    		alert("Já existe uma sala com os dados digitados!");
    		return;
    	}
    		
    	
    	salasModel.adiciona(salaInt, andarInt, bloco, idFuncCad);
    	
    	cad.limpaCampos();
    	
    	alert("Sala cadastrada!");
    }
	
	
	public void adicionaTurma(Component c, int idFuncCad){
    	
		CadastrarTurma cad = (CadastrarTurma) c;
		
		int disciplinaSelecionada = cad.getComboBox(1).getSelectedIndex();
		int professorSelecionado = cad.getComboBox(2).getSelectedIndex();
		int salaSelecionada = cad.getComboBox(3).getSelectedIndex();
		
		if(disciplinaSelecionada == -1) {
			alert("Selecione uma disciplina!");
			return;
		}
		
		else if(professorSelecionado == -1) {
			alert("Selecione um professor!");
			return;
		}
		
		else if(salaSelecionada == -1) {
			alert("Selecione uma sala!");
			return;
		}
		
		
		int idDisciplina = cad.getIdDisciplina(disciplinaSelecionada);
		int idProfessor = cad.getIdProfessor(professorSelecionado);
		int idSala = cad.getIdSala(salaSelecionada);
		Date horario = cad.getData();
    
    	
    	if(model.existeTurma(idDisciplina, horario, idProfessor, idSala)) {
    		alert("Já existe uma turma com os dados digitados!");
    		return;
    	}
    	
    	turmasModel.adiciona(idDisciplina, horario, idProfessor, idSala, idFuncCad);
    	
    	cad.limpaCampos();
    	
    	alert("Turma cadastrada!");
    }
	
	
	public void alert(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}

	public void adicionaInscricaoEmTurma(InscricaoTurma c, int idAlunoLogado) {
		int linhaSelecionada = c.getTabela().getSelectedRow();
		
		if(linhaSelecionada == -1) {
			alert("Selecione uma turma para se inscrever!");
			return;
		}
		
		int idTurma = c.getIdTurma(linhaSelecionada);
		
		int idDisciplina = model.getDisciplinaFromTurma(idTurma);
		ArrayList<Integer> preRequisitos = disciplinasModel.listaPreRequisitos(idDisciplina);
		
		String erros = "";
		boolean errado = false;
		
		// verifica se concluiu todos os pré-requisitos
		for(Integer prereq : preRequisitos) {
			if(!alunosModel.concluiuDisciplina(idAlunoLogado, prereq)) {
				errado = true;
				erros += "\nVocê ainda não concluiu \"" + model.getNomeById(prereq, "Disciplina") + "\".";
			}
		}
		
		if(errado) {
			alert("Para se inscrever nessa matéria é necessário concluir todos os pré-requisitos!" + erros);
			return;
		}
		
		if(model.existeInscricao(idAlunoLogado, idTurma)) {
			alert("Você já está inscrito nessa turma!");
			return;
		}
		
		alunosModel.adicionaInscricaoEmTurma(idAlunoLogado, idTurma);
		
		alert("Parabéns! Você se inscreveu em \"" + model.getNomeById(idDisciplina, "Disciplina") + "\".");
	}

	public void adicionaPauta(Component aba) {
		CadastrarPauta c = (CadastrarPauta) aba;
		
		int turmaSelecionada = c.getComboBox().getSelectedIndex();
		
		if(turmaSelecionada == -1) {
			alert("Selecione uma turma!");
			return;
		}
		
		
		int turmaId = c.getIdTurma(turmaSelecionada);
		
		String pauta = c.getPauta();
		
		if(pauta.length() <= 6) {
			alert("A pauta de aula deve ter mais que 5 caracteres!");
			return;
		}
		
		if(pauta.length() > 100) {
			alert("A pauta de aula não deve ter mais que 100 caracteres!");
			return;
		}
		
		turmasModel.adicionaPauta(turmaId, pauta);
		
		alert("A pauta de aula foi salva com sucesso.");
		c.limpaCampos();
		
	}

	public void adicionaFrequencia(Component aba) {
		LancarFrequencia l = (LancarFrequencia) aba;
		String frequencia = l.getFrequencia();

		int turmaSelecionada = l.getComboBoxTurmas().getSelectedIndex();
		int alunoSelecionado = l.getComboBoxAlunos().getSelectedIndex();
		
		if(turmaSelecionada == -1) {
			alert("Selecione uma turma!");
			return;
		}
		
		if(alunoSelecionado == -1) {
			alert("Selecione um aluno!");
			return;
		}
		
		if(frequencia.isEmpty()) {
			alert("Por favor, informe a frequência!");
			return;
		}
	
    	if(!frequencia.matches("[0-9\\.]+")) {
    		alert("A frequência só pode conter números e ponto.");
    		return;
    	}
    	
    	float freq = Float.parseFloat(frequencia);
    	if(!(freq >= 0 && freq <= 100)) {
    		alert("A frequência deve ser um número entre 0 e 100, representando a porcentagem.");
    		return;
    	}

    	
		int turmaId = l.getIdTurma(turmaSelecionada);
		int alunoId = l.getIdAluno(alunoSelecionado);
		
		alunosModel.adicionaFrequencia(turmaId, alunoId, freq);
		alert("Frequencia lançada!");
		l.limpaCampos();
	}

	public void adicionaMedia(Component aba) {
		LancarMedia l = (LancarMedia) aba;
		String media = l.getMedia();

		int turmaSelecionada = l.getComboBoxTurmas().getSelectedIndex();
		int alunoSelecionado = l.getComboBoxAlunos().getSelectedIndex();
		
		if(turmaSelecionada == -1) {
			alert("Selecione uma turma!");
			return;
		}
		
		if(alunoSelecionado == -1) {
			alert("Selecione um aluno!");
			return;
		}
		
		if(media.isEmpty()) {
			alert("Por favor, informe a média!");
			return;
		}
	
    	if(!media.matches("[0-9\\.]+")) {
    		alert("A média só pode conter números e ponto.");
    		return;
    	}
    	
    	float med = Float.parseFloat(media);
    	if(!(med >= 0 && med <= 100)) {
    		alert("A média deve ser um número entre 0 e 10.");
    		return;
    	}

    	
		int turmaId = l.getIdTurma(turmaSelecionada);
		int alunoId = l.getIdAluno(alunoSelecionado);
		int disciplinaId = model.getDisciplinaFromTurma(turmaId);
		
		alunosModel.adicionaMedia(disciplinaId, alunoId, med);
		alert("Média lançada!");
		l.limpaCampos();		
	}
}
