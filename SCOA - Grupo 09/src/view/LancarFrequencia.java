package view;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DateEditor;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.Box;
import java.awt.Component;
import com.jgoodies.forms.layout.Sizes;

public class LancarFrequencia extends Cadastrar {
	private JTextField txtMatricula;
	private JButton btnCadastrar;
	private JLabel lblLogin;
	private JLabel lblSenha;
	private JComboBox comboBoxTurmas;
	private JComboBox comboBoxSalas;
	JSpinner timeSpinner;
	
	private ArrayList<Integer> idsTurmas;
	private ArrayList<Integer> idsAlunos;
	JLabel texto;

	
	JLabel lblNome;
	JLabel lblSetor;
	private JComboBox comboBoxAlunos;
	private JLabel lblFrequncia;
	private Box horizontalBox;
	private JTextField txtFrequencia;
	private JLabel label;
	
	/**
	 * Create the panel.
	 */
	public LancarFrequencia() {
		
		idsTurmas = new ArrayList<>();
		idsAlunos = new ArrayList<>();
		
		
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("97px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("25dlu", true), Sizes.constant("25dlu", true)), 0),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("21px:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		
		texto = new JLabel("Selecione");
		add(texto, "4, 4, 7, 1, left, top");
		
		
		
		lblNome = new JLabel("Turma");
		add(lblNome, "6, 6");
		
		comboBoxTurmas = new JComboBox();
		add(comboBoxTurmas, "8, 6, 3, 1, left, default");
		
		
		
		lblSetor = new JLabel("Aluno");
		add(lblSetor, "6, 8");
		
		comboBoxAlunos = new JComboBox();
		add(comboBoxAlunos, "8, 8, 3, 1, left, default");
		
		lblFrequncia = new JLabel("Frequência");
		add(lblFrequncia, "6, 10");
		
		horizontalBox = Box.createHorizontalBox();
		add(horizontalBox, "8, 10");
		
		txtFrequencia = new JTextField();
		horizontalBox.add(txtFrequencia);
		txtFrequencia.setColumns(1);
		
		JLabel labelP = new JLabel("%");
		horizontalBox.add(labelP);
		
		btnCadastrar = new JButton("Cadastrar");
		add(btnCadastrar, "8, 14, 3, 1, left, default");
	}
	
	public void comErro(String mensagem) {
		texto.setText(mensagem);
		lblNome.setVisible(false);
		lblSetor.setVisible(false);
		comboBoxTurmas.setVisible(false);
		comboBoxAlunos.setVisible(false);
		lblFrequncia.setVisible(false);
		horizontalBox.setVisible(false);
		btnCadastrar.setVisible(false);
	}
	
	public void semErro() {
		texto.setText("Selecione uma das turmas que você leciona, e depois algum aluno dela:");
		lblNome.setVisible(true);
		lblSetor.setVisible(true);
		comboBoxTurmas.setVisible(true);
		comboBoxAlunos.setVisible(true);
		lblFrequncia.setVisible(true);
		horizontalBox.setVisible(true);
		btnCadastrar.setVisible(true);
	}
	
	
	public JButton getBotao() {
		return btnCadastrar;
	}
	
	public JComboBox getComboBoxTurmas() {
		return this.comboBoxTurmas;
	}
	
	public JComboBox getComboBoxAlunos() {
		return this.comboBoxAlunos;
	}
	
	public void addIdTurma(int id) {
		this.idsTurmas.add(id);
	}
	public int getIdTurma(int id) {
		return this.idsTurmas.get(id);
	}
	public void limpaIdTurma() {
		this.idsTurmas.clear();
	}
	
	public void status() {
		alert("tamanho idturmas = " + idsTurmas.size());
	}
	
	
	public String getFrequencia() {
		return this.txtFrequencia.getText();
	}
	
	public void addIdAluno(int id) {
		this.idsAlunos.add(id);
	}
	public int getIdAluno(int id) {
		return this.idsAlunos.get(id);
	}
	public void limpaIdAluno() {
		this.idsAlunos.clear();
	}
	
	public void limpaCampos() {
		this.comboBoxTurmas.setSelectedIndex(-1);
		this.comboBoxAlunos.setSelectedIndex(-1);
		this.txtFrequencia.setText("");
	}
	
	public void limpaCampoAluno() {
		this.comboBoxAlunos.setSelectedIndex(-1);
	}
	
	public String getPauta() {
		return null;
	}
	
	public void alert(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}
}
