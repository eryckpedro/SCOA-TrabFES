package view;

import javax.swing.JPanel;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DateEditor;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SpinnerDateModel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JButton;

import java.awt.GridLayout;

import javax.swing.BoxLayout;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JComboBox;

public class CadastrarTurma extends Cadastrar {
	private JTextField txtMatricula;
	private JButton btnCadastrar;
	private JLabel lblLogin;
	private JLabel lblSenha;
	private JComboBox comboBoxDisciplinas;
	private JComboBox comboBoxProfessores;
	private JComboBox comboBoxSalas;
	JSpinner timeSpinner;
	
	private ArrayList<Integer> idsDisciplinas;
	private ArrayList<Integer> idsProfessores;
	private ArrayList<Integer> idsSalas;

	/**
	 * Create the panel.
	 */
	public CadastrarTurma() {
		
		idsDisciplinas = new ArrayList<>();
		idsProfessores = new ArrayList<>();
		idsSalas = new ArrayList<>();
		
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("78px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("114px:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("1px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("251px"),},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("max(4dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("30px"),
				FormFactory.LINE_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		
		JLabel lblPorVavorEntre = new JLabel("Por favor, entre com as informações da turma que deseja cadastrar:");
		add(lblPorVavorEntre, "4, 4, 7, 1, left, top");
		
		
		
		JLabel lblNome = new JLabel("Disciplina");
		add(lblNome, "6, 6");
		
		comboBoxDisciplinas = new JComboBox();
		add(comboBoxDisciplinas, "8, 6, left, default");
		
		
		
		JLabel lblSetor = new JLabel("Horario");
		add(lblSetor, "6, 8");
		
		// Fonte: https://stackoverflow.com/a/665463
		timeSpinner = new JSpinner( new SpinnerDateModel() );
		DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
		timeSpinner.setEditor(timeEditor);
		timeSpinner.setValue( new GregorianCalendar(0, 0, 0, 10, 0).getTime() );
		
		

		add(timeSpinner, "8, 8, left, default");
		
		
		
		lblLogin = new JLabel("Professor");
		add(lblLogin, "6, 10");
		
		comboBoxProfessores = new JComboBox();
		add(comboBoxProfessores, "8, 10, left, default");
		
		
		
		lblSenha = new JLabel("Sala");
		add(lblSenha, "6, 12");
		
		comboBoxSalas = new JComboBox();
		add(comboBoxSalas, "8, 12, left, default");
		
		
				
		btnCadastrar = new JButton("Cadastrar");
		add(btnCadastrar, "8, 18, left, default");

	}
	
	public JButton getBotao() {
		return btnCadastrar;
	}
	
	public JComboBox getComboBox(int qual) {
		if(qual == 1) return this.comboBoxDisciplinas;
		if(qual == 2) return this.comboBoxProfessores;
		if(qual == 3) return this.comboBoxSalas;
		return null;
	}
	
	public void addIdDisciplina(int id) {
		this.idsDisciplinas.add(id);
	}
	public void addIdProfessor(int id) {
		this.idsProfessores.add(id);
	}
	public void addIdSala(int id) {
		this.idsSalas.add(id);
	}
	
	
	public int getIdDisciplina(int id) {
		return this.idsDisciplinas.get(id);
	}
	public int getIdProfessor(int id) {
		return this.idsProfessores.get(id);
	}
	public int getIdSala(int id) {
		return this.idsSalas.get(id);
	}
	
	
	public void limpaIdDisciplina() {
		this.idsDisciplinas.clear();
	}
	public void limpaIdProfessor() {
		this.idsProfessores.clear();
	}
	public void limpaIdSala() {
		this.idsSalas.clear();
	}
	
	public Date getData() {
		return (Date) this.timeSpinner.getValue();
	}
	
	public void limpaCampos() {
		this.timeSpinner.setValue( new GregorianCalendar(0, 0, 0, 10, 0).getTime() );
		this.comboBoxDisciplinas.setSelectedIndex(-1);
		this.comboBoxProfessores.setSelectedIndex(-1);
		this.comboBoxSalas.setSelectedIndex(-1);
	}
	
	public void alert(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}
}
