package controller;

import java.awt.Component;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dados.Aluno;
import dados.Disciplina;
import dados.Funcionario;
import dados.Professor;
import dados.Sala;
import dados.Turma;
import model.AlunosModel;
import model.DisciplinasModel;
import model.FuncionariosModel;
import model.Model;
import model.ProfessoresModel;
import model.SalasModel;
import model.TurmasModel;
import view.Cadastrar;
import view.CadastrarAluno;
import view.CadastrarDisciplina;
import view.CadastrarFuncionario;
import view.CadastrarProfessor;
import view.CadastrarSala;
import view.CadastrarTurma;
import view.Listar;
import view.View;

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
