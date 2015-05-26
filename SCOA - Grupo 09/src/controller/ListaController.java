package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;

import model.AlunosModel;
import model.DisciplinasModel;
import model.FuncionariosModel;
import model.Model;
import model.ProfessoresModel;
import model.SalasModel;
import model.TurmasModel;
import view.Cadastrar;
import view.CadastrarDisciplina;
import view.CadastrarPauta;
import view.CadastrarTurma;
import view.CheckBoxList;
import view.InscricaoTurma;
import view.LancarFrequencia;
import view.Listar;
import view.View;
import dados.Aluno;
import dados.Disciplina;
import dados.Funcionario;
import dados.Professor;
import dados.Sala;
import dados.Turma;

public class ListaController {
	
	Model model;
	View view;
	
	private FuncionariosModel funcionariosModel;
	private AlunosModel alunosModel;
	private ProfessoresModel professoresModel;
	private DisciplinasModel disciplinasModel;
	private SalasModel salasModel;
	private TurmasModel turmasModel;
	
	public ListaController(Model model, View view) {
		this.model = model;
		this.view = view;
		
		this.funcionariosModel = model.getFuncionariosModel();
		this.alunosModel = model.getAlunosModel();
		this.professoresModel = model.getProfessoresModel();
		this.disciplinasModel = model.getDisciplinasModel();
		this.salasModel = model.getSalasModel();
		this.turmasModel = model.getTurmasModel();
	}
	
	
	// apaga o conteúdo da tabela
	public void limpaTabela(DefaultTableModel tabela) {
		while(tabela.getRowCount() > 0)
			tabela.removeRow(0);
	}
	
	public void autualizaListaConsultas(JTabbedPane consultasTabbedPane) {
    	int abaNum = consultasTabbedPane.getSelectedIndex();
    	String aba = consultasTabbedPane.getTitleAt(abaNum);
    	
    	Listar l = (Listar) consultasTabbedPane.getComponent(abaNum);
    	
    	if(aba.equals("Funcionário"))     listaFuncionarios(l);
    	else if(aba.equals("Aluno"))      listaAlunos(l);
    	else if(aba.equals("Professor"))  listaProfessores(l);
    	else if(aba.equals("Disciplina")) listaDisciplinas(l);
    	else if(aba.equals("Sala"))       listaSalas(l);
    	else if(aba.equals("Turma"))      listaTurmas(l);
	}
	
	public void autualizaListaConsultasAluno(JTabbedPane consultasTabbedPane, int idAlunoLogado) {
    	int abaNum = consultasTabbedPane.getSelectedIndex();
    	String aba = consultasTabbedPane.getTitleAt(abaNum);
    	
    	Listar l = (Listar) consultasTabbedPane.getComponent(abaNum);
    	
    	// Aluno
    	if(aba.equals("Turmas inscritas"))            listaTurmasInscritas(l, idAlunoLogado);
    	else if(aba.equals("Disciplinas concluídas")) listaDiscConcluidas(l, idAlunoLogado);
	}
	
	
	public void listaFuncionarios(Listar l){
		
		ArrayList<Funcionario> lista = funcionariosModel.lista();
		DefaultTableModel tableModel = (DefaultTableModel) l.getTabela().getModel();
		
		limpaTabela(tableModel);

		for(Funcionario a : lista)
			tableModel.addRow(new Object[]{a.nome, a.setor});
    }   
	
	
	public void listaAlunos(Listar l){
		
		ArrayList<Aluno> lista = alunosModel.lista();
		DefaultTableModel tableModel = (DefaultTableModel) l.getTabela().getModel();
		
		limpaTabela(tableModel);
		
		for(Aluno a : lista)
			tableModel.addRow(new Object[]{a.nome, a.matricula, a.cr});
    }   
	
	public void listaProfessores(Listar l){
		
		ArrayList<Professor> lista = professoresModel.lista();
		DefaultTableModel tableModel = (DefaultTableModel) l.getTabela().getModel();
		
		limpaTabela(tableModel);
		
		for(Professor a : lista)
			tableModel.addRow(new Object[]{a.nome, a.matricula});
    }
	
	public void listaDisciplinas(Listar l){
		
		ArrayList<Disciplina> lista = disciplinasModel.lista();
		DefaultTableModel tableModel = (DefaultTableModel) l.getTabela().getModel();
		
		limpaTabela(tableModel);
		
		for(Disciplina a : lista)
			tableModel.addRow(new Object[]{a.nome});
    }
	
	public void listaSalas(Listar l){
		
		ArrayList<Sala> lista = salasModel.lista();
		DefaultTableModel tableModel = (DefaultTableModel) l.getTabela().getModel();
		
		limpaTabela(tableModel);
		
		for(Sala a : lista)
			tableModel.addRow(new Object[]{a.numSala, a.andar, a.bloco});
    }
	
	public void listaTurmas(Listar l){
		
		ArrayList<Turma> lista = turmasModel.lista();
		DefaultTableModel tableModel = (DefaultTableModel) l.getTabela().getModel();
		
		limpaTabela(tableModel);
		
		for(Turma a : lista) {
			int idDisciplina = a.idDisciplina;
			Date horario     = a.horario;
			int idProfessor  = a.idProfessor;
			int idSala       = a.idSala;
			
			String disciplina = model.getNomeById(idDisciplina, "Disciplina");
			String hora = (new SimpleDateFormat("HH:mm")).format(horario);
			String professor = model.getNomeById(idProfessor, "Professor");
			String sala = model.getSalaById(idSala);
			
			tableModel.addRow(new Object[]{disciplina, hora, professor, sala});
		}
			
			
    }
	
	
	public void listaTurmasInscritas(Listar l, int idAluno){
		
		ArrayList<Turma> lista = turmasModel.listaTurmasInscritas(idAluno);
		DefaultTableModel tableModel = (DefaultTableModel) l.getTabela().getModel();
		
		limpaTabela(tableModel);
		
		for(Turma a : lista) {
			int idDisciplina = a.idDisciplina;
			Date horario     = a.horario;
			int idProfessor  = a.idProfessor;
			int idSala       = a.idSala;
			
			String disciplina = model.getNomeById(idDisciplina, "Disciplina");
			String hora = (new SimpleDateFormat("HH:mm")).format(horario);
			String professor = model.getNomeById(idProfessor, "Professor");
			String sala = model.getSalaById(idSala);
			
			tableModel.addRow(new Object[]{disciplina, hora, professor, sala});
		}
    }
	
	public void listaDiscConcluidas(Listar l, int idAluno){
		
		ArrayList<Disciplina> lista = disciplinasModel.listaDiscConcluidas(idAluno);
		DefaultTableModel tableModel = (DefaultTableModel) l.getTabela().getModel();
		
		limpaTabela(tableModel);
		
		for(Disciplina a : lista) {
			String nome = a.nome;
			String media = Float.toString(a.media);
			
			tableModel.addRow(new Object[]{nome, media});
		}
    }
	
	public void listaTurmasTabela(Listar l){
		
		ArrayList<Turma> lista = turmasModel.lista();
		DefaultTableModel tableModel = (DefaultTableModel) l.getTabela().getModel();
		
		limpaTabela(tableModel);
		
		InscricaoTurma c = (InscricaoTurma) l;
		c.limpaIdTurma();
		
		for(Turma a : lista) {
			int idDisciplina = a.idDisciplina;
			Date horario     = a.horario;
			int idProfessor  = a.idProfessor;
			int idSala       = a.idSala;
			
			String disciplina = model.getNomeById(idDisciplina, "Disciplina");
			String hora = (new SimpleDateFormat("HH:mm")).format(horario);
			String professor = model.getNomeById(idProfessor, "Professor");
			String sala = model.getSalaById(idSala);
			
			tableModel.addRow(new Object[]{disciplina, hora, professor, sala});
			c.addIdTurma(a.id);
		}
			
			
    }
	
	
	public void listaDisciplinasCheckBoxList(CheckBoxList cb, CadastrarDisciplina c){
		
		DefaultListModel listModel = new DefaultListModel();
		cb.setModel(listModel);
		
		ArrayList<Disciplina> lista = disciplinasModel.lista();
		c.limpaIdDisciplina();

		for(Disciplina a : lista) {
			listModel.addElement(new JCheckBox(a.nome));
			c.addIdDisciplina(a.id);
		}
    }
	
	
	public void listaTurmasProfComboBox(JComboBox cb, Cadastrar c, int idProfLogado){
		
		DefaultComboBoxModel cbModel = new DefaultComboBoxModel();
		cb.setModel(cbModel);
		
		ArrayList<Turma> lista = turmasModel.getTurmasByProfessor(idProfLogado);
		
		if(lista.size() == 0) {
			c.comErro("<html>Não há turmas atribuídas você no momento.<br>Você só pode efetuar cadastros e lançamentos em turmas associadas a você.");
		}
		else
			c.semErro();
		
		c.limpaIdTurma();

		for(Turma t : lista) {
			Disciplina d = disciplinasModel.getDisciplina(t.idDisciplina);
			
			String nome = d.nome;
			String hora = (new SimpleDateFormat("HH:mm")).format(t.horario);
			
			cbModel.addElement(nome + " às " + hora);
			c.addIdTurma(t.id);
		}
    }
	
	

	public void listaAlunosLancamentos(JComboBox cb1, JComboBox cb2, Cadastrar c, int idProfLogado) {
		int turmaSelecionada = cb1.getSelectedIndex();
		
		if(turmaSelecionada == -1)
			return;
		
		int turmaId = c.getIdTurma(turmaSelecionada);
		
		DefaultComboBoxModel cbModel = new DefaultComboBoxModel();
		cb2.setModel(cbModel);
		
		ArrayList<Aluno> lista = turmasModel.getAlunosByTurma(turmaId);
		
		if(lista.size() == 0)
			alert("A turma selecionada não possui alunos cadastrados! Por favor, seleciona outra turma.");
		
		c.limpaIdAluno();

		for(Aluno a : lista) {
			cbModel.addElement(a.nome);
			c.addIdAluno(a.id);
		}
		
	}
	
	
	public void listaDisciplinasComboBox(JComboBox cb, CadastrarTurma c){
		
		DefaultComboBoxModel cbModel = new DefaultComboBoxModel();
		cb.setModel(cbModel);
		
		ArrayList<Disciplina> lista = disciplinasModel.lista();
		
		c.limpaIdDisciplina();

		for(Disciplina a : lista) {
			cbModel.addElement(a.nome);
			c.addIdDisciplina(a.id);
		}
    }
	
	public void listaProfessoresComboBox(JComboBox cb, CadastrarTurma c){
		
		DefaultComboBoxModel cbModel = new DefaultComboBoxModel();
		cb.setModel(cbModel);
		
		ArrayList<Professor> lista = professoresModel.lista();
		
		c.limpaIdProfessor();

		for(Professor a : lista) {
			cbModel.addElement(a.nome);
			c.addIdProfessor(a.id);
		}
    }
	
	public void listaSalasComboBox(JComboBox cb, CadastrarTurma c){
		
		DefaultComboBoxModel cbModel = new DefaultComboBoxModel();
		cb.setModel(cbModel);
		
		ArrayList<Sala> lista = salasModel.lista();
		
		c.limpaIdSala();

		for(Sala a : lista) {
			cbModel.addElement("bloco " + a.bloco + ", andar " + a.andar + ", sala " + a.numSala);
			c.addIdSala(a.id);
		}
    }
	
	public void alert(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}



}
